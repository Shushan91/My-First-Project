import pages.DragAndDropPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */
public class DragAndDropTest extends BaseTest {
    private DragAndDropPage draganddropPage;

    @BeforeMethod
    public void setUp() {
        draganddropPage = new DragAndDropPage();

    }

    @Test
    public void dragAndDropTest() {
        draganddropPage.dragAndDropAction();

    }
}
