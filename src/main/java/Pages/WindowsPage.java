package Pages;

import org.openqa.selenium.WebDriver;

import static setup.DriverSetup.getDriver;


public class WindowsPage extends BasePage {
    public WindowsPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl (){
        return BASE_URL+ "/windows";
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
