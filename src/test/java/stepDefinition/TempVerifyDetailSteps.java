package stepDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import helper.WeatherController;
import pageClasses.TempUIPage;
import pageClasses.TempVerifyDetail;

public class TempVerifyDetailSteps {

	TestContext testContext;
	TempVerifyDetail tempVerify;
	String Apival;
	Map<String, String> testData = new HashMap<>();

	public TempVerifyDetailSteps(TestContext context) {
		testContext = context;
		tempVerify = testContext.getPageObjectManager().getTempVerifyDetailPage();

	}

	@When("^User get temp detail from API$")
	public void usergetAPITempDetail() throws JsonParseException, JsonMappingException, IOException {
		Map<String, String> createEntityVar = new HashMap<>();	
		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
		String APITempval=testContext.scenarioContext.getContext(Context.TEMP).toString();
		Apival=tempVerify.gettempAPIUI(APITempval,testData.get("City"));
	
	}
	@Then("^verify temp of API and UI$")
	public void VerifyTempofBothAPIUI() {
			String APITempval=testContext.scenarioContext.getContext(Context.TEMP).toString();
		tempVerify.verifytempAPIUI(APITempval,Apival);
		
	}	
}
