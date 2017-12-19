package ATM;

import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ATMTest {


    private static final double NEGATIVE = -1d;
    private static final double AMOUNT = 100d;
    private static final double LARGEAMOUNT = 5000d;
    private static final double COMMISSIONS = AMOUNT * 0.02d;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Test
    public void givenNewAtm_whenAtmBalance_thenBalanceEqualsTo1000d() {
        //given
        ATM atm = new ATM();
        //when
        double balance = atm.balance;
        //then
        Assert.assertEquals(1000d, balance, 0);
    }

    @Test
    public void givenNewAtm_whenBalanceIsString_thenAtmBalanceIs1000dot0() {
        //given
        ATM atm = new ATM();
        //when
        String actual = atm.balance();
        //then
        Assert.assertEquals("balance", "ATM balance is: 1000.0", actual);

    }

    @Test(expected = BalanceExepsion.class)
    public void givenNegativeNumber_whenAtmWithrow_thenExeptionThrow() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        //when
        atm.withdrow(NEGATIVE);


    }

    @Test(expected = BalanceExepsion.class)
    public void givenBalanceis0_whenAtmWithrow_thenExeptionThrow() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        atm.balance = 0;
        //when
        atm.withdrow(AMOUNT);


    }

    @Test(expected = BalanceExepsion.class)
    public void givenLargeNumber_whenAtmWithrow_thenExeptionThrow() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        //when
        atm.withdrow(LARGEAMOUNT);
    }

    @Test
    public void giveNumber_whenAtmWithrow_thenBalanceMinusNumber() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        //when
        double temp = atm.balance;
        atm.withdrow(AMOUNT);
        //then
        Assert.assertEquals(temp - AMOUNT - COMMISSIONS, atm.balance, 0);

    }

    @Test(expected = BalanceExepsion.class)
    public void givenNegativeNumber_whenAtmDeposit_thenExeptionThrow() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        //when
        atm.deposit(NEGATIVE);
    }

    @Test
    public void giveNumber_whenAtmDeposit_thenBalancePlusNumber() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        //when
        double temp = atm.balance;
        atm.deposit(AMOUNT);
        //then
        Assert.assertEquals(temp + AMOUNT - COMMISSIONS, atm.balance, 0);

    }

    @Test
    public void giveNumber_whenAtmCommissions_thenBalanceminusCommissions() throws BalanceExepsion {
        //given
        ATM atm = new ATM();
        //when
        double temp = atm.balance;
        atm.commissions(AMOUNT);
        //then
        Assert.assertEquals(temp - AMOUNT * 0.02d, atm.balance, 0);

    }
    @Test
    public void giveNumber_whenAtmCommissions_thenBalanceminusCommis(){
       ATM atm = new ATM();
       Assert.assertTrue(atm.allTransactions.isEmpty());
       atm.seeAllTransactions();

    }
    @Before
    public void redirectOut() {

        System.setOut(new PrintStream(out));

    }

    @Test
    public void giveNewAtm_whenSeeAllTransactions_thenListIsEmpty() {
        ATM atm = new ATM();
        atm.seeAllTransactions();

        assertEquals("", out.toString().trim());
    }

    @After
    public void cleanUpOut() {
        System.setOut(null);
    }



}