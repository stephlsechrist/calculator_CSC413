package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class CloseParenOperator extends Operator{
    @Override
    // don't want to push ")" to stack, so priority needs
    // to be less than all the others to evaluate expression
    // in parentheses
    public int priority(){
        return 0;
    }

    @Override
    // when we get to ), don't want to add to stack
    // just want to execute until ) found
    // if my algorithm is right, this should never run
    public Operand execute(Operand op1, Operand op2){
        return null;
    }
}
