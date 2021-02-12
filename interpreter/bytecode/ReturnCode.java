package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    
    private String label;
    private int value;
    
    public void init(ArrayList<String> args){

        if(args.size() > 0)
            label = args.get(0);
        else
            label = null;
    }
    
    public void execute(VirtualMachine vm){
        vm.setProgramCounter(vm.popReturnAddress());
        vm.popFrame();
        value = vm.peek();
    }
    
    public String toString(){

        if(label == null)
            return "RETURN ";
        else 
            return "RETURN " + label;

    }
}
