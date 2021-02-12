package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends JumpCode{
 
    private String label;
    private int target;
    
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        
        if (vm.pop() == 0){
            vm.setProgramCounter(target);
        }
    }
    
    public int getTarget(){
        return target;
    }
    
    public void setTarget(int i){
        target = i;
    }
    
    public String getLabel(){
        return label;
    }
    
    public String toString(){
        return "FALSEBRANCH " + label;
    }
    
    
}
