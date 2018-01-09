package Pages;

import static setup.DriverSetup.getDriver;

/**
 * Created by Shush&Gar on 08-Jan-18.
 */
public class DrugAndDropPage extends  BasePage {
    public  DrugAndDropPage() {
        super (getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL +"/drug_and_drop";
    }
}
