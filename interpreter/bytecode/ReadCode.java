package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCode extends ByteCode{
    
    private String input;
    
    public void init(ArrayList<String> args){
        
    }
    
    public void execute(VirtualMachine vm){

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter an integer: ");
            input = in.readLine();
            int n = Integer.parseInt(input);
            vm.push(n);
        } catch(Exception e){
            System.out.println("Integer input error.");
        }
    }
    
    public String toString() {
        return "READ " + input;
    }
}
