package edu.csc413.calculator.evaluator;


import edu.csc413.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/()";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {
        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators


        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                System.out.println("Eval - is tokenizer a space?");
                // check if token is an operand
                System.out.println(token);
                if (Operand.check(token)) {
                    System.out.println("Eval - token is operand; push on stack\n");
                    operandStack.push(new Operand(token));
                } else {
                    System.out.println("Eval - not operand, is operator");
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        throw new RuntimeException("*****invalid token******");
                    }

                    // if token is ), that means we need to backtrack through expression until we
                    // reach (, but not add ) to stack
                    else if (token.equals(")")) {
                        while (operatorStack.peek().priority() != 0) {
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }
                        operatorStack.pop();
                    } else {
                        // TODO Operator is abstract - these two lines will need to be fixed:
                        // The Operator class should contain an instance of a HashMap,
                        // and values will be instances of the Operators.  See Operator class
                        // skeleton for an example.
                        Operator newOperator = Operator.getOperator(token);
                        //Operator newOperator = new Operator();

                        if (!token.equals("(")) {
                            while (!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority()) {
                                System.out.println("Eval - Enter while loop: operator stack not empty & priority okay");
                                // note that when we eval the expression 1 - 2 we will
                                // push the 1 then the 2 and then do the subtraction operation
                                // This means that the first number to be popped is the
                                // second operand, not the first operand - see the following code
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute(op1, op2));
/*
              while (token.equals(")") && (oldOpr.priority() != 0)){
                System.out.println("Enter while loop for inside paren");
                Operand op2 = operandStack.pop();
                System.out.println("popped operand");
                Operand op1 = operandStack.pop();
                System.out.println("popped another operand");
                operandStack.push(oldOpr.execute(op1, op2));
                System.out.println("pushed executed operand");
                System.out.println(operandStack.peek().getValue());
                oldOpr = operatorStack.pop();
                System.out.println(oldOpr.priority());
              }*/
                            }
                        }

                        if (!token.equals(")")) {
                            System.out.println("Eval - Push operator on operator stack\n");
                            operatorStack.push(newOperator);
                        }
                    }
                }
            }
        }


        // Control gets here when we've picked up all of the tokens; you must add
        // code to complete the evaluation - consider how the code given here
        // will evaluate the expression 1+2*3
        // When we have no more tokens to scan, the operand stack will contain 1 2
        // and the operator stack will have + * with 2 and * on the top;
        // In order to complete the evaluation we must empty the stacks (except
        // the init operator on the operator stack); that is, we should keep
        // evaluating the operator stack until it only contains the init operator;
        // Suggestion: create a method that takes an operator as argument and
        // then executes the while loop.

//        System.out.println("Eval - reached end of expression");
 //       System.out.println("Eval - evaluate what's left in stacks");
//    System.out.println("Eval - " + operatorStack.peek() + operandStack.peek());
        while (!operatorStack.isEmpty() && !operandStack.isEmpty()) {
            Operator opr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push(opr.execute(op1, op2));
        }

        int finalResult = operandStack.pop().getValue();
        return finalResult;
    }
}
