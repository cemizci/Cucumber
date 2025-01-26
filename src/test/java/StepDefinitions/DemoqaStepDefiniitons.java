package StepDefinitions;

import Pages.DemoqaPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaStepDefiniitons {

    DemoqaPage demoqaPage = new DemoqaPage();
    WebElement visibleAfter5secondsBtn;

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

    @Then("Elements menusunu acar")
    public void elementsMenusunuAcar() {
        demoqaPage.elementMenu.click();
    }


    @And("Dynamic Properties menusune gider")
    public void dynamicPropertiesMenusuneGider() {
        demoqaPage.dynamicPropertiesMenu.click();
    }

    @When("Will enable {int} seconds butonunun enable olmasini bekler")
    public void willEnableSecondsButonununEnableOlmasiniBekler(int arg0) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(demoqaPage.willEnable5SecondBtn));
    }

    @And("Will enable {int} seconds butonunun enable oldugunu test eder")
    public void willEnableSecondsButonununEnableOldugunuTestEder(int arg0) {

        Assertions.assertTrue(demoqaPage.willEnable5SecondBtn.isEnabled());
    }

    @When("Visible after {int} seconds butonunun gorunur olmasini bekler")
    public void visibleAfterSecondsButonununGorunurOlmasiniBekler(int arg0) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        visibleAfter5secondsBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

    }

    @And("Visible after {int} seconds butonunun gorunur oldugunu test eder")
    public void visibleAfterSecondsButonununGorunurOldugunuTestEder(int arg0) {

        Assertions.assertTrue(demoqaPage.visibleAfter5SecondsBtn.isDisplayed());
    }

    @When("Color change butonunun renginin degismesini bekler")
    public void colorChangeButonununRengininDegismesiniBekler() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(demoqaPage.colorChangeBtn,"class","mt-4 text-danger btn btn-primary"));

    }

    @And("Color change butonunun renginin degistigini test eder")
    public void colorChangeButonununRengininDegistiginiTestEder() {

        String expectedClassAttributeValue = "mt-4 text-danger btn btn-primary";

        String actualClassAttributeValue = demoqaPage.colorChangeBtn.getAttribute("Class");

        Assertions.assertEquals(expectedClassAttributeValue,actualClassAttributeValue);
    }
}
