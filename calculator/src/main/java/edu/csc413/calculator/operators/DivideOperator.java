/* *************************************************
DivideOperator.java

Created by: Stephanie Sechrist
Last Edited: February 12, 2019

Child class/subclass of Operator.
priority(): int
execute(Operand op1, Operand op2): Operand
************************************************* */

package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class DivideOperator extends Operator{
    @Override
    public int priority(){
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2){
        return new Operand(op1.getValue() / op2.getValue());
    }
}
