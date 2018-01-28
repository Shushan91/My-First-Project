package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static setup.DriverSetup.getDriver;

/**
 * Created by Shush&Gar on 25-Jan-18.
 */
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





    public void clickFlight() {
        click(clickFlight);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
