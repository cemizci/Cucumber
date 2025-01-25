package StepDefinitions;

import Pages.EmaqPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmagStepDefinitions {

    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet1;
    String excelDosyaYolu;
    EmaqPage emaqPage = new EmaqPage();
    int firstEmptyCellIndex;

    @Then("urunListesi{int} excelindeki Sheet{int}'e gider")
    public void urunlistesiExcelindekiSheetEGider(int arg0, int arg1) throws IOException {

        excelDosyaYolu = "src/test/resources/urunListesi2.xlsx";
        fileInputStream = new FileInputStream(excelDosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");
    }

    @And("birinci satirdaki bos olan ilk hucrenin indexini kaydeder")
    public void birinciSatirdakiBosOlanIlkHucreninIndexiniKaydeder() {

        for (int i = 0; i < 1000; i++) {
            if (sheet1.getRow(0).getCell(i) == null){
                firstEmptyCellIndex = i;
                break;
            }
        }
    }

    @Then("birinci satirdaki bos olan ilk hucreye gunun tarihini kaydeder")
    public void birinciSatirdakiBosOlanIlkHucreyeGununTarihiniKaydeder() {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sheet1.getRow(0).createCell(firstEmptyCellIndex)
                .setCellValue(localDateTime.format(istenenFormat));
    }

    @And("her satirdaki urunu emag sitesinde aratir ve bulunan urunlerden ilkinin fiyatini kaydedilen index'deki sutuna yazar")
    public void herSatirdakiUrunuEmagSitesindeAratirVeBulunanUrunlerdenIlkininFiyatiniKaydedilenIndexDekiSutunaYazar() throws IOException {

        int lastRowIndex = sheet1.getLastRowNum();

        for (int i = 1; i <= lastRowIndex ; i++) {
            String productNameInLine = sheet1.getRow(i).getCell(0).getStringCellValue();

            Driver.getDriver().get(ConfigReader.getProperty("emagUrl"));
            emaqPage.searchBox.sendKeys(productNameInLine + Keys.ENTER);

            String $firstProductPrice = emaqPage.firstProductPrice.getText();

            sheet1.getRow(i).createCell(firstEmptyCellIndex).setCellValue($firstProductPrice);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
