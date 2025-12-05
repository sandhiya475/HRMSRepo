package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrmPage {
	WebDriver driver;
    public HrmPage(WebDriver driver) {
    this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//a[text()='Employees']")
	private WebElement employeeLink;
	
	@FindBy(xpath="//a[@title='New employee']")
	private WebElement newEmployeeLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair blockvmenufirst']/descendant::a[@title='List']")
	private WebElement employeeListLink;
	
	@FindBy(xpath = "//a[@title='Skills management']")
	private WebElement skillsManagementLink;
	
	@FindBy(xpath="//a[@title='Leave']")
	private WebElement leaveLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='New']")
	private WebElement leaveNewLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='New collective leave']")
	private WebElement newCollectiveLeaveLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='List']")
	private WebElement listLeaveLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='Balance of leave']")
	private WebElement balanceOfLeaveLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='Monthly statement']")
	private WebElement monthlyStatementLink;
	
	@FindBy(xpath="//div[@class='blockvmenu blockvmenupair']/descendant::a[text()='View change logs']")
	private WebElement viewChangeLogsLink;
	
	@FindBy(xpath="//a[@title='Expense reports']")
	private WebElement expenseReportsLink;
	
	@FindBy(xpath="(//a[text()='New'])[2]")
	private WebElement expenseReportsNewLink;
	
	@FindBy(xpath="//div[@class='menu_contenu menu_contenu_expensereport_list']")
	private WebElement expenseReportsListLink;
	
	@FindBy(xpath="//div[@class='menu_contenu menu_contenu_expensereport_stats_index']")
	private WebElement expenseReportsStatisticsLink;
	
	@FindBy(xpath="//a[@title='Recruitment']")
	private WebElement recruitmentLink;
	
	@FindBy(linkText = "New job positions")
	private WebElement newJobPositionsLink;
	
	@FindBy(linkText = "List of job positions")
	private WebElement listOfJobPositionsLink;
	
	@FindBy(linkText = "New application")
	private WebElement newApplicationLink;
	
	@FindBy(linkText = "List of applications")
	private WebElement listOfApplicationsLink;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmployeeLink() {
		return employeeLink;
	}

	public WebElement getNewEmployeeLink() {
		return newEmployeeLink;
	}

	public WebElement getEmployeeListLink() {
		return employeeListLink;
	}

	public WebElement getSkillsManagementLink() {
		return skillsManagementLink;
	}

	public WebElement getLeaveLink() {
		return leaveLink;
	}

	public WebElement getLeaveNewLink() {
		return leaveNewLink;
	}

	public WebElement getNewCollectiveLeaveLink() {
		return newCollectiveLeaveLink;
	}

	public WebElement getListLeaveLink() {
		return listLeaveLink;
	}

	public WebElement getBalanceOfLeaveLink() {
		return balanceOfLeaveLink;
	}

	public WebElement getMonthlyStatementLink() {
		return monthlyStatementLink;
	}

	public WebElement getViewChangeLogsLink() {
		return viewChangeLogsLink;
	}

	public WebElement getExpenseReportsLink() {
		return expenseReportsLink;
	}

	public WebElement getExpenseReportsNewLink() {
		return expenseReportsNewLink;
	}

	public WebElement getExpenseReportsListLink() {
		return expenseReportsListLink;
	}

	public WebElement getExpenseReportsStatisticsLink() {
		return expenseReportsStatisticsLink;
	}

	public WebElement getRecruitmentLink() {
		return recruitmentLink;
	}

	public WebElement getNewJobPositionsLink() {
		return newJobPositionsLink;
	}

	public WebElement getListOfJobPositionsLink() {
		return listOfJobPositionsLink;
	}

	public WebElement getNewApplicationLink() {
		return newApplicationLink;
	}

	public WebElement getListOfApplicationsLink() {
		return listOfApplicationsLink;
	}
	
	
}
