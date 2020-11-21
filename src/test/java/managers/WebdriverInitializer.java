package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
import helper.Config;

public class WebdriverInitializer {

	private WebDriver driver = null;
	public DesiredCapabilities caps = null;

	public WebDriver init_driver() {

		try {

			caps = new DesiredCapabilities();

			switch (Config.browser.toLowerCase()) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						"C:\\ECBSanityQA\\edsts_automation\\drivers\\geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);

				break;

			case "chrome":
				// ChromeOptions option = new ChromeOptions();
				// caps = DesiredCapabilities.chrome();
				/*
				 * HashMap<String, Object> chromePrefs = new HashMap<String,
				 * Object>();
				 * chromePrefs.put("profile.default_content_settings.popups",
				 * 0); chromePrefs.put("download.default_directory",
				 * Config.DownloadFolder); option.setExperimentalOption("prefs",
				 * chromePrefs); caps.setCapability(ChromeOptions.CAPABILITY,
				 * option); caps.setBrowserName("chrome");
				 * caps.setPlatform(Platform.ANY);
				 */ System.setProperty("webdriver.chrome.driver", Config.chromeDriverExePath);
				driver = new ChromeDriver();
				break;

			case "IE":
				break;

			case "Remote":
				break;

			}

			driver.manage().timeouts().implicitlyWait(Config.implicitWait, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} catch (Throwable e) {
			throw new SkipException("issue while launching the browser" + e);
		}
		return driver;
	}

}
