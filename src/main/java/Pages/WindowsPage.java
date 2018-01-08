package Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by sargis on 12/25/17
 */
public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/windows");
    }

    public void clickLink() {
        find(".example a").click();
    }

    public Object[] getAllWindows() {
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index) {
        driver.switchTo().window(getAllWindows()[index].toString());
    }
}
