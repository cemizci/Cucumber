
  Feature: US1011 kullanici liste olarak verilen urunleri aratir

    @wip
    Scenario Outline: TC17 Verilen her bir urun bulunabilmeli

      Given kullanici "toURL" anasayfaya gider
      When arama kutusuna "<aratilacakUrun>" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And  sayfayi kapatir

      Examples:
        | aratilacakUrun |
        | phone          |
        | samsung        |
        | java           |
        | apple          |
        | cokoprens      |
        | dress          |
