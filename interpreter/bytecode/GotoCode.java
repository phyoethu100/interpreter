package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends JumpCode {

    private int target;
    private String label;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(target);
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int i) {
        target = i;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        return "GOTO " + label;
    }

}
