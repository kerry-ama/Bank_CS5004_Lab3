package bank;

/**
 * This class represents a savings account. It offers all the
 * operations mandated by the IAccount interface. This class also
 * initializes the number of withdrawals counter as well as
 * includes the transaction penalty of $14.00 as a constant
 * and will be applied to the account if the number of withdrawals
 * exceeds 6 within a given month.
 */
public class SavingsAccount extends AbstractAccount {
  private int numOfWithdrawals;
  private static final double TRANSACTION_PENALTY = 14.00;

  /**
   * Constructs a SavingsAccount object by utilizing the AbstractAccount
   * implementation. Therefore, if the starter balance is less than $0.01,
   * an IllegalArgumentException will be thrown. In addition, sets the number
   * of withdrawals counter to zero
   * @param balance the starter amount placed in the account
   * @throws IllegalArgumentException if the starter balance is less than $0.01
   */
  public SavingsAccount(double balance) throws IllegalArgumentException {
    super(balance);//ASK TA if use of super is correct
    this.numOfWithdrawals = 0;
    if (this.numOfWithdrawals > 6) {
      this.fees = TRANSACTION_PENALTY;
    }

  }

  /**
   * Reduces the account balance by the amount specified and returns
   * boolean true if amount is valid, otherwise, returns false if the
   * desired amount to be withdrawn from the account is less than
   * $0.01 and/or the amount is greater than the current account balance.
   * In addition, increases the number of withdrawals counter by one.
   * If the counter exceeds 6, the transaction penalty fee will be added.
   * @param amount represents the amount withdrawn from the account
   * @return boolean true if withdrawal is successful, otherwise, returns
   * boolean false
   */
  @Override
  public boolean withdraw(double amount) {
    if ((amount > this.balance) || (amount < MINIMUM)) {
      return false;
    }
    this.numOfWithdrawals = this.numOfWithdrawals + 1;
    System.out.println(numOfWithdrawals);
    if (this.numOfWithdrawals > 6) {
      //this.fees += TRANSACTION_PENALTY;
      this.fees = TRANSACTION_PENALTY;
    }
    this.balance = this.balance - amount;
    return true;
  }

  /**
   * Assesses monthly fees and deducts the total from the account's balance
   * and gives a clean slate for the subsequent month. Sets the number
   * of withdrawals back to zero.
   */
  @Override
  public void performMonthlyMaintenance() {
    //if (this.numOfWithdrawals > 6) {
      //this.fees = TRANSACTION_PENALTY;
    //}
    //System.out.println(this.fees);
    this.balance = this.balance - this.fees;
    this.numOfWithdrawals = 0;
    this.fees = 0;

  }
}
