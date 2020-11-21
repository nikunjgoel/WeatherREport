# WeatherREport
CONTENTS OF THIS FILE----- • Introduction • PREREQUISITES • Recommended modules

INTRODUCTION---

I attempt to automate NDTV site getting weather report using this framework without having to provision and manage any testing infrastructure. The service enables you to run your tests concurrently on browser to speed up the execution of your test suite, and generates reports and logs to help you quickly identify issues with your application.Using this framewok user get details from weather report API by passing city in Excel file and also get temperaure by UI and also verify both temperature in celcius.   

Concepts we will be talking about----

• Using BDD feature file to create test scenarios. • Page Objects to organize the methods on how to interact with the elements on the particular page. • Wrappers for commonly used AndroidDriver functions. • Actions classes grouping up commonly used methods, so tests are easier to create. • Extent report to create reports after exceution of test suites. • Logging functionlity using Log4j to identify quick issues. • Data driven using Apache POI Library to get test data from excel. • Using Maven to include jars used in framework . • Using Pagefactory method and scenario context so we can pass parameter from one stepdefinition file to another in a scenario. • Using Junit Assert to validate the test scenarios. 
PREREQUISITES----

• Eclipse (For local development/execution) : Oxygen • JDK (Java Development Kit) (For local development/execution): JDK 1.8.0_171-b11 • Rest-assured 2.9.0
• jackson-core-asl 1.9.2

Recommended modules---

UI Module: Get temperature details  in celcius from NDTV website by passing data in excel file.
API Module:   Get temperature details  in celcius from API  by passing data in excel file using rest assured and read response in json format and parse it using jackson jar. 
Compare Response: compare both API and UI response using junit assert and based on that test scenario get pass or fail.