import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import bank.CheckingAccount;
import org.junit.Before;
import org.junit.Test;


/**
 * This class tests the methods of the 'CheckingAccount' class.
 */
public class TestCheckingAccount {
  private CheckingAccount Kwame;
  private CheckingAccount Kofi;
  private CheckingAccount John;

  /**
   * Creates Checking Account object instances.
   */
  @Before
  public void setUp() {
    Kwame = new CheckingAccount(1.00);
    Kofi = new CheckingAccount(10000.00);
    John = new CheckingAccount(0.02);
  }

  /**
   * Tests instances where the starting balance is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadSetUp() {
    CheckingAccount Bill = new CheckingAccount(0);
    CheckingAccount George = new CheckingAccount(0.009);
    CheckingAccount Lincoln = new CheckingAccount(-10054.50);
  }

  /**
   * Tests the 'deposit' method.
   */
  @Test
  public void testValidDeposit() {
    Kwame.deposit(0.50);
    Kofi.deposit(1000.00);
    John.deposit(0.01);
    assertEquals(1.50, Kwame.getBalance(), 0.001);
    assertEquals(11000.00, Kofi.getBalance(), 0.001);
    assertEquals(0.03, John.getBalance(), 0.001);
  }

  /**
   * Tests the 'withdraw' method.
   */
  @Test
  public void testWithdrawals() {
    assertFalse(Kwame.withdraw(100.00));
    assertTrue(Kofi.withdraw(1000.00));
    assertTrue(John.withdraw(0.02));
  }

  /**
   * Tests the 'getBalance' method.
   */
  @Test
  public void testGetBalance() {
    assertEquals(1.00, Kwame.getBalance(), 0.001);
    assertEquals(10000.00, Kofi.getBalance(), 0.001);
    assertEquals(0.02, John.getBalance(), 0.001);
  }

  /**
   * Tests the performMonthlyMaintenance' method.
   */
  @Test
  public void testPerformMonthlyMaintenance() {
    Kwame.getBalance();
    Kofi.getBalance();
    John.deposit(200.00);
    Kwame.performMonthlyMaintenance();
    Kofi.performMonthlyMaintenance();
    John.performMonthlyMaintenance();
    assertEquals(-4.00, Kwame.getBalance(), 0.001);
    assertEquals(10000.00, Kofi.getBalance(), 0.001);
    assertEquals(195.02, John.getBalance(), 0.001);
  }

  /**
   * Tests the 'toString' method.
   */
  @Test
  public void testToString() {
    assertEquals("$1.00", Kwame.toString());
    assertEquals("$10000.00", Kofi.toString());
    assertEquals("$0.02", John.toString());
  }

}
