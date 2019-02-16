/* *************************************************
OpenParenOperator.java

Created by: Stephanie Sechrist
Last Edited: February 14, 2019

Child class/subclass of Operator.
priority(): int
execute(Operand op1, Operand op2): Operand
************************************************* */

package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class OpenParenOperator extends Operator{

    // need low priority so that we continue adding operators
    // after encountering "("
    @Override
    public int priority(){
        return 0;
    }

    @Override
    // shouldn't run at all if my algorithm is correct
    // ended up needing to return an Operand here so that my check in
    // Operator.java works.
    public Operand execute(Operand op1, Operand op2){
//        System.out.println("in OpenParenOperator execute method");
        return op1;
    }
}
