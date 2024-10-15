import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

//we can use the @Timeout for all the tests if we put it on top of the class
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        /*
            This will cause the test to fail because it's sleeping for
            1000 milliseconds. We want the test to take at most 500
            milliseconds. If we change the sleep to 200, that should still
            give our test plenty of time to run within 500 milliseconds
            and our test will pass
         */
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());

    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(500);
        /*
            Sometimes you want the timeout test to be on only part of the
            code within a method; in real life Thread.sleep(10) would be
            replaced by code that actually does something useful; this would
            test if the code takes more than 500 milliseconds to complete. If
            it does, the test fails
         */
        assertTimeout(Duration.ofMillis(500),()->{Thread.sleep(10);});

    }
}
