package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack()
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){
        Iterator iter = framePointer.iterator();
        int nextFrame, currentFrame = (Integer) iter.next();

        for (int i = 0; i < framePointer.size(); i++) {

            if (iter.hasNext()) {
                nextFrame = (Integer) iter.next();
            } else {
                nextFrame = runTimeStack.size();
            }

            System.out.print("[");

            for (int j = currentFrame; j < nextFrame; j++) {
                System.out.print(runTimeStack.get(j));

                if (j != nextFrame - 1) {
                    System.out.print(",");
                }
            }

            System.out.print("]");
            currentFrame = nextFrame;
        }
        System.out.println();

    }

    public int size(){
        return runTimeStack.size();
    }

    public int peek(){
        int tmp = (Integer)runTimeStack.get(runTimeStack.size() - 1);
        return tmp;
    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    public int pop(){
        int tmp = (Integer)runTimeStack.get(this.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return tmp;
    }

    public int store(int offset){
        int tmp = (Integer)runTimeStack.get(this.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, tmp);
        return tmp;
    }

    public int load(int offset){
        int tmp = (Integer)runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(tmp);
        return tmp;
    }

    public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame(){
        int tmp = this.peek();
        int fp = framePointer.pop();

        for(int i = runTimeStack.size() - 1; i >= fp; i--){
            runTimeStack.remove(i);
        }
        runTimeStack.add(tmp);

    }

    public boolean isEmpty() {
        return runTimeStack.isEmpty();
    }


}
