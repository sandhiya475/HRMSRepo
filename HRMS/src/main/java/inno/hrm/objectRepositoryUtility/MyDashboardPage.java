package inno.hrm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
	
	 public MyDashboardPage( WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@title='Holidays to approve']")
	private WebElement dashLeaveLink;

	public WebElement getDashLeaveLink() {
		return dashLeaveLink;
	}
	
	@FindBy(xpath = "//div[@title='Expense report']/following-sibling::div/descendant::div[.='To approve']")
	private WebElement dashExpenseLink;

	public WebElement getDashExpenseLink() {
		return dashExpenseLink;
	}
	
	
	

}
