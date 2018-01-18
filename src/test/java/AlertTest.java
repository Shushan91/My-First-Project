
import Pages.AlertsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Shush&Gar on 06-Jan-18.
 */
public class AlertTest extends BaseTest {
    private AlertsPage alertsPage;

    @BeforeMethod
    public void setUp() {
         alertsPage = new AlertsPage();

    }


   @Test
    public void clickButton1() {
        alertsPage.clickAlert();
        alertsPage.getAlertMessage();
        alertsPage.alertAcception();
        assertEquals(alertsPage.getResultMessage().getText(), "You successfuly clicked an alert");
        }



    @Test
    public  void clickButton2_1 () {
        alertsPage.clickConfirm();
        alertsPage.getAlertMessage();
        alertsPage.alertDismission();
        assertEquals(alertsPage.getResultMessage().getText(),"You clicked: Cancel");

    }

    @Test
    public  void clickButton2_2 () {
        alertsPage.clickConfirm();
        alertsPage.getAlertMessage();
        alertsPage.alertAcception();
        assertEquals(alertsPage.getResultMessage().getText(), "You clicked: Ok");

    }

    @Test
    public void clickButton3_1() {
        alertsPage.clickPromt();
        alertsPage.getAlertMessage();
        alertsPage.setAlertMessage("Test");
        alertsPage.alertAcception();
        assertEquals(alertsPage.getResultMessage().getText(), "You entered: Test");
    }

    @Test
    public void clickButton3_2() {
        alertsPage.clickPromt();
        alertsPage.getAlertMessage();
        alertsPage.setAlertMessage("");
        alertsPage.alertAcception();
        assertEquals(alertsPage.getResultMessage().getText(), "You entered:");

    }
    @Test
    public void clickButton3_3() {
        alertsPage.clickPromt();
        alertsPage.getAlertMessage();
        alertsPage.setAlertMessage("Hi");
        alertsPage.alertDismission();
        assertEquals(alertsPage.getResultMessage().getText(), "You entered: null");

    }


}




