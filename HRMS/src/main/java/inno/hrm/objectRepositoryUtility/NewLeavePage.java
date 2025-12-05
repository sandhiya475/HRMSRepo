package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLeavePage {
	WebDriver driver=null;
	public NewLeavePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='New']")
		private WebElement newLeaveLink;
		
		@FindBy(xpath="(//span[@class='placeholder'])[1]")
		private WebElement LeaveDD;
		
		@FindBy(xpath="//li[text()='Sick Leave']")
		private WebElement selectSickLeave;
		
		@FindBy(id="date_debut_")
		private WebElement startLeaveDateTF;
		
		@FindBy(id="date_fin_")
		private WebElement endLeaveDateTF;
		
		@FindBy(id="select2-valideur-container")
		private WebElement validatorDD;
		
		@FindBy(xpath="//li[text()=' Sandhiya SuperAdmin']")
		private WebElement selectSuperAdmin;
		
		@FindBy(id="description")
		private WebElement descriptionTF;
		
		@FindBy(xpath="//input[@value='Create leave request']")
		private WebElement createLeaveBtn;
		
		@FindBy(linkText="×")
		private WebElement closeBtn;
		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getNewLeaveLink() {
			return newLeaveLink;
		}

		public WebElement getLeaveDD() {
			return LeaveDD;
		}

		public WebElement getSelectSickLeave() {
			return selectSickLeave;
		}

		public WebElement getStartLeaveDateTF() {
			return startLeaveDateTF;
		}

		public WebElement getEndLeaveDateTF() {
			return endLeaveDateTF;
		}

		public WebElement getValidatorDD() {
			return validatorDD;
		}

		public WebElement getSelectSuperAdmin() {
			return selectSuperAdmin;
		}

		public WebElement getDescriptionTF() {
			return descriptionTF;
		}

		public WebElement getCreateLeaveBtn() {
			return createLeaveBtn;
		}

		public WebElement getCloseBtn() {
			return closeBtn;
		}
		
		
}
