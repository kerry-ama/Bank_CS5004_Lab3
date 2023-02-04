package bank;

/**
 * THis interface represents a bank account. It is the super-type for
 * any other type of traditional account a bank might offer.
 */
public interface IAccount {

  /**
   * This method takes in a single parameter that represents the
   * amount deposited into the account object.
   * @param amount represents the amount deposited into the account.
   */
  void deposit(double amount);

  /**
   * This method reduces the account balance by the amount specified.
   * Returns a boolean true if the withdrawal is successful, otherwise,
   * returns false. An unsuccessful withdrawal is the attempt to withdraw
   * an amount that is greater than the current account balance or withdrawing
   * an amount that is less than $0.01.
   * @param amount represents the amount withdrawn from the account
   * @return returns boolean true if the withdrawal is successful or
   *         returns boolean false if the withdrawal is unsuccessful
   */
  boolean withdraw(double amount);


  //This method returns the current account balance in US dollars.
  double getBalance();

  /**
   * This method charges any fees and then resets transaction
   * counters to zero.
   */
  void performMonthlyMaintenance();


}
