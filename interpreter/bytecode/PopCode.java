package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode{

    protected int popValue;

    public void init(ArrayList<String> args){
        popValue = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm){

        for(int i = 0; i < popValue; i++) {
            if(vm.isEmpty())
                break;
            vm.pop();
        }

    }

    public String toString(){
        return "POP " + popValue;
    }

}

