package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public abstract class ByteCode {

    // initializes bytecode
    public abstract void init(ArrayList<String> args);

    // executes the virtual machine
    public abstract void execute(VirtualMachine virtualMachine);

    // public abstract String toString();

}
