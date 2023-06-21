Feature: Scenario PopUp Menu

  Scenario: Popup assertion

    Given user opens "APIDEMOS" on the phone "SAMSUNG_A33"
    When user clicks "API Demos"
    When user clicks "Views"
    And user clicks "Popup Menu"
    And user clicks "MAKE A POPUP!"
    Then "Add" should be visible
    When user clicks "Add"
    Then "Clicked" should be visible