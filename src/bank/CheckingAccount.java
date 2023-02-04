package bank;

/**
 * This class represents a checking account. It offers all teh
 * operations mandated by the IAccount interface.
 */
public class CheckingAccount extends AbstractAccount {
  //private double fees;
  private static final double MIN_BALANCE = 100.00;
  private static final double MAINTENANCE_FEE = 5.00;


  /**
   * Constructs a checking account object using a starting account balance.
   * @param balance the starter amount added to the checking account
   *                opening
   * @throws IllegalArgumentException if the starter amount is less than $0.01.
   */
  public CheckingAccount(double balance) throws IllegalArgumentException {
    super(balance);
    if (this.balance < MIN_BALANCE) {
      this.fees = MAINTENANCE_FEE;
    }
  }

  /**
   * Returns the current balance in the account object in US dollars. If
   * the current balance is below $100.00, a $5.00 fee will be added
   * to the checking account.
   * @return the current account balance in US dollars.
   */
  @Override
  public double getBalance() {
    if (this.balance < MIN_BALANCE) {
      this.fees = MAINTENANCE_FEE;
      return this.balance;
    }
    return this.balance;
  }




}
