package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator{
    @Override
    public int priority(){
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2){
        // Math.pow needs doubles so we cast op2 and op1 to double
        // Operand requires int, so cast resulting double back to int
        return new Operand((int)Math.pow((double)op1.getValue(), (double)op2.getValue()));
    }
}
