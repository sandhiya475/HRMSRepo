package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver=null;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@class='dropdown-toggle login-dropdown-a valignmiddle']")
	private WebElement logoutDD;
	
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//span[.='HRM']")
	private WebElement hrmLink;
	
	@FindBy(xpath = "//a[@title='My Dashboard']")
	private WebElement myDashboardLink;
	
	@FindBy(xpath = "//a[@title='Users & Groups']")
	private WebElement usersAndGroupsLink;
	

	
	
	public WebElement getHrmLink() {
		return hrmLink;
	}

	public WebElement getMyDashboardLink() {
		return myDashboardLink;
	}

	public WebElement getUsersAndGroupsLink() {
		return usersAndGroupsLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogoutDD() {
		return logoutDD;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	
	
}
