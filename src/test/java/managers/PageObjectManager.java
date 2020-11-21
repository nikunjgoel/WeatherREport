package managers;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import pageClasses.HomePage;
import pageClasses.TempUIPage;
import pageClasses.TempVerifyDetail;

public class PageObjectManager {

	private WebDriver driver;

	private ExtentTest _test;

	private TempUIPage loginPage;

	private HomePage homePage;
	private TempVerifyDetail tempVerifydetail;

	public PageObjectManager(WebDriver driver, ExtentTest _test) {

		this.driver = driver;
		this._test = _test;
	}

	public TempUIPage getLoginPage() {

		return (loginPage == null) ? loginPage = new TempUIPage(driver, _test) : loginPage;

	}

	public HomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePage(driver, _test) : homePage;

	}

	public TempVerifyDetail getTempVerifyDetailPage() {

		return (tempVerifydetail == null) ? tempVerifydetail = new TempVerifyDetail(driver, _test) : tempVerifydetail;

	}
}
