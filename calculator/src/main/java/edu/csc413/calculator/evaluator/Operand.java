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
  // need to use a [data structure] (haven't decided which one yet),
  // because we need to be able to access the operand, which might
  // be constructed from string or an int
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
      int check = Integer.parseInt(token);
      System.out.println("Operand - Token is an operand");
      return true;
    } catch (NumberFormatException error) {
      System.out.println("Operand - Token is not an operand");
      return false;
    }
  }
}