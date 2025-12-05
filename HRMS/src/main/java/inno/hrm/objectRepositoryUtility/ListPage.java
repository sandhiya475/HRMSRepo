package inno.hrm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPage {

	WebDriver driver;

	public ListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	@FindBy(xpath ="//button[.='Yes']")
	private WebElement yesbutton;
	
	
	public WebElement getYesbutton() {
		return yesbutton;
	}
	
	@FindBy(xpath = "//div[.='Record deleted']/ancestor::div[@class='jnotify-message']")
	private WebElement deleteMessage;
	
	

	public WebElement getDeleteMessage() {
		return deleteMessage;
	}
	
	@FindBy(xpath = "//a[contains(text(),'ER2512')]")
	private WebElement leaveRefId;
	
	@FindBy(xpath = "//a[.='Validate']")
	private WebElement validateButton;
	
	
	 @FindBy(xpath = "//a[.='Approve']")
	 private WebElement approveButton;
	 
	 @FindBy(xpath = "//span[text()='Approved']")
	 private WebElement empApproveButton;
	 
	 
	public WebElement getEmpApproveButton() {
		return empApproveButton;
	}


	public WebElement getValidateButton() {
		return validateButton;
	}


	public WebElement getApproveButton() {
		return approveButton;
	}


	public WebElement getLeaveRefId() {
		return leaveRefId;
	}
	
	
	@FindBy(xpath = "//span[@title='Approved']")
	private WebElement leaveStatus;	

	public WebElement getLeaveStatus() {
		return leaveStatus;
	}
	
	
	@FindBy(xpath = "//a[@class='classforajaxtooltip']")
	private WebElement expenseRefId;
	
	public WebElement getExpenseRefId() {
		return expenseRefId;
	}

	@FindBy(xpath = "//a[.='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//a[.='Delete']")
	private WebElement leaveDeleteButton;
	
	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getLeaveDeleteButton() {
		return leaveDeleteButton;
	}
	
	@FindBy(xpath = "//a[.='Back to draft']")
	private WebElement draftbutton;
	
	
	

	public WebElement getDraftbutton() {
		return draftbutton;
	}


	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[4]/div[5]/a")
	private WebElement empListLink;

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getEmpListLink() {
		return empListLink;
	}
	
	@FindBy(xpath = "(//td[contains(@class,'nowrap')]/a[contains(text(),'HL2512')][1])[4]")
	private WebElement draftIdBtn;

	public WebElement getDraftIdBtn() {
		return draftIdBtn;
	}
	
	


	
}
