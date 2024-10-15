import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC}) //org.junit.jupiter.api.condition.OS
    public void testMac() { //Ignored because I'm running test on Windows

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_16}) //ignored because I'm running JRE 19.0.1
    public void testJRE() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_16})
    public void testNoJRE16() {
        
    }

}
