package StepDefinitions;

import Pages.TestOtomasyonuPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusibleMethods;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

public class TestOtomasyonuStepDefinitions {

    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
    String urunSayfasındakiKaydedilenUrunIsmi;
    
    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanıcıTestOtomasyonuSayfasınaGider(){
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir(){
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("phone") + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder(){
        Assertions.assertTrue(testOtomasyonuPage.bulunanUrunElList.size() > 0);
    }



    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir(){
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("dress") + Keys.ENTER);
    }

    @When("arama kutusuna Java yazip aratir")
    public void arama_Kutusuna_Java_Yazip_Aratir(){
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("Java") + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder(){
        String expectedSonucYazısı = ConfigReader.getProperty("toNotFound");
        String actualSonucYazısı = testOtomasyonuPage.aramaSonucYazıElementi.getText();

        Assertions.assertEquals(expectedSonucYazısı,actualSonucYazısı);
    }

    @When("arama kutusuna belirlenen aranacak kelimeyi yazip aratir")
    public void aramaKutusunaBelirlenenAranacakKelimeyiYazipAratir() {
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);
    }

    @And("aratma sonuclarindan ilk urunu tiklar")
    public void aratmaSonuclarindanIlkUrunuTiklar() {
        testOtomasyonuPage.bulunanUrunElList.get(0).click();
    }

    @Then("acilan urun sayfasindaki urun isminde case sensitive olmadan aranacak kelime bulundugunu test eder")
    public void acilanUrunSayfasindakiUrunIsmindeCaseSensitiveOlmadanAranacakKelimeBulundugunuTestEder() {
        String expectedProductContent = ConfigReader.getProperty("toSearchWord");
        String actualProductContent = testOtomasyonuPage.urunSayfasındakiIsimEl.getText().toLowerCase();

        Assertions.assertTrue(actualProductContent.contains(expectedProductContent));
    }

    @And("acilan urun sayfasindaki urun ismini kaydeder")
    public void acilanUrunSayfasindakiUrunIsminiKaydeder() {
         urunSayfasındakiKaydedilenUrunIsmi = testOtomasyonuPage.urunSayfasındakiIsimEl.getText();
    }

    @When("urunu sepete ekler")
    public void urunuSepeteEkler() {
        testOtomasyonuPage.urunSayfasindakiSepeteEkleButonu.click();
    }

    @And("your cart linkine tiklar")
    public void yourCartLinkineTiklar() {
        testOtomasyonuPage.urunSayfasindakiYourCartButonu.click();
    }

    @And("senkronizasyon icin {int} saniye bekler")
    public void senkronizasyonIcinSaniyeBekler(int arg0) {
        ReusibleMethods.wait(1);
    }

    @Then("sepetteki urun ismi ile daha once kaydettigi ismin ayni oldugunu test eder")
    public void sepettekiUrunIsmiIleDahaOnceKaydettigiIsminAyniOldugunuTestEder() {
        String sepettekiActualUrünIsmi = testOtomasyonuPage.yourCartSayfasindakiUrunIsmi.getText();
        Assertions.assertEquals(urunSayfasındakiKaydedilenUrunIsmi,sepettekiActualUrünIsmi);
    }



    @Then("sepetteki urun ismi ile daha once kaydettigi ismin case sensitive olmadan ayni oldugunu test eder")
    public void sepettekiUrunIsmiIleDahaOnceKaydettigiIsminCaseSensitiveOlmadanAyniOldugunuTestEder() {
        String expectedUrunIsmi = urunSayfasındakiKaydedilenUrunIsmi.toLowerCase();
        String actualUrunIsmi = testOtomasyonuPage.yourCartSayfasindakiUrunIsmi.getText().toLowerCase();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.quitDriver();
    }


    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakUrunIsmi) {
        testOtomasyonuPage.aramaKutusu.sendKeys(aranacakUrunIsmi + Keys.ENTER);
    }

    @Then("acilan urun sayfasindaki urun isminde case sensitive olmadan {string} bulundugunu test eder")
    public void acilanUrunSayfasindakiUrunIsmindeCaseSensitiveOlmadanBulundugunuTestEder(String aratılanUrunIsmi) {
        String actualUrunIsmi = testOtomasyonuPage.urunSayfasındakiIsimEl.getText().toLowerCase();
        Assertions.assertTrue(actualUrunIsmi.contains(aratılanUrunIsmi));
    }

    @Then("anasayfadaki account linkine tiklar")
    public void anasayfadakiAccountLinkineTiklar() {
      testOtomasyonuPage.accountLink.click();
    }

    @When("email kutusuna configuration dosyasindaki {string} degerini girer")
    public void emailKutusunaConfigurationDosyasindakiDegeriniGirer(String configurationdakiEmail) {
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty(configurationdakiEmail));
    }

    @And("password kutusuna configuration dosyasindaki {string} degerini girer")
    public void passwordKutusunaConfigurationDosyasindakiDegeriniGirer(String configurationdakiPassword) {
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty(configurationdakiPassword));
    }

    @Then("login sayfasindaki signIn butonuna basar")
    public void loginSayfasindakiSignInButonunaBasar() {
        testOtomasyonuPage.loginPageSubmitBtn.click();
    }

    @And("basarili sekilde giris yapilabildigini test eder")
    public void basariliSekildeGirisYapilabildiginiTestEder() {
        Assertions.assertTrue(testOtomasyonuPage.logoutBtn.isDisplayed());
    }

    @Then("logout butonuna basar")
    public void logoutButonunaBasar() {
        testOtomasyonuPage.logoutBtn.click();
    }

    @Then("basarili olarak giris yapilamadigini test eder")
    public void basariliOlarakGirisYapilamadiginiTestEder() {
        Assertions.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
    }

    @Then("email kutusuna listede verilen {string} degerini girer")
    public void emailKutusunaListedeVerilenDegeriniGirer(String verilenEmail) {
        testOtomasyonuPage.loginPageEmailBox.sendKeys(verilenEmail);
    }

    @And("password kutusuna listede verilen {string} degerini girer")
    public void passwordKutusunaListedeVerilenDegeriniGirer(String verilenPassword) {
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(verilenPassword);
    }

    @Then("arama sonucunda {string} veya daha fazla urun bulunabildigini test eder")
    public void aramaSonucundaVeyaDahaFazlaUrunBulunabildiginiTestEder(String belirtilenMiktarStr) {

        int belirtilenMiktar = Integer.parseInt(belirtilenMiktarStr);

        String aramaSonucYazısı = testOtomasyonuPage.aramaSonucYazıElementi.getText(); // "3 Products Found"

        aramaSonucYazısı = aramaSonucYazısı.replaceAll("\\D", ""); // 3

        int actualBulunanUrunSayısı = Integer.parseInt(aramaSonucYazısı);

        Assertions.assertTrue(actualBulunanUrunSayısı >= belirtilenMiktar);
    }
}
