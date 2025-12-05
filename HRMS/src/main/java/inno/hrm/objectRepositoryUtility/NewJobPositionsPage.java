package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewJobPositionsPage {
	WebDriver driver=null;
	public NewJobPositionsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="label")
		private WebElement labelTF;
		
		@FindBy(id="qty")
		private WebElement labelQuantityTF;
		
		@FindBy(id="email_recruiter")
		private WebElement recruiterMailTF;
		
		@FindBy(id="date_planned")
		private WebElement datePlannedTF;
		
		@FindBy(id="remuneration_suggested")
		private WebElement salaryTF;
		
		@FindBy(id="description")
		private WebElement descriptionTF;
		
		@FindBy(xpath="//input[@value='Create']")
		private WebElement jobCreateBtn;
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getLabelTF() {
			return labelTF;
		}

		public WebElement getLabelQuantityTF() {
			return labelQuantityTF;
		}

		public WebElement getRecruiterMailTF() {
			return recruiterMailTF;
		}

		public WebElement getDatePlannedTF() {
			return datePlannedTF;
		}

		public WebElement getSalaryTF() {
			return salaryTF;
		}

		public WebElement getDescriptionTF() {
			return descriptionTF;
		}

		public WebElement getJobCreateBtn() {
			return jobCreateBtn;
		}
		
	   
}
