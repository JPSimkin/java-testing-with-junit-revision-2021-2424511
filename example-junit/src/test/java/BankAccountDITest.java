import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {
    @Test
    @DisplayName("Deposit 500 successfully")
    //The resolve parameter will pass in a new instance of bankAccount
    //where the balance is zero and the minimum balance is zero
    //This is done from the BankAccountParameterResolver class
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
