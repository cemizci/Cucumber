
Feature: US1002 Kullanıcı istediği ürünü sepete ekler

  Scenario: TC04 Kullanıcı arattığı ürünü sepete ekleyebilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When  arama kutusuna belirlenen aranacak kelimeyi yazip aratir
    Then  arama sonucunda urun bulunabildigini test eder
    And   aratma sonuclarindan ilk urunu tiklar
    Then acilan urun sayfasindaki urun isminde case sensitive olmadan aranacak kelime bulundugunu test eder
    And acilan urun sayfasindaki urun ismini kaydeder
    When urunu sepete ekler
    And your cart linkine tiklar
    And senkronizasyon icin 1 saniye bekler
    Then sepetteki urun ismi ile daha once kaydettigi ismin ayni oldugunu test eder
    And sayfayi kapatir