package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/resources/features/WeatherReport.feature"}, glue = "stepDefinition",monochrome = true , tags = {"@Weather"}, dryRun = false)
public class TestRunner  extends AbstractTestNGCucumberTests{

}; 