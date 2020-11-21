package cucumber;

import java.io.File;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import helper.ExtentManager;
import helper.GenUtility;
import managers.PageObjectManager;
import managers.WebdriverInitializer;

public class TestContext {
	private WebDriver driver;
	private ExtentReports _extent = ExtentManager.getInstance();
	private PageObjectManager pageObjectManager;
	private ExtentTest _test;
	public ScenarioContext scenarioContext;

	public TestContext() {
		scenarioContext = new ScenarioContext();
	}

	public ExtentTest getExtentTest() {
		return _test;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setScenarioContext(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void setPageObjectManager(PageObjectManager pageObjectManager) {
		this.pageObjectManager = pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public void closeTest() {
		_extent.endTest(_test);
		_extent.flush();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void startTest(String testName, String desc) {
		_test = _extent.startTest(testName, desc);
	}

	public void init() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File logdir = new File(classpathRoot, "/log/");
		File log4j = new File(logdir, "log4j.properties");
		System.out.println(log4j.getAbsolutePath());
		PropertyConfigurator.configure(log4j.getAbsolutePath());
		driver = new WebdriverInitializer().init_driver();
		_test = _extent.startTest("Weather Report" + GenUtility.getRandomAlphaNumString());
		setPageObjectManager(new PageObjectManager(driver, _test));
	}

}
