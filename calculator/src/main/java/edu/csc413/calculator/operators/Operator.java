package edu.csc413.calculator.operators;


import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // "Hashmap has all operators stored as values, keyed by their token"
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // static HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    // use static block initializer; only want to initialize operators once,
    // but not allowed to use init function
    private static HashMap<String, Operator> operators = new HashMap<String, Operator>();

    static {
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new OpenParenOperator());
        operators.put(")", new CloseParenOperator());
    }

    //returns precedence of operator
    public abstract int priority();

    // performs mathematical calculation dependent on type
    public abstract Operand execute(Operand op1, Operand op2);


    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     * for example token.equals("+") and so on.
     * Think about what happens if we add more operators.
     * "Returns true if specified token is an operator"
     */
    public static boolean check(String token) {
//        System.out.println("Operator - Checking operator");
/*
        // initially used Operand.check(token) to check if token was an int
        // if so, not a valid operator
        // want to avoid coupling, so went back to try-catch block
        if (!Operand.check(token)){
//            System.out.println("Operator - Operator is not a number, so a valid operand");
            return true;
        }
//        System.out.println("Operator - Operator is a number, not operand");
        return false;
*/

/*        // if not a number, probably a valid operator, as our calculator GUI will only have proper operators
          // later during testing, double failed. need another approach
        try {
            double numberDouble = Double.parseDouble(token);
            int numberInt = Integer.parseInt(token);
//            System.out.println("Operator - Token is an operand");
            return false;
        } catch (NumberFormatException error) {
//            System.out.println("Operator - Token is not an operand; valid operator");
            return true;
        }*/


        // even better, if operator found in HashMap and is able to execute,
        // it's a valid operator
        try {
//            System.out.println("Enter try block");
//            Operand op1 = new Operand(1);
//            Operand op2 = new Operand(1);
            Operator test = operators.get(token);
            test.execute(new Operand(1), new Operand(1));
//            System.out.println("Operator found priority :" + test.priority());
//            System.out.println("Operator - Token found in HashMap; success");
            return true;
        } catch (NullPointerException error) {
//            System.out.println("Operator - Token not found in HashMap; fail");
            return false;
        }

    }


    public static Operator getOperator(String token) {
        return operators.get(token);
    }
}
