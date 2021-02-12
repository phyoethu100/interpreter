package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends JumpCode{
    
    private int address;
    private String label;
    
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        vm.pushReturnAddress(vm.getProgramCounter());
        vm.setProgramCounter(address);
    }
    
    public int getTarget(){
        return address;
    }
    
    public String getLabel(){
        return label;
    }
    
    public void setTarget(int i){
        address = i;
    }
    
    public String toString(){
        return "CALL " + label + "   " + label + "(" + ")";
    }
}
