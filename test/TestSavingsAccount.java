import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import bank.SavingsAccount;
import org.junit.Before;
import org.junit.Test;



/**
 * This class tests the methods of the 'SavingsAccount' class.
 */
public class TestSavingsAccount {
  private SavingsAccount Kwame;
  private SavingsAccount Kofi;
  private SavingsAccount John;

  /**
   * Creates Savings Account object instances.
   */
  @Before
  public void setUp() {
    Kwame = new SavingsAccount(1.00);
    Kofi = new SavingsAccount(10000.00);
    John = new SavingsAccount(0.01);

  }

  /**
   * Tests instances where the starting balance is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadSetUp() {
    SavingsAccount Bill = new SavingsAccount(0);
    SavingsAccount George = new SavingsAccount(0.009);
    SavingsAccount Lincoln = new SavingsAccount(-10054.50);
  }

  /**
   * Tests the 'deposit' method.
   */
  @Test
  public void testValidDeposit() {
    Kwame.deposit(0.50);
    Kofi.deposit(1000.00);
    John.deposit(100.00);
    assertEquals(1.50, Kwame.getBalance(), 0.001);
    assertEquals(11000.00, Kofi.getBalance(), 0.001);
    assertEquals(100.01, John.getBalance(), 0.001);
  }

  /**
   * Tests the 'withdraw' method.
   */
  @Test
  public void testWithdrawals() {
    assertTrue(Kwame.withdraw(1.00));
    assertTrue(Kofi.withdraw(0.01));
    assertFalse(John.withdraw(-10.00));
  }

  /**
   * Tests the 'getBalance' method.
   */
  @Test
  public void testGetBalance() {
    assertEquals(1.00, Kwame.getBalance(), 0.001);
    assertEquals(10000.00, Kofi.getBalance(), 0.001);
    assertEquals(0.01, John.getBalance(), 0.001);
  }

  /**
   * Tests the performMonthlyMaintenance' method.
   */
  @Test
  public void testPerformMonthlyMaintenance() {
    //three withdrawals
    Kwame.deposit(1000.00);
    Kwame.withdraw(20.00);
    Kwame.withdraw(10.00);
    Kwame.withdraw(50.00);
    Kwame.performMonthlyMaintenance();
    assertEquals(921.00, Kwame.getBalance(), 0.001);

    //seven withdrawals
    Kofi.withdraw(800.00);
    Kofi.withdraw(500.00);
    Kofi.withdraw(650.00);
    Kofi.withdraw(1600.00);
    Kofi.withdraw(2200.00);
    Kofi.withdraw(850.00);
    Kofi.withdraw(1845.00);
    Kofi.performMonthlyMaintenance();
    assertEquals(1541.00, Kofi.getBalance(), 0.001);
  }

  /**
   * Tests the 'toString' method.
   */
  @Test
  public void testToString() {
    assertEquals("$1.00", Kwame.toString());
    assertEquals("$10000.00", Kofi.toString());
    assertEquals("$0.01", John.toString());
  }


}