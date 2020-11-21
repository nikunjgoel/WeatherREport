Feature: Get Temperature of Hyderabad city from API and UI and match both in celcius
  @Weather
  Scenario Outline: To verify temperature in celcius for Hyderabad city from UI and API
    Given User is on Home Page "<TestCaseName>" and "<TestSheetName>"
    When User get temp detail from UI
     And User get temp detail from API
   Then verify temp of API and UI
      Examples: 
      | TestCaseName | TestSheetName |
      | SearchData   | UATSanity     |
 
 
  