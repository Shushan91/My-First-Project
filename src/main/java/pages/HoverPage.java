package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

public class HoverPage extends BasePage {
    @FindBy(className = "figcaption")
    private WebElement figcaption;


    public HoverPage() {
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/hovers";
    }

    public void hoverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverAvatar() {
        hoverElement(find(By.className("figure")));

    }

    public boolean isHeaderDisplayed() {
        return isDisplayed(figcaption);
    }

    public boolean isHeaderNotDisplayed() {
        try {
            WaitHelper.getWait().waitForElementNotVisible(figcaption);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public WebElement getHeader() {
        hoverAvatar();
        return figcaption;
    }

}
