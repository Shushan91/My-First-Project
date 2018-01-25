package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sargis on 12/21/17
 */
public class DynamicLoadPage extends BasePage {

    @FindBy(css="#start button" )
    private  WebElement startButton;

    @FindBy(id="finish" )
    private  WebElement finishText;

     @FindBy(id="loading" )
    private  WebElement loadingText;



    public DynamicLoadPage() {
        //super(getDriver());
        visit(getUrl());
       // PageFactory.initElements(driver,this);


    }
    public  String getUrl() {
        return  BASE_URL+ "/dynamic_loading/1";
    }

    public void clickStart() {
        click(startButton);
    }

    public boolean isFinishDisplayed() {
        return isDisplayed(finishText, 10);
    }
    public boolean isLoadingDisplayed() {
        return isDisplayed(loadingText, 10);
    }
    public boolean isLoadingNotDisplayed() {
        return isNotDisplayed(loadingText, 10);
    }

    public WebElement getFinish() {
        return finishText;
    }


}