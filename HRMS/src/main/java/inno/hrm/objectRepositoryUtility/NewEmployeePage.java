package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEmployeePage {
	WebDriver driver=null;
	public NewEmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="lastname")
		private WebElement empLastNameTF;
		
		@FindBy(id="firstname")
		private WebElement empFirstNameTF;
		
		@FindBy(id="select2-gender-container")
		private WebElement empGenderDD;
		
		@FindBy(xpath="//li[text()='Female']")
		private WebElement empSelectGender;
		
		@FindBy(xpath="//span[@id='select2-fk_user-container']")
		private WebElement empUserDD;
		
		@FindBy(xpath="//li[text()=' Sandhiya SuperAdmin']")
		private WebElement SelectSuperAdmin;
		
		@FindBy(id="select2-fk_user_expense_validator-container")
		private WebElement empExpenseDD;
		
		@FindBy(id="select2-fk_user_holiday_validator-container")
		private WebElement empHolidayDD;
		
		@FindBy(name="office_phone")
		private WebElement empPhoneNumberTF;
		
		@FindBy(name="email")
		private WebElement empEmailTF;
		
		@FindBy(id="dateofbirth")
		private WebElement empDOBTF;
		
		@FindBy(xpath="//input[@value='Create user']")
		private WebElement empCreateUserBtn;
		
		@FindBy(linkText = "×")
		private WebElement closeIcon;
		
		public WebElement getCloseIcon() {
			return closeIcon;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getEmpLastNameTF() {
			return empLastNameTF;
		}

		public WebElement getEmpFirstNameTF() {
			return empFirstNameTF;
		}

		public WebElement getEmpGenderDD() {
			return empGenderDD;
		}

		public WebElement getEmpSelectGender() {
			return empSelectGender;
		}

		public WebElement getEmpUserDD() {
			return empUserDD;
		}

		public WebElement getSelectSuperAdmin() {
			return SelectSuperAdmin;
		}

		public WebElement getEmpExpenseDD() {
			return empExpenseDD;
		}

		public WebElement getEmpHolidayDD() {
			return empHolidayDD;
		}

		public WebElement getEmpPhoneNumberTF() {
			return empPhoneNumberTF;
		}

		public WebElement getEmpEmailTF() {
			return empEmailTF;
		}

		public WebElement getEmpDOBTF() {
			return empDOBTF;
		}

		public WebElement getEmpCreateUserBtn() {
			return empCreateUserBtn;
		}
		
		
}
