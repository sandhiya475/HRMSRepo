package inno.hrm.basetest;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import inno.hrm.generic.fileutility.ExcelUtility;
import inno.hrm.generic.fileutility.PropertiesFileUtility;
import inno.hrm.generic.webdriverUtility.JavaUtility;
import inno.hrm.generic.webdriverUtility.UtilityClassObject;
import inno.hrm.generic.webdriverUtility.WebDriverUtility;
import inno.hrm.objectRepositoryUtility.HomePage;
import inno.hrm.objectRepositoryUtility.LoginPage;

public class BaseClass1 {
	
	public PropertiesFileUtility putil=new PropertiesFileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriver driver=null;
	//public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		Reporter.log("---Connect to DB,Report config---",true);
		
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	            //String browser
	public void configBC() throws Throwable {
		System.out.println("---Launch the Browser---");
		String BROWSER =putil.getDataFromPropertiesFile("browser");
		//String BROWSER=browser;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		UtilityClassObject.SetDriver(driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		System.out.println("---Login to the Application---");
		String URL = putil.getDataFromPropertiesFile("url");
		String AUSERNAME = putil.getDataFromPropertiesFile("admin_username");
		String APASSWORD = putil.getDataFromPropertiesFile("admin_password");
//		String EUSERNAME = putil.getDataFromPropertiesFile("employee_username");
//		String EPASSWORD = putil.getDataFromPropertiesFile("employee_password");
//		String HRUSERNAME = putil.getDataFromPropertiesFile("hr_username");
//		String HRPASSWORD = putil.getDataFromPropertiesFile("hr_password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToAdmin(URL,AUSERNAME, APASSWORD);
//		lp.loginToEmployee(URL,EUSERNAME, EPASSWORD);
//		lp.loginToHr(URL, HRUSERNAME, HRPASSWORD);
//		wutil.toimplicitWait(driver);
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
	   Reporter.log("---Logout the Application---",true);	
	   HomePage hp=new HomePage(driver);
	   Actions action=new Actions(driver);
	   action.moveToElement(hp.getLogoutDD()).perform();
	   hp.getLogoutDD().click();
	   hp.getLogoutBtn().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		Reporter.log("---Close the Brower---",true);
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		Reporter.log("---Close DB,Report Backup---",true);
	
	}
}
