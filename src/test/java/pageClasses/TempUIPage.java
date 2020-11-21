package pageClasses;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.xml.bind.v2.schemagen.xmlschema.Any;
import helper.TestBase;


public class TempUIPage extends TestBase {
	
	private Map<String, String> createEntityVar = new HashMap<>();
	String tempcity;
	
	public TempUIPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}
		

   /**
    * @author nikgoel1
    * @param city
    * @return
    */
	public String getTempDetail(String city) {
		try {
			if(driver.findElement(By.xpath("//div[@title='"+city+"']")).isDisplayed()==false){
			JavascriptExecutor js = (JavascriptExecutor)driver;	
			WebElement input= driver.findElement(By.xpath("//input[@id='"+city+"']"));
			js.executeScript("arguments[0].click();", input);
			}
			
			tempcity=driver.findElement(By.xpath("//div[@title='"+city+"']/div/span[1]")).getText();
			createEntityVar.put("TEMPCity", tempcity);
					
			test.log(LogStatus.PASS,
					 "Successfully get Temp of " + city  +" City from UI");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL,
					"Not able to get Temp from UI" + e.getMessage());
			throw e;
		}
		return	tempcity;
	}

}
