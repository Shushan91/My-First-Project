import Pages.DropdownPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.quitDriver;


public class DropdownTest extends  BaseTest {
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        dropdownPage = new DropdownPage();

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
