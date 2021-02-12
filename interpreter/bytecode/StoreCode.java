package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode{
    
    private int offset, value;
    private String id;
    
    public void init(ArrayList<String> args){
        offset = Integer.parseInt(args.get(0));
        id = args.get(1);
    }
    
    public void execute(VirtualMachine vm){
        value = vm.peek();
        vm.store(offset);
    }
    
    public String toString(){
        return "STORE " + offset + " " + id + " " + id + " = " + value;
    }
}
