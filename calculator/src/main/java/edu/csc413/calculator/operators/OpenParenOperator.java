package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class OpenParenOperator extends Operator{
    static boolean isUsed;

    // priority of "(" changes using static flag, depending on when we see it
    @Override
    public int priority(){
        // first time encountering "(", so at beginning of new expression
        if (!isUsed()){
            //used = true;
            return 4;
        }
        // encountering "(" again, so want to make sure we pop it off before continuing
        // through the expression; priority 0 to match ")" so we make sure it's popped
        if (isUsed()){
            //used = false;
            return 0;
        }
        return 0;
    }

    @Override
    // shouldn't run at all if my algorithm is correct
    public Operand execute(Operand op1, Operand op2){
        return null;
    }

    private static boolean isUsed(){
        boolean hasEntered = true;
        return hasEntered;
    }
}
