package setup;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */
public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");

    private static ThreadLocal<WebDriver> driverThread;
    private static List<WebDriver> webDriverPool =
            Collections.synchronizedList(new ArrayList<WebDriver>());

    public static WebDriver initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":

                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "C:/Selenium-projects/chromedriver_win32/chromedriver.exe");

                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "true"))) {
                        return initRemoteDriver(DesiredCapabilities.chrome());
                    } else {
                        driverThread = new ThreadLocal<WebDriver>() {

                            @Override
                            protected WebDriver initialValue() {

                                WebDriver webDriver = null;
                                webDriver = new ChromeDriver();
                                webDriverPool.add(webDriver);
                                return webDriver;
                            }
                        };
                    }
                    break;

                case "firefox":

                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "C:/Selenium-projects/chromedriver_win32/chromedriver.exe");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().fullscreen();
                    break;


            }
        }
        return driver;
    }

    public static WebDriver initRemoteDriver(DesiredCapabilities capability) {
        driverThread = new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue() {
                WebDriver webDriver = null;
                try {
                    capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX );
                    webDriver = new RemoteWebDriver(new URL("http://Shushan91:e96fce21-8e8c-4c69-a9c8-2fa8b9c5bca6@ondemand.saucelabs.com:80/wd/hub"), capability);
                    webDriverPool.add(webDriver);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return webDriver;
            }
        };
        return null;
    }

    public static WebDriver getDriver() {
        if (driverThread == null) {
            initDriver();
        }
        return driverThread.get();

    }

    public static void quitDriver() {
        webDriverPool.stream().filter(driver -> driver != null).forEach(driver -> {
            if (((RemoteWebDriver) driver).getSessionId() != null) {
                driver.close();

            }
            driver.quit();
        });
    }
}//        for (WebDriver driver: webDriverPool
//             ) {
//            if(driver != null){
//                driver.quit();
//                webDriverPool.remove(driver);
//            }



//        if (driverThread.get() != null) {
//            driverThread.get().close();
//            driverThread.get().quit();
//        });
//    driverThread=null;
//    }


