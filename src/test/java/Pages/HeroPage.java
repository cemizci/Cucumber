package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroPage {

    public HeroPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Add Element']")
    public WebElement addElementButonu;

    @FindBy (xpath = "//*[.='Delete']")
    public WebElement deleteButonu;

    @FindBy (xpath = "//*[.='Add/Remove Elements']")
    public WebElement addRemoveElementsYaziElementi;
}
