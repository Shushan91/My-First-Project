package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */
public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER = System.getProperty("selenium.browser", "chrome");

    public static WebDriver getDriver() {
        if (driver == null) {


            switch (BROWSER) {
                case "chrome":

                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "C:/Selenium-projects/chromedriver_win32/chromedriver.exe");

                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    driver = new ChromeDriver();
                    break;

                case "firefox":

                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "C:/Selenium-projects/chromedriver_win32/chromedriver.exe");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            if (BROWSER.equals("firefox")) {
                driver.close();
                driver = null;
            } else if (BROWSER.equals("chrome")) {
                driver.close();
                driver.quit();
                driver = null;

            }
        }
    }

}