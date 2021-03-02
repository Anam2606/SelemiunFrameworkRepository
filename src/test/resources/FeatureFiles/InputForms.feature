Feature: Input Forms

  Background: home page
  #  Given user is on home page "https://www.seleniumeasy.com/test/"
    Given user is on home page "https://www.seleniumeasy.com/test/basic-checkbox-demo.html"
    #/https://www.seleniumeasy.com/test/

 @test
  #@smoke @sanity
  Scenario Outline: Simple Forms
    When user selects input form
    And user selects simple form demo
    And user enters message <msg>
    And user clicks on show message button
    Then entered message should display <msg>
    Examples:
      | msg          |
      | "My Message" |

@test
  Scenario: Checkbox Demo
    When user selects input form
    And user selects checkbox demo
    And user selects checkbox
    Then a message should be displayed "Success - Check box is checked"
    When user clicks on check all button
    Then all checkboxes should be checked
      | checkbox1 | checkbox2 | checkbox3 | checkbox4 |
    And uncheck all button should be displayed
    When user clicks on uncheck all button
    Then all checkboxes should be unchecked
      | checkbox1 | checkbox2 | checkbox3 | checkbox4 |

  @test
  Scenario: Radio Button Demo
    When user selects input form
    And user selects radio button demo
    And user selects sex and age group & clicks on get value
      | sex    | age_group | sex_msg      | age_group_msg      |
      | Male   | 0 to 5    | Sex : Male   | Age group: 0 - 5   |
      | Male   | 5 to 15   | Sex : Male   | Age group: 5 - 15  |
      | Male   | 15 to 50  | Sex : Male   | Age group: 15 - 50 |
      | Female | 0 to 5    | Sex : Female | Age group: 0 - 5   |
      | Female | 5 to 15   | Sex : Female | Age group: 5 - 15  |
      | Female | 15 to 50  | Sex : Female | Age group: 15 - 50 |

  @test
  Scenario Outline: Select Data From Table
    When user selects table
    And user selects table sort and search
    And fetch data for user <user>
    Examples:
      | user       |
      | "C. Hurst" |

  @test
  Scenario: Selenium Table
    When user selects table
    And user selects table sort and search
    Then printUserDetails "C. Kelly"
    And ageGreaterThen 40
    And pagination "Y. Berry"

#  Scenario Outline: Search Products
#    When user enters product name <Mobile> in the search box
#    And user clicks on search icon
#    Then user should see the search list products
#    Examples:
#      | Mobile   |
#      | iPhone   |
#      | Motorola |
#
#  Scenario: Tabs Available
#    Then user should see below tabs
#      | Best Sellers | Mobile | Today's Deal | Fashion | New Release |
#    And user will see the
#
#  Scenario: Promocode
#    Given user is on login page
#    When user log's in
#    Then user should see the payment page
#    And user validates premium
#    When user applies promocode and re validate the premium
#      | promocode | promoDescription    |
#      | promo1    | this is promocode 1 |
#      | promo2    | this is promocode 2 |
#    Then logout from application