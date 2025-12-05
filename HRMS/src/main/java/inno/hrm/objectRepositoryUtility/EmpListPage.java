package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmpListPage {
	WebDriver driver=null;
	public EmpListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//span[text()='sandy.s']")
		private WebElement empList;
		
		public WebDriver getDriver() {
			return driver;
		}
		public WebElement getEmpList() {
			return empList;
		}
		
		
}
