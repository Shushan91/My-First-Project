import Pages.WindowsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sargis on 12/21/17.
 */
public class MultiWindowsTest {
    private ChromeDriver driver;
    private WindowsPage windowsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium-projects/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        windowsPage = new WindowsPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void windowChange() {
        windowsPage.clickLink();
        windowsPage.switchToWindow(0);
    }

}
