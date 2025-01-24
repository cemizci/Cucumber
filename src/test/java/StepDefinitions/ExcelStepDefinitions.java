package StepDefinitions;

import Pages.TestOtomasyonuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExcelStepDefinitions {

    Sheet sheet1;
    Workbook workbook;
    FileInputStream fileInputStream;
    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
    String excelDosyaYolu;
    String satırdakiUrunIsmi;
    double  satırdakiMinSonucSayısı;
    int bulunanSonucSayisi;

    @Given("kullanici urunListesi excel'indeki Sheet1 e gider")
    public void kullaniciUrunListesiExcelIndekiSheetEGider() throws IOException {

        excelDosyaYolu = "src/test/resources/urunListesi.xlsx";
        fileInputStream = new FileInputStream(excelDosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet1 = workbook.getSheet("Sheet1");
    }

    @Then("listede verilen {string} daki urun ismini ve minimum sonuc sayisini kaydeder")
    public void listedeVerilenDakiUrunIsminiVeMinimumSonucSayisiniKaydeder(String satırNoStr) {

        int satırNo = Integer.parseInt(satırNoStr);
        satırdakiUrunIsmi = sheet1.getRow(satırNo - 1) // verilen satira gider
                .getCell(0)                            // satirda urun ismi olan cell'e gider
                .getStringCellValue();                    // cell'deki String degeri alir

        satırdakiMinSonucSayısı = sheet1.getRow(satırNo - 1)
                                        .getCell(1)
                                        .getNumericCellValue();

    }

    @And("arama kutusuna kaydedilen urun ismini yazip aratir")
    public void aramaKutusunaKaydedilenUrunIsminiYazipAratir() {
        testOtomasyonuPage.aramaKutusu.sendKeys(satırdakiUrunIsmi + Keys.ENTER);
    }

    @Then("arama sonucunda minumum sonuc sayisi veya daha fazla urun bulunabildigini test eder")
    public void aramaSonucundaMinumumSonucSayisiVeyaDahaFazlaUrunBulunabildiginiTestEder() {

        String aramaSonucYazisi = testOtomasyonuPage.aramaSonucYazıElementi.getText();
        // "3 Products Found"

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // "3"

        bulunanSonucSayisi = Integer.parseInt(aramaSonucYazisi);

        Assertions.assertTrue(bulunanSonucSayisi >= satırdakiMinSonucSayısı);

    }

    @And("bulunan sonuc sayisini {string} daki {int}.sutuna, tarihi de {int}.sutuna yazar")
    public void bulunanSonucSayisiniDakiSutunaTarihiDeSutunaYazar(String satırNoStr, int sonucSutunNo, int tarihSutunNo) throws IOException {

        int satırNo = Integer.parseInt(satırNoStr);

        sheet1.getRow(satırNo - 1)
                .createCell(sonucSutunNo-1)
                .setCellValue(bulunanSonucSayisi);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sheet1.getRow(satırNo-1)
                .createCell(tarihSutunNo-1)
                .setCellValue(localDateTime.format(format1));

        // Normalde kaydetme islemini, tum satirlari bitirdikten sonra yapariz
        // ancak burada herbir satir icin kod sifirdan calisacagi icin
        // her satirda yapilan islemi kayit altina almaliyiz

        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }
}
