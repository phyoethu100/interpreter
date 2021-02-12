package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode{
    
    protected String id;
    protected int value;
    
    public void init(ArrayList<String> args){

        value = Integer.parseInt(args.get(0));

        if(args.size() > 1){
            id = args.get(1);
        }
    }
    
    public void execute(VirtualMachine vm) {
        vm.push(value);
    }
    
    public String toString() {
        String base = "LIT " + value;

        if (this.id != null) {
            base = base + " " + id + "   int " + id;
        }
        return base;
    }

}
