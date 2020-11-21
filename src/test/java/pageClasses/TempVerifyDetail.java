package pageClasses;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import compare.Compare;
import helper.TestBase;

public class TempVerifyDetail extends TestBase {

	public TempVerifyDetail(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
  String UIVALUE;
	/**
	 * @author nikgoel1
	 * @descr Verify API value and UI value both in celcius
	 * @param UIValue
	 * @param city
	 * @throws Exception 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String gettempAPIUI(String UIValue, String city) {
		String APIVAl = null;
		String strAPIcelcius = null;
		boolean flag= false;
			try {
				APIVAl = Compare.resdAPIDATA(UIValue, city);
			String UIVAL = UIValue.replace("℃", ".0").trim();
			float kelvin = Float.parseFloat(APIVAl);
			float celsius = kelvin - 273.15F;
			System.out.println("Celsius: " + celsius);
			 strAPIcelcius = String.valueOf(celsius);
			test.log(LogStatus.PASS,
					 "Successfully get Temp of " + city  +" City from API and convert it in celcius");
			System.out.println("APIVAl" + strAPIcelcius);
			System.out.println("UIVAl" + UIVAL);
				} catch (Exception e) {
				System.out.println(e.getMessage());
				test.log(LogStatus.FAIL,
						"Successfully not get Temp of " + city  +" City from API and convert it in celcius" + e.getMessage());
					throw e;
			}
			return strAPIcelcius;
		
	}
	
	/**
	 * @author nikgoel1
	 * @deesc Verify API and UI temperature in celcius
	 * @param UIValue
	 * @param city
	 */
	public void verifytempAPIUI(String UIValue, String city) {
		try {
			 UIVALUE = UIValue.replace("℃", ".0").trim();
		assertTrue(UIVALUE.equalsIgnoreCase(city));
		test.log(LogStatus.PASS,
				 "Successfully Verify Temp of " + city  +" City from API and UI in celcius");
		} catch (AssertionError  e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL,
					"Temp value not get matched of UI as "+ UIVALUE + " and API as " + city + e.getMessage());
				throw e;
		}
	}
		
}
