package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfJobPositionPage {
	WebDriver driver=null;
	public ListOfJobPositionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//td[text()='Quality Analyst']")
		private WebElement listOfJobs;
		public WebDriver getDriver() {
			return driver;
		}
		public WebElement getListOfJobs() {
			return listOfJobs;
		}
		
		
}
