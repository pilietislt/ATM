package ATM;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private static final String WRONG_PIN = "234" ;
    private static final String PIN = "1234" ;

    @Test (expected = PinExepsion.class)
    public void givenPinMetod_whenWronpin_thenThrowExeption() throws PinExepsion, BalanceExepsion {
        Main.pin(WRONG_PIN);

    }


}