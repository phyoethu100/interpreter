package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode{
    
    protected String id;
    protected int value;
    
    public void init(ArrayList<String> args){

        if(args.size() > 1)
            id = args.get(1);

        value = Integer.parseInt(args.get(0));
    }
    
    public void execute(VirtualMachine vm){
        vm.load(value);
    }
    
    public String toString(){
        if(id.equals(""))
            return "LOAD " + value;
        else
            return "LOAD " + value + " " + id;
    }
}
