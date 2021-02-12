package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode{

    private int num;

    public void init(ArrayList<String> args){
        num = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm){
        vm.newFrameAt(num);
    }

    public String toString(){
        return "ARGS " + num;
    }
}
