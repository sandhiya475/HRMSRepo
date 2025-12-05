package inno.hrm.objectRepositoryUtility;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import inno.hrm.generic.fileutility.ExcelUtility;
import inno.hrm.generic.webdriverUtility.JavaUtility;
import inno.hrm.generic.webdriverUtility.WebDriverUtility;

public class NewExpensePage {
	
	WebDriver driver;
	
	public NewExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='date_debut']")
	private WebElement expenseStartDate;
	
	@FindBy(id="date_fin")
	private WebElement expenseEndDate;
	
	@FindBy(xpath = "//input[@value='Create expense report']")
	private WebElement createExpenseButton;
	

	@FindBy(xpath="//input[@id='date']")
	private WebElement docDateButton;
	
	@FindBy(xpath ="//span[@id='select2-fk_c_type_fees-container']")
	private WebElement expenseTypeDropDown;
	
	@FindBy(xpath = "//li[text()='Lunch']")
	private WebElement expenseTypeOptions;
	
	@FindBy(id="value_unit_ht")
	private WebElement amountnetField;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAmountnetField() {
		return amountnetField;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getApproveBtn() {
		return approveBtn;
	}

	public JavaUtility getJutil() {
		return jutil;
	}

	public WebDriverUtility getWutil() {
		return wutil;
	}

	public ExcelUtility getEutil() {
		return eutil;
	}

	public void setAmounttxtField(WebElement amounttxtField) {
		this.amounttxtField = amounttxtField;
	}

	@FindBy(id="value_unit")
	private WebElement amounttxtField;
	
	@FindBy(name = "add")
	private WebElement addButton;
	
	@FindBy(xpath = "//a[.='Validate and submit for approval']")
	private WebElement validateandSubmitButton;
	
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesBtn;
	//a[text()='Approve']
	@FindBy(xpath = "//a[text()='Approve']")
	private WebElement approveBtn;
	
	@FindBy(xpath = "//a[contains(text(),\"Classify 'Paid'\")]")
	private WebElement paidButton;
	
	@FindBy(xpath = "//a[.=\"Classify 'Unpaid'\"]")
	private WebElement unpaidButton;
	
	@FindBy(xpath = "//a[contains(@class,'butActionDelete') and contains(.,'Delete')]")
	private WebElement deleteButton;
	
	
	public WebElement getUnpaidButton() {
		return unpaidButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getPaidButton() {
		return paidButton;
	}

	public WebElement getAmounttxtField() {
		return amounttxtField;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getValidateandSubmitButton() {
		return validateandSubmitButton;
	}

	public WebElement getDocDateButton() {
		return docDateButton;
	}

	public WebElement getExpenseTypeDropDown() {
		return expenseTypeDropDown;
	}

	public WebElement getExpenseTypeOptions() {
		return expenseTypeOptions;
	}

	public WebElement getExpenseStartDate() {
		return expenseStartDate;
	}

	public WebElement getExpenseEndDate() {
		return expenseEndDate;
	}

	public WebElement getCreateExpenseButton() {
		return createExpenseButton;
	}
	
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesButton;
	
	@FindBy(xpath="//span[text()='Paid']")
	private WebElement paidStatus;
	
	public WebElement getPaidStatus() {
		return paidStatus;
	}

	public WebElement getYesButton() {
		return yesButton;
	}
	
	public WebElement getExpenseStatus() {
		return expenseStatus;
	}


	@FindBy(xpath = "//span[.='Paid']")
	private WebElement expenseStatus;
	
	

	JavaUtility jutil = new JavaUtility();
	WebDriverUtility wutil =new WebDriverUtility();
	ExcelUtility eutil = new ExcelUtility();
	
	//ListPage lsp = new ListPage(driver);
	
	public void createExpense() throws IOException, Throwable {
		
		expenseStartDate.click();
		expenseEndDate.click();
		createExpenseButton.click();
		docDateButton.click();
		expenseTypeDropDown.click();
		expenseTypeOptions.click();
		amounttxtField.sendKeys(eutil.getDataFromExcel("Expense", 1,3 ));
		addButton.click();
	}
	
	
	public void deleteExpense() {
		
		unpaidButton.click();
		yesButton.click();
		wutil.explicitwaitforelementToBeClickable(driver, deleteButton);
		wutil.javascriptDisableElement(driver, deleteButton);
//		wlib.scrollintoViewJS(driver, deleteButton);
//		deleteButton.click();
		yesButton.click();
		
	}
	
	
}
