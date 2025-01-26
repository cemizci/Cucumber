package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage {

    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(xpath = "//*[.='Elements']")
    public WebElement elementMenu;

    @FindBy(xpath = "//span[.='Dynamic Properties']")
    public WebElement dynamicPropertiesMenu;

    @FindBy(id = "enableAfter")
    public WebElement willEnable5SecondBtn;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfter5SecondsBtn;

    @FindBy(id = "colorChange")
    public WebElement colorChangeBtn;
}
