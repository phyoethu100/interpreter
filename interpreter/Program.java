package interpreter;

import interpreter.bytecode.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String,Integer> address = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void addCode(ByteCode bytecode){
        if(bytecode instanceof LabelCode){
            LabelCode label = (LabelCode)bytecode;
            address.put(label.getLabel(), program.size());
        }
        program.add(bytecode);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */

    public void resolveAddress() {

        for(int i = 0; i < program.size(); i ++){
            if(program.get(i) instanceof JumpCode){
                JumpCode tmp = (JumpCode)program.get(i);
                int jump = address.get(tmp.getLabel());
                tmp.setTarget(jump);
            }
        }
    }

}
