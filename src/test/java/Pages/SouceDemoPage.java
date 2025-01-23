package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoPage {

    public SouceDemoPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement userNameInputBox;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//*[@class='inventory_item'][1]//div[@class='inventory_item_name ']")
    public WebElement firstProductItemText;

    @FindBy(xpath = "//button[@id='add-to-cart']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    public WebElement shoppingCartBtn;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    public WebElement cartItemName;
}
