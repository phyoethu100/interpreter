package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public abstract class JumpCode extends ByteCode{

    @Override
    public abstract void init(ArrayList<String> args);

    @Override
    public abstract void execute(VirtualMachine vm);

    public abstract int getTarget();

    public abstract String getLabel();

    public abstract void setTarget(int index);

}
