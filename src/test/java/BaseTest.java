import org.testng.annotations.AfterMethod;

import static setup.DriverSetup.quitDriver;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */
public class BaseTest {

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
