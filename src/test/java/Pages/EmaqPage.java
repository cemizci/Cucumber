package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmaqPage {

    public EmaqPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchboxTrigger")
    public WebElement searchBox;

    @FindBy(xpath = "(//p[@class='product-new-price'])[1]")
    public WebElement firstProductPrice;
}
