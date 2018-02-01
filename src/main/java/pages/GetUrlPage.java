package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;


public class GetUrlPage extends BasePage {

    public GetUrlPage() {
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return "http://www.phptravels.net";
    }

    @FindBy(css = "a.loader")    ////a[contains(.,'Flights')]
    private WebElement clickFlight;

    public boolean isUrlChanged(String path) {
        try {
            WaitHelper.getWait().waitForUrlChangedFrom(path);
            return true;
        } catch (Error e) {

            return false;
        }
    }


    public void clickFlight() {
        WaitHelper.getWait().waitForElementClickable(clickFlight);
        click(clickFlight);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
