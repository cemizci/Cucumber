package Pages;

import org.openqa.selenium.support.PageFactory;
import Utilities.Driver;

public class WebUniversity {

    public WebUniversity(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
