package helper;

import java.time.Duration;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
public class TestBase {

	protected WebDriver driver;
	protected ExtentTest test;

	public TestBase(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void sendKeys(WebElement ele, int waitInSec, String text, boolean isWaitReq) {
		if (isWaitReq)
			webdriverWaitVisibilityOf(ele, waitInSec);
		enterText(ele, text);

	}

	private void webdriverWaitUntilText(WebElement ele, int waitInSec) {
		try {
			new WebDriverWait(driver, waitInSec).until(
					(ExpectedCondition<Boolean>) driver -> (ele.getText().length() != 0) && (ele.getText() != null));
		} catch (Throwable e) {
		}
	}

	private void webdriverWaitClickable(WebElement ele, int waitInSec) {
		new WebDriverWait(driver, waitInSec).until(ExpectedConditions.elementToBeClickable(ele));
	}

	private void webdriverWaitTextToBePresent(WebElement ele, int waitInSec, String text) {
		new WebDriverWait(driver, waitInSec).until(ExpectedConditions.textToBePresentInElementValue(ele, text));
	}

	public void sendKeys(WebElement ele, String text) {
		webdriverWaitVisibilityOf(ele, Config.webdriverWait);
		enterText(ele, text);

	}

	public String getText(WebElement ele) {
		webdriverWaitVisibilityOf(ele, Config.webdriverWait);
		return getText(ele);
	}

	private void enterText(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	protected boolean isElementDisplayed(WebElement ele) {

		return ele.isDisplayed();
	}

	public void clickElement(WebElement ele) {
		ele.click();
	}

	
	public void webDriverWaitAndClick(WebElement ele) {

		webdriverWaitClickable(ele, Config.webdriverWait);
		clickElement(ele);
	}

	private void webdriverWaitVisibilityOf(WebElement ele, int waitInSec) {
		new WebDriverWait(driver, waitInSec).until(ExpectedConditions.visibilityOf(ele));
	}

	public void webDriverWaitAndClick(WebElement ele, int waitInSec) {

		webdriverWaitClickable(ele, waitInSec);
		clickElement(ele);
	}

	
}
