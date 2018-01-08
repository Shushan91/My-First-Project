import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sargis on 12/21/17.
 */
public class DropdownTest {
    private ChromeDriver driver;
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/sargis/dev/chromedriver/chromedriver");
        driver = new ChromeDriver();
        dropdownPage = new DropdownPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void dropdownSelect() {
        dropdownPage.selectOption("Option 2");
        assertEquals(dropdownPage.getSelectedOption(), "Option 2");
    }
    @Test
    public void alert() {
        dropdownPage.forceAlert();
        dropdownPage.closeAlert();

    }


}
