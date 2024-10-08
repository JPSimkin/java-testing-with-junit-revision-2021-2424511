import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeTrue(bankAccount != null, "Account is null");
        assumeFalse(bankAccount == null, "Account is null");
        assumingThat(bankAccount != null,() -> assertTrue(bankAccount.isActive()));
    }
}
