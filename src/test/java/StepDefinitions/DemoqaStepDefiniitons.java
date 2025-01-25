package StepDefinitions;

import Pages.DemoqaPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaStepDefiniitons {

    DemoqaPage demoqaPage = new DemoqaPage();

    @Then("Alerts’e tiklar")
    public void alertsETiklar() {
        demoqaPage.alertButton.click();
    }

    @When("On button click, alert will appear after {int} seconds karsisindaki click me butonuna basar")
    public void onButtonClickAlertWillAppearAfterSecondsKarsisindakiClickMeButonunaBasar(int arg0) {
        demoqaPage.timerAlertButton.click();
    }

    @And("Alert’in gorunur olmasini bekler")
    public void alertInGorunurOlmasiniBekler() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("Alert uzerindeki yazinin {string} oldugunu test eder")
    public void alertUzerindekiYazininOldugunuTestEder(String expectedAlertYazı) {

        String actualAlertYazı = Driver.getDriver().switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazı,actualAlertYazı);

    }

    @And("Ok diyerek alerti kapatir")
    public void okDiyerekAlertiKapatir() {

        Driver.getDriver().switchTo().alert().accept();
    }
}
