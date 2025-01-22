

 Feature:  US1001 Kullanıcı testotomasyonu sayfasında arama yapar

  Scenario: TC01 kullanıcı phone arattığında sonuc bulabilmeli
    Given Kullanıcı test otomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayı kapatır

  Scenario: TC02 kullanici dress arattiginda sonuc bulabilmeli
    Given Kullanıcı test otomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayı kapatır


  Scenario: TC03 kullanici Java arattiginda sonuc bulamamali
    Given Kullanıcı test otomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayı kapatır