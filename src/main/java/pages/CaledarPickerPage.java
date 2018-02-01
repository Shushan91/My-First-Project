package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Shush&Gar on 31-Jan-18.
 */
public class CaledarPickerPage extends BasePage {
    @FindBy(css = "")
    public WebElement departureDate;

    @FindBy(css = "")
    public WebElement returnDate;

    @FindBy(css = "")
    public WebElement search;

    @FindBy(css = "")
    public WebElement fromCountry;

    @FindBy(css = "")
    public WebElement toCountry;




    public CaledarPickerPage() {
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return "http://www.phptravels.net/flightst/";
    }
}
