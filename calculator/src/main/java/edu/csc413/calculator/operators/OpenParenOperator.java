package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class OpenParenOperator extends Operator{
//    static boolean isUsed;

    @Override
    public int priority(){
        return 0;
    }

    @Override
    // shouldn't run at all if my algorithm is correct
    public Operand execute(Operand op1, Operand op2){
        System.out.println("in OpenParenOperator execute method");
        return null;
    }
}
