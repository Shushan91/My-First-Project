import org.testng.annotations.BeforeMethod;
import pages.GetUrlPage;

/**
 * Created by Shush&Gar on 25-Jan-18.
 */
public class GetUrlTest extends BaseTest {

    private GetUrlPage getUrlPage;

    @BeforeMethod
    public void setUp() {
        getUrlPage = (GetUrlPage) new GetUrlPage().get();

    }

   /* @Test
    public void getUrlTest() {

        getUrlPage.clickFlight();
        assertTrue(getUrlPage.getCurrentUrl().contains("flightst"));

    }*/


}
