package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helper.Config;
import helper.TestBase;

public class HomePage extends TestBase {

	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public String HomePageNavigation() {
		try {

			driver.get(Config.siteUrl);
			//driver.findElement(By.xpath("//id")).click();
			test.log(LogStatus.PASS,
					"NDTV Weather Report Page open successfully");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL,
					"Home page is not loaded successfully with following exception: " + e.getMessage());
				throw e;
		}
		return driver.getTitle();
	}

}
