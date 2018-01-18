package pages;


public class WindowsPage extends BasePage {
    public WindowsPage() {
        visit(getUrl());
    }

    public String getUrl (){
        return BASE_URL+ "/windows";
    }

    public void clickLink() {
        find(".example a").click();
    }

    public Object[] getAllWindows() {
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index) {
        driver.switchTo().window(getAllWindows()[index].toString());
    }
}
