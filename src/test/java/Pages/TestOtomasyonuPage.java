package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucYazıElementi;

    @FindBy(className = "prod-img")
    public List<WebElement> bulunanUrunElList;

    @FindBy(xpath = "//*[@class=' heading-sm mb-4']")
    public WebElement urunSayfasındakiIsimEl;

    @FindBy(id = "priceproduct")
    public WebElement getUrunSayfasındakifiyatEl;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLink;

    @FindBy(id = "email")
    public WebElement loginPageEmailBox;

    @FindBy (id = "password")
    public WebElement loginPagePasswordInput;

    @FindBy(id = "submitlogin")
    public WebElement loginPageSubmitBtn;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutBtn;

    @FindBy (className = "add-to-cart")
    public WebElement urunSayfasindakiSepeteEkleButonu;

    @FindBy (xpath = "(//*[@class='e-cart'])[2]")
    public WebElement urunSayfasindakiYourCartButonu;

    @FindBy (xpath = "//*[@class='product-title text-center']")
    public WebElement yourCartSayfasindakiUrunIsmi;
}
