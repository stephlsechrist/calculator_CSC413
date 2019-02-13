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
  public Operand( String token ) {
  }
  /**
   * construct operand from integer
   */
  public Operand( int value ) {
    this.number = value;
    return this.number;
  }
  /**
   * return integer value of opernad
   */
  public int getValue() {
      return this.number;
  }

  public int getNumber() {
    return number;
  }

  /**
   * Check to see if given token is a valid
   * operand. returns true if valid
   */
  public static boolean check( String token ) {


    return false;
  }
}
