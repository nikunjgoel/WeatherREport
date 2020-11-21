package stepDefinition;

import java.util.HashMap;
import java.util.Map;
import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageClasses.TempUIPage;

public class TempUIPageSteps {

	TestContext testContext;
	TempUIPage loginPage;
	Map<String, String> testData = new HashMap<>();
	public TempUIPageSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();

	}

	@When("^User get temp detail from UI$")
	public void userLoginwithCredentials() {
		Map<String, String> createEntityVar = new HashMap<>();	
		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
		String tempcity =loginPage.getTempDetail(testData.get("City"));
	   testContext.scenarioContext.setContext(Context.TEMP, tempcity);
		
	}
		
}
