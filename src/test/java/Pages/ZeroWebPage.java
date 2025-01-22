package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.Driver;

public class ZeroWebPage {

    public ZeroWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "icon-signin")
    public WebElement mainPageSignBtn;

    @FindBy(id = "user_login")
    public WebElement loginBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@name='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//strong[.='Online Banking']")
    public WebElement onlineBankingMenuEl;

    @FindBy(xpath = "//*[@id='pay_bills_link']")
    public WebElement payBillsMenuEl;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency" )
    public WebElement currencyDdm;
}
