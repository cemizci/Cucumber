package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Allow all cookies'])[2]")
    public WebElement cookiesAcceptBtn;

    @FindBy(id = "email")
    public WebElement loginEmailBox;

    @FindBy(id = "password")
    public WebElement loginPasswordBox;

    @FindBy(name = "login")
    public WebElement loginPageLoginBtn;

    @FindBy(xpath = "//a[@href='/r.php?entry_point=login']")
    public WebElement createAccountBtn;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement kayitOlusturSayfasiFirstnameKutusu;

    @FindBy(xpath = "//button[@type='submit'][1]")
    public WebElement signUpBtn;
}
