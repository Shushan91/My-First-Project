import pages.WindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sargis on 12/21/17.
 */
public class MultiWindowsTest extends BaseTest {
    private WindowsPage windowsPage;

    @BeforeMethod
    public void setUp() {
        windowsPage = new WindowsPage();

    }

    @Test
    public void windowChange() {
        windowsPage.clickLink();
        windowsPage.switchToWindow(0);
    }

}
