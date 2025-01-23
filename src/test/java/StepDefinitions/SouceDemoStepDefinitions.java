package StepDefinitions;

import Pages.SouceDemoPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class SouceDemoStepDefinitions {

    SouceDemoPage souceDemoPage = new SouceDemoPage();
    String firstProductItemName;

    @Then("saucedemo username kutusuna {string} yazar")
    public void saucedemoUsernameKutusunaYazar(String inputUserName) {
        souceDemoPage.userNameInputBox.sendKeys(inputUserName);
    }

    @And("saucedemo password kutusuna {string} yazar")
    public void saucedemoPasswordKutusunaYazar(String passwordInputBox) {
        souceDemoPage.passwordInputBox.sendKeys(passwordInputBox);
    }

    @Then("saucedemo login tusuna basar")
    public void saucedemoLoginTusunaBasar() {
        souceDemoPage.submitBtn.click();
    }

    @And("saucedemo ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void saucedemoIlkUrununIsminiKaydederVeBuUrununSayfasinaGider() {
        firstProductItemName = souceDemoPage.firstProductItemText.getText();
        souceDemoPage.firstProductItemText.click();
    }

    @When("saucedemo add to Cart butonuna basar")
    public void saucedemoAddToCartButonunaBasar() {
        souceDemoPage.addToCartBtn.click();
    }

    @Then("saucedemo alisveris sepetine tiklar")
    public void saucedemoAlisverisSepetineTiklar() {
        souceDemoPage.shoppingCartBtn.click();
    }

    @And("saucedemo sectigi urunun basarili olarak sepete eklendigini test eder")
    public void saucedemoSectigiUrununBasariliOlarakSepeteEklendiginiTestEder() {
        Assertions.assertTrue(souceDemoPage.cartItemName.isDisplayed());
    }


    @Then("sayfayı kapatır")
    public void sayfayıKapatır() {
        Driver.quitDriver();
    }
}
