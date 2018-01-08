import Pages.DropdownPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.quitDriver;


public class DropdownTest {
    private ChromeDriver driver;
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        dropdownPage = new DropdownPage();

    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
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
