import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import setup.listeners.SuiteListener;

import static setup.DriverSetup.quitDriver;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */

@Listeners(SuiteListener.class)

public class BaseTest {

   @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
