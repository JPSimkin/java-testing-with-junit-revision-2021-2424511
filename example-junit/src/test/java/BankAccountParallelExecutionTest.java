import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
    @Test
    @DisplayName("Deposit 500 successfully")
    //The resolve parameter will pass in a new instance of bankAccount
    //where the balance is zero and the minimum balance is zero
    //This is done from the BankAccountParameterResolver class
    public void testDeposit1(BankAccount bankAccount) {
        //just put this sleep here so we can see that the tests are
        //running concurrently; otherwise, the tests run too fast
        try {
            Thread.sleep(200);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    //The resolve parameter will pass in a new instance of bankAccount
    //where the balance is zero and the minimum balance is zero
    //This is done from the BankAccountParameterResolver class
    public void testDeposit2(BankAccount bankAccount) {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    //The resolve parameter will pass in a new instance of bankAccount
    //where the balance is zero and the minimum balance is zero
    //This is done from the BankAccountParameterResolver class
    public void testDeposit3(BankAccount bankAccount) {
        try {
            Thread.sleep(1200);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
