package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static setup.DriverSetup.getDriver;

public class WindowsPage extends BasePage {
    public WindowsPage() {
        visit(getUrl());
    }

    @FindBy(css = ".example a")
    private WebElement clickhere;


    public String getUrl() {
        return BASE_URL + "/windows";
    }

    public void clickLink() {
        clickhere.click();
    }

    public Object[] getAllWindows() {
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index) {
        driver.switchTo().window(getAllWindows()[index].toString());
    }
}
