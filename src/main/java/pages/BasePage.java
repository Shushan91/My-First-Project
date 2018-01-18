package pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static setup.DriverSetup.getDriver;

/**
 * Created by sargis on 12/14/17
 */
public abstract class BasePage<T> {
    Logger log  = Logger.getLogger(Log.class.getName());
    protected WebDriver driver;

    public  static final  String BASE_URL= System.getProperty("selenium.url", "http://the-internet.herokuapp.com");


    public BasePage() {
        this.driver = getDriver();
    }

    public void visit(String url) {
        log.info("Visiting " + url);
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement find(String cssSelector) {
        log.info("finding css selector");
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        click(find(locator));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(String cssSelector) {
        click(find(cssSelector));
    }

    public void type(By locator, String text) {
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text) {
        type(find(cssSelector), text);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isNotDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(find(locator));
    }

    public boolean isDisplayed(String cssSelector) {
        return isDisplayed(find(cssSelector));
    }


    public void alertAcception() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public  void  alertDismission () {
        driver.switchTo().alert().dismiss();
    }

    public void getAlertMessage() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

    }

    public  void setAlertMessage(String mess) {
        Alert alert= driver.switchTo().alert();
        alert.sendKeys(mess);
    }
}
