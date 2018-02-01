import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GetUrlPage;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Shush&Gar on 25-Jan-18.
 * <p>
 *
 */
public class GetUrlTest extends BaseTest {

    private GetUrlPage getUrlPage;

    @BeforeMethod
    public void setUp() {
        getUrlPage = new GetUrlPage();

    }

    @Test
    public void getUrlTest() {
        assertTrue(getUrlPage.isUrlChanged("http://www.phptravels.net/"));
        getUrlPage.clickFlight();
        assertTrue(getUrlPage.isUrlChanged("http://www.phptravels.net/flightst/"));


    }


}
