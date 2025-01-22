Feature: US1007 Kullanici yanlis bilgilerle giris yapamaz


  Scenario: TC11 Kullanici gecersiz email ve gecerli password ile giris yapamamali

    Given kullanici testotomasyonu anasayfaya gider
    When anasayfadaki account linkine tiklar
    Then email kutusuna configuration dosyasindaki "toInvalidEmail" degerini girer
    And password kutusuna configuration dosyasindaki "toValidPassword" degerini girer
    And login sayfasindaki signIn butonuna basar
    Then basarili olarak giris yapilamadigini test eder
    And senkronizasyon icin 3 saniye bekler
    And sayfayi kapatir

  Scenario: TC12 Kullanici gecerli email ve gecersiz password ile giris yapamamali
    Given kullanici testotomasyonu anasayfaya gider
    When anasayfadaki account linkine tiklar
    Then email kutusuna configuration dosyasindaki "toValidEmail" degerini girer
    And password kutusuna configuration dosyasindaki "toInvalidPassword" degerini girer
    Then login sayfasindaki signIn butonuna basar
    And basarili olarak giris yapilamadigini test eder
    And sayfayi kapatir

  Scenario: TC13 Kullanici gecersiz email ve gecersiz password ile giris yapamamali
    Given kullanici testotomasyonu anasayfaya gider
    When anasayfadaki account linkine tiklar
    Then email kutusuna configuration dosyasindaki "toInvalidEmail" degerini girer
    And password kutusuna configuration dosyasindaki "toInvalidPassword" degerini girer
    Then login sayfasindaki signIn butonuna basar
    And basarili olarak giris yapilamadigini test eder
    And sayfayi kapatir