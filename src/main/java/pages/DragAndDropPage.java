package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;

import static setup.DriverSetup.getDriver;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */
public class DragAndDropPage extends BasePage {
    public DragAndDropPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/drag_and_drop";
    }

    public WebElement dragable() {
        return find(By.id("column-a"));

    }

    public WebElement dropable() {
        return find(By.id("column-b"));
    }


    public void dragAndDropAction() {
        Actions builder = new Actions(driver);
        Action dragdrop = builder.clickAndHold(dragable())
                .moveToElement(dropable())
                .release(dropable())
                .build();
        builder.perform();
    }


}
