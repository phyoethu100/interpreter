package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode{
    
    protected String dump;

    @Override
    public void init(ArrayList<String> args){
        dump = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
        if(dump.equals("ON")){
            vm.setDump(true);
        }
        else if(dump.equals("OFF")){
            vm.setDump(false);
        }
    }
    
    public String toString(){
        return "DUMP " + dump;
    }
}
