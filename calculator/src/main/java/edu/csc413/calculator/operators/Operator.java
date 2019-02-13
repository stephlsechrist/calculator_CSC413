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
    static{
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
        operators.put("^", new PowerOperator());
//        operators.put("(", new openParenOperator());
//        operators.put(")", new closeParenOperator());
    }

    //returns precedence of operator
    public abstract int priority();

    // performs mathematical calculation dependent on type
    public abstract Operand execute(Operand op1, Operand op2 );


    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     * for example token.equals("+") and so on.
     * Think about what happens if we add more operators.
     * "Returns true if specified token is an operator"
     */
    public static boolean check( String token ) {
        if (operators.containsValue(token)){
            return true;
        }
        return false;
    }


    public static Operator getOperator(String token){


        return null;
    }
}
