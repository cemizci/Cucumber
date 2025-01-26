package StepDefinitions;

import Pages.Guru99Page;
import Utilities.Driver;
import Utilities.ReusibleMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Guru99StepDefinitions {

    Guru99Page guru99Page = new Guru99Page();

    @Then("Company listesini consola yazdirir")
    public void companyListesiniConsolaYazdirir() {

        System.out.println(ReusibleMethods.stringListeDonustur(guru99Page.companyNames));

    }

    @And("listede {int}'den fazla sirket oldugunu test eder")
    public void listedeDenFazlaSirketOldugunuTestEder(int expectedMinCompanyName) {

        int actualCompanyName = guru99Page.companyNames.size();
        System.out.println(actualCompanyName);

        Assertions.assertTrue(actualCompanyName >= expectedMinCompanyName);
    }

    @And("{string} %Change oraninin pozitif oldugunu test eder")
    public void changeOranininPozitifOldugunuTestEder(String desiredCompany) {

        // tum satirlardaki sirket isimlerini kontrol edip
        // sirket ismi istenenSirket olan satirdaki
        // yuzde degisim miktarini kaydedelim

        String percentageChangeRateInRow = "";
        int rowCount = guru99Page.companyNames.size();

        String amountOfChangeInRow = "";

        for (int i = 1; i <= rowCount ; i++) {

            String companyNameInRow =Driver.getDriver()
                    .findElement(By.xpath("//tbody/tr["+ i +"]/td[1]")).getText();


            if (companyNameInRow.equalsIgnoreCase(desiredCompany)){
                amountOfChangeInRow = Driver.
                        getDriver().
                        findElement(By.xpath("//tbody/tr["+ i +"]/td[5]"))
                        .getText();
                break;
            }
        }

        System.out.println("Change Amount" + amountOfChangeInRow);

        Assertions.assertTrue(amountOfChangeInRow.contains("+"));
    }
}
