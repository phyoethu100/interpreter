package interpreter;

import java.util.Stack;
import interpreter.bytecode.*;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private int pc;
    private Stack returnAddress;
    private boolean isRunning;
    private boolean dump;
    private Program program;

    protected VirtualMachine(Program program) {
        this.program = program;

    }
    /**This function get each bytecode from program and execute them according to each
     * execute function.
     */
    public void executeProgram(){
        pc = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack();
        isRunning = true;
        dump = true;

        while(isRunning){
            ByteCode bytecode = program.getCode(pc);
            bytecode.execute(this);
            if(dump && !(bytecode instanceof DumpCode)){
                System.out.println(bytecode.toString());
                runTimeStack.dump();
            }
            pc++;
        }
    }

    public void setIsRunning(boolean i) {
        isRunning = i;
    }

    public int getProgramCounter(){
        return pc;
    }

    public void setProgramCounter(int i){
        pc = i;
    }

    public int peek(){
        return runTimeStack.peek();
    }

    public int pop(){
        return runTimeStack.pop();
    }

    public int push(int i){
        return runTimeStack.push(i);
    }

    public int load(int i){
        return runTimeStack.load(i);
    }

    public int store(int i){
        return runTimeStack.store(i);
    }

    public void newFrameAt(int offset){
        runTimeStack.newFrameAt(offset);
    }

    public void popFrame(){
        runTimeStack.popFrame();
    }

    public void pushReturnAddress(int n){
        returnAddress.push(n);
    }

    public int popReturnAddress(){
        return (Integer)returnAddress.pop();
    }

    public void setDump(boolean i){
        dump = i;
    }

    public boolean isEmpty(){
        return runTimeStack.isEmpty();
    }
}
