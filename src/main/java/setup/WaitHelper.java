package setup;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.DriverSetup.getDriver;

/**
 * Created by Shush&Gar on 25-Jan-18.
 */
public class WaitHelper {

    private static final int DEFAULT_TIMEOUT = 10;

    Logger log = Logger.getLogger(Log.class.getName());

    public static WaitHelper getWait() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public WaitHelper waitForElementToBeVisible(WebElement element) {
        try {
            log.info("Waiting for element to be visible" + element.toString());
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element was not visible" + element.toString());
        }

    }
    public WaitHelper waitForElementNotVisible (WebElement element) {
        try {
            log.info("Waiting for element to be visible" + element.toString());
            new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element was visible" + element.toString());
        }

    }
    public WaitHelper waitForElementToBeVisible(By location){
        return  waitForElementToBeVisible(getDriver().findElement(location));
    }

    public WaitHelper waitForElementToBeVisible(String cssSelector){
        return  waitForElementToBeVisible(By.cssSelector(cssSelector));
    }


    public WaitHelper waitForUrlChangedFrom(final String oldUrl){
        log.info("Waiting for url change from "+oldUrl);
        new WebDriverWait(getDriver(),DEFAULT_TIMEOUT).until((ExpectedCondition<Boolean>) driver ->{
            String url=driver!=null? driver.getCurrentUrl():null;
            return url.contains(oldUrl);
        });
        return this;
    }
}