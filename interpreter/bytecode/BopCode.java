package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode{
    
    private String operator;
    
    public void init(ArrayList<String> args){
        operator = args.get(0);
    }
    
    public void execute(VirtualMachine vm){
        
        int operandTwo = vm.pop();
        int operandOne = vm.pop();
        int result = 0;

        switch(operator) {

            case "+":
                result = operandOne + operandTwo;
                break;

            case "-":
                result = operandOne - operandTwo;
                break;

            case "/":
                result = operandOne / operandTwo;
                break;

            case "*":
                result = operandOne * operandTwo;
                break;

            case "==":
                if(operandOne == operandTwo)
                    result = 1;
                else
                    result = 0;
                break;

            case "!=":
                if(operandOne != operandTwo)
                    result = 0;
                else
                    result = 1;
                break;

            case "<=":
                if(operandOne <= operandTwo)
                    result = 1;
                else
                    result = 0;
                break;

            case ">":
                if(operandOne > operandTwo)
                    result = 1;
                else
                    result = 0;
                break;

            case ">=":
                if(operandOne >= operandTwo)
                    result = 1;
                else
                    result = 0;
                break;

            case "<":
                if(operandOne < operandTwo)
                    result = 1;
                else
                    result = 0;
                break;

            case "|":
                if(operandOne == 0 && operandTwo == 0)
                    result = 0;
                else
                    result = 1;
                break;

            case "&":
                if(operandOne == 1 && operandTwo == 1)
                    result = 1;
                else
                    result = 0;
                break;
        }

        vm.push(result);
    }

    public String toString(){
        return "BOP " + operator;
    }
}
