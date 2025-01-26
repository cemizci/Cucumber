Feature:US1016 kullanici butonun erisilebilir olmasini bekler

  @smoke
  Scenario: TC22 Kullanici buton erisilebilir oluncaya kadar bekleyip
  butonun erisilebilir oldugunu test edebilmeli

    Given kullanici "demoqaUrl" anasayfaya gider
    Then Elements menusunu acar
    And Dynamic Properties menusune gider
    When Will enable 5 seconds butonunun enable olmasini bekler
    And Will enable 5 seconds butonunun enable oldugunu test eder



  @smoke
  Scenario: TC23 Kullanici buton gorunur oluncaya kadar bekleyip
  butonun erisilebilir oldugunu test edebilmeli

    Given kullanici "demoqaUrl" anasayfaya gider
    Then Elements menusunu acar
    And Dynamic Properties menusune gider
    When Visible after 5 seconds butonunun gorunur olmasini bekler
    And Visible after 5 seconds butonunun gorunur oldugunu test eder



  @smoke
  Scenario: TC24 Kullanici buton renk degistirinceye kadar bekleyip
  rengin degistigini test edebilmeli

    Given kullanici "demoqaUrl" anasayfaya gider
    Then Elements menusunu acar
    And Dynamic Properties menusune gider
    When Color change butonunun renginin degismesini bekler
    And Color change butonunun renginin degistigini test eder