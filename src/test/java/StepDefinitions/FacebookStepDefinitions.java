package StepDefinitions;

import Pages.FacebookPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.ObjectInputFilter;

public class FacebookStepDefinitions {

    FacebookPage facebookPage = new FacebookPage();

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String configurationUrlDegeri) {
        Driver.getDriver().get(ConfigReader.getProperty(configurationUrlDegeri));
    }

    @Then("facebook cookies kabul eder")
    public void facebookCookiesKabulEder() {
        facebookPage.cookiesAcceptBtn.click();
    }


    @And("facebook'da yeni hesap olustur butonuna basar")
    public void facebookDaYeniHesapOlusturButonunaBasar() {
        facebookPage.createAccountBtn.click();
    }

    @When("Faker class'indan bilgilerle facebook kayit formunu doldurur")
    public void fakerClassIndanBilgilerleFacebookKayitFormunuDoldurur() {
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        actions.click(facebookPage.kayitOlusturSayfasiFirstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB).perform();

        actions.sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();

    }

    @And("facebook kayit ol tusuna basar")
    public void facebookKayitOlTusunaBasar() {
        facebookPage.signUpBtn.click();
    }
}
