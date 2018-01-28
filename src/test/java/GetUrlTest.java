import pages.GetUrlPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GetUrlPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Shush&Gar on 25-Jan-18.
 */
public class GetUrlTest extends BaseTest {

    private GetUrlPage getUrlPage;

    @BeforeMethod
    public void setUp() {
        getUrlPage = (GetUrlPage) new GetUrlPage().get();

    }

    @Test
    public void getUrlTest() {

        getUrlPage.clickFlight();
        assertTrue(getUrlPage.getCurrentUrl().contains("flightst"));

    }


}
