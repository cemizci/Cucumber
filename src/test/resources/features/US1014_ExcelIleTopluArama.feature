
Feature: US1014 excelde verilen urunler aratilir ve sonuclar kaydedilir


  Scenario Outline: TC20 kullanici excelde verilen urunlerin
  belirlenen miktar veya daha fazla bulundugunu test edebilmeli
  ve bulunan sonuc sayisini tarih ile kaydeder

    Given kullanici urunListesi excel'indeki Sheet1 e gider
    Then listede verilen "<satır>" daki urun ismini ve minimum sonuc sayisini kaydeder
    When kullanici "toURL" anasayfaya gider
    And arama kutusuna kaydedilen urun ismini yazip aratir
    Then arama sonucunda minumum sonuc sayisi veya daha fazla urun bulunabildigini test eder
    And bulunan sonuc sayisini "<satır>" daki 6.sutuna, tarihi de 7.sutuna yazar


    Examples:
      |satır|
      |2    |
      |3    |
      |4    |
      |5    |
      |6    |
      |7    |
      |8    |
      |9    |