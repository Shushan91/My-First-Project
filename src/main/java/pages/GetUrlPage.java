package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;


public class GetUrlPage extends BasePage {

    @FindBy(css = "a.leader")
    private WebElement clickFlight;

    public GetUrlPage() {
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return "http://www.phptravels.net";
    }

    public boolean isUrlChanged() {
        try {
            WaitHelper.getWait().waitForUrlChangedFrom( "http://www.phptravels.net/");
            return true;
        } catch (Error e) {

            return false;
        }
    }


    public void clickFlight() {
        click(clickFlight);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
