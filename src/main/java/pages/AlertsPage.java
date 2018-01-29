package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

/**
 * Created by Shush&Gar on 05-Jan-18.
 */
public class AlertsPage extends BasePage {

    public AlertsPage() {
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/javascript_alerts";
    }


    @FindBy(id = "result")
    private WebElement jsResult;

    @FindBy(css = "div#content li:nth-child(1) > button")
    private WebElement jsAlert;

    @FindBy(css= "div#content li:nth-child(2) > button")
    private WebElement jsConfirm;

    @FindBy(css= "div#content li:nth-child(3) > button")
    private WebElement jsPromt;



    public void clickAlert() {
        click(jsAlert);
    }

    public boolean isAlertDisplayed() {
        try {
            WaitHelper.getWait().waitForElementToBeVisible(jsResult);
            return true;
        } catch (Error e) {

            return false;
        }
    }


    public WebElement getResultMessage() {
        return jsResult;

    }

    public void clickConfirm() {
        click(jsConfirm);
    }

    public void clickPromt() {
        click(jsPromt);
    }


}






