import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import setup.listeners.SuiteListener;

import static setup.DriverSetup.quitDriver;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */

@Listeners(SuiteListener.class)

public  abstract class BaseTest {

   @AfterTest
    public void tearDown() {
        quitDriver();
    }
}
