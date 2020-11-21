package helper;

public class Config {

	public static String log4jpath = System.getProperty("user.dir") + "\\log\\log4j.properties";
	public static String log4jfilepath = System.getProperty("user.dir") + "//log//info.log";
	public static String browser = "Chrome"; // IE/Chrome/firefox

	public static int implicitWait = 10;
	public static int webdriverWait = 100;

	// Files location
	public static String reportPath = System.getProperty("user.dir") + "//reports//" + GenUtility.getDayWithSeconds()
			+ ".html";
	public static String reportConfigFilePath = System.getProperty("user.dir") + "//extent-config.xml";
	public static String testDataFilePath = System.getProperty("user.dir") + "//src//test//java//data//TestData.xlsx";

	// Screenshots location
	public static String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\";

	public static String excelWorkbookName = "TestCase";
	public static String excelWorksheetName = "CreateEntity";
	public static String excelClumnName = "Test Case Name";
	public static String DownloadFolder = System.getProperty("user.dir") + "\\Downloads\\";
	public static String chromeDriverExePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
	public static String siteUrl = "https://social.ndtv.com/static/Weather/report/";

}
