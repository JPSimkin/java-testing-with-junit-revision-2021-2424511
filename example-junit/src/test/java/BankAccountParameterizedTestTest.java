import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
    @ParameterizedTest
    @ValueSource(ints = {100,400,800,1000}) //this will be put in the "amount" parameter
    @DisplayName("Depositing successfully")
    //The resolve parameter will pass in a new instance of bankAccount
    //where the balance is zero and the minimum balance is zero
    //This is done from the BankAccountParameterResolver class
    public void testDeposit(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value=DayOfWeek.class, names={"Tuesday","Thursday"})
    public void testDayOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));

    }

    @ParameterizedTest
    //@CsvSource({"100, Mary","200, John","500, Susan", "1000, Joyce"})
    @CsvFileSource(resources = "details.csv")
    public void depositAndNameTest(int amount, String name, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHolderName());

    }
}
