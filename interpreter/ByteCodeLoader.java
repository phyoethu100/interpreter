package interpreter;

import interpreter.bytecode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given bytecode from CodeTable
     *      create an instance of the bytecode class name returned from code table.
     *      Parse any additional arguments for the given bytecode and send them to
     *      the newly created bytecode instance via the init function.
     */
    public Program loadCodes() {

        Program program = new Program();
        ArrayList<String> args = new ArrayList<String>();

        ByteCode code;

        try {
            String line = byteSource.readLine();

            while(line != null){

                StringTokenizer token = new StringTokenizer(line);
                String newToken = token.nextToken();
                String className = CodeTable.getClassName(newToken);

                code = (ByteCode) Class.forName("interpreter.bytecode." + className).newInstance();

                while(token.hasMoreTokens()){
                    args.add(token.nextToken());
                }

                code.init(args);
                program.addCode(code);
                args.clear();

                line = byteSource.readLine();
            }

        } catch (Exception e){
            System.out.println("Exception error occurred: " + e);
        }

        try{
            program.resolveAddress();
        } catch (Exception e){
            System.out.println("resolveAddress error occurred." + e);
        }

        return program;
    }
}
