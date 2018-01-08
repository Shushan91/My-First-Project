package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Shush&Gar on 05-Jan-18.
 */
public class AlertsPage extends BasePage {

    private By jsAlert = By.cssSelector("div#content li:nth-child(1) > button");
    private By jsConfirm = By.cssSelector("div#content li:nth-child(2) > button");
    private By jsPromt = By.cssSelector("div#content li:nth-child(3) > button");
    private  By jsResult= By.id("result");

    public AlertsPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickAlert() {
        click(jsAlert);
    }

    public boolean isAlertDisplayed() {
       return   (isDisplayed(find(jsResult), 100));

    }
    public WebElement getResultMessage (){
        return find(jsResult);

    }

    public void clickConfirm() {
        click(jsConfirm);
    }

    public void clickPromt() {
        click(jsPromt);
    }


}






