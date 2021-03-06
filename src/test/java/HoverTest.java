import pages.HoverPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by sargis on 12/21/17.
 */
public class HoverTest extends BaseTest {

    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {

        hoverPage = new HoverPage();
    }


    @Test
    public void dropdownSelect() {
        assertTrue(hoverPage.isHeaderNotDisplayed(), "Header was visible!");
        hoverPage.hoverAvatar();
        assertTrue(hoverPage.isHeaderDisplayed(), "Header was not visible!");
        assertTrue(hoverPage.getHeader().getText().contains("name: user1"),
                "Header text was not correct!");
    }




}
