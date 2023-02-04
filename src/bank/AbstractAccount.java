package bank;

import java.text.DecimalFormat;

/**
 * This abstract class represents a bank account. This class
 * implements the methods defined in the IAccount interface. The attributes
 * include the account's balance (double) as well as fees (double) that
 * will be deducted from account balance at monthly maintenance.
 * The constant, MINIMUM, represents the minimum amount of money needed to
 * open up an account.
 */
public abstract class AbstractAccount implements IAccount {
  protected double balance;
  protected double fees; //Ask TA if needs to be in construct
  protected static final double MINIMUM = 0.01;

  /**
   * Constructs an account with the starter balance that needs to
   * be greater than or equal to $0.01.
   * @param balance the starter amount of money to open the account
   * @throws IllegalArgumentException if the starter balance is less than $0.01
   */
  public AbstractAccount(double balance) throws IllegalArgumentException {
    if (balance < MINIMUM) {
      throw new IllegalArgumentException("Invalid amount");
    }
    this.balance = balance;
    this.fees = 0;
  }

  /**
   * Takes in a single parameter, amount, that represents the amount to be
   * deposited in the account. If the amount is less than $0.01, the
   * IllegalArgumentException will be thrown.
   * @param amount represents the amount deposited into the account.
   * @throws IllegalArgumentException if the desired amount to be deposited
   *         into the account is less than $0.01.
   */
  public void deposit(double amount) throws IllegalArgumentException {
    double minimum = 0.00;
    if (amount < minimum) {
      throw new IllegalArgumentException("Invalid deposit amount");
    }
    this.balance = this.balance + amount;
  }

  /**
   * Reduces the account balance by the amount specified and returns
   * boolean true if amount is valid, otherwise, returns false if the
   * desired amount to be withdrawn from the account is less than
   * $0.01 and/or the amount is greater than the current account balance.
   * @param amount represents the amount withdrawn from the account
   * @return boolean true if desired amount to be withdrawn is valid,
   *         returns boolean false, if desired amount to be withdrawn
   *         is invalid.
   */
  public boolean withdraw(double amount) {
    if ((amount > this.balance) || (amount < MINIMUM)) {
      return false;
    }
    this.balance = this.balance - amount;
    return true;
  }
  //ASK TA when to use protected vs private vs public vs default
  //access modifiers

  /**
   * Returns the current balance in the account object in US dollars.
   * @return the current account balance in US dollars.
   */
  public double getBalance() {
    return this.balance;
  }

  /**
   * Assesses monthly fees and deducts the total from the account's balance
   * and gives a clean slate for the subsequent month.
   */
  public void performMonthlyMaintenance() {
    this.balance = this.balance - this.fees;
    this.fees = 0;

  }

  /**
   * Returns a formatted string that contains the balance of this object.
   * The string is in the format: $0.00.
   * @return the formatted string of the dollar amount balance of this object.
   */
  public String toString() {
    DecimalFormat balance = new DecimalFormat("$0.00");
    return balance.format(getBalance());
  }
}
