/* *************************************************
Operand.java

Created by: Stephanie Sechrist
Last Edited: February 14, 2019

implemented the following:
Operand constructor from an int
Operand constructor from String token
getValue(): int
check(String token): boolean
************************************************* */

package edu.csc413.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    private int number;

    /**
     * construct operand from string token.
     */
    public Operand(String token) {
        number = Integer.parseInt(token);
    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        number = value;
    }

    /**
     * return integer value of operand
     */
    public int getValue() {
        return number;
    }

    /**
     * Check to see if given token is a valid
     * operand. returns true if valid
     */
    public static boolean check(String token) {
        try {
            int test = Integer.parseInt(token);
//            System.out.println("Operand - Token is an operand");
            return true;
        } catch (NumberFormatException error) {
//            System.out.println("Operand - Token is not an operand");
            return false;
        }
    }
}