package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
    public LoginPage(WebDriver driver) {
    this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(id="username")
	private WebElement usernameTF;
	
	@FindBy(id="password")
	private WebElement passwordTF;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAusernameTF() {
		return usernameTF;
	}

	public WebElement getApasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToAdmin(String url,String ausername,String apassword ) {
		driver.get(url);
		usernameTF.clear();
		usernameTF.sendKeys(ausername);
		passwordTF.clear();
		passwordTF.sendKeys(apassword);
		loginBtn.click();
	}
	
public void loginToEmployee(String url,String eusername,String epassword) {
		driver.get(url);
		usernameTF.clear();
		usernameTF.sendKeys(eusername);
		passwordTF.clear();
		passwordTF.sendKeys(epassword);
		loginBtn.click();
	}
	
public void loginToHr(String url,String hrusername,String hrpassword) {
	driver.get(url);
	usernameTF.clear();
	usernameTF.sendKeys(hrusername);
	passwordTF.clear();
	passwordTF.sendKeys(hrpassword);
	loginBtn.click();
}
	
}
