package systemTest;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import inno.hrm.basetest.BaseClass1;
import inno.hrm.generic.webdriverUtility.UtilityClassObject;
import inno.hrm.objectRepositoryUtility.EmpListPage;
import inno.hrm.objectRepositoryUtility.HomePage;
import inno.hrm.objectRepositoryUtility.HrmPage;
import inno.hrm.objectRepositoryUtility.ListPage;
import inno.hrm.objectRepositoryUtility.LoginPage;
import inno.hrm.objectRepositoryUtility.NewEmployeePage;
import inno.hrm.objectRepositoryUtility.NewExpensePage;
import inno.hrm.objectRepositoryUtility.NewLeavePage;
@Listeners(inno.hrm.listenerutility.ListImpClass.class)
public class HrmSystemTest extends BaseClass1 {
	@Test(groups = "RegressionTest")
	public void approveLeave() throws Throwable {
		String EUN = eutil.getDataFromExcel("Employee", 4, 8);
		String EPWD = eutil.getDataFromExcel("Employee", 4, 9);
		String DESC = eutil.getDataFromExcel("Leave", 1, 5);
		String AUN = eutil.getDataFromExcel("Employee", 1, 7);
		String APWD = eutil.getDataFromExcel("Employee", 1, 8);
		String EXPECTED = eutil.getDataFromExcel("Employee", 1, 9);
		HomePage hp = new HomePage(driver);
		hp.getLogoutDD().click();
		hp.getLogoutBtn().click();
		LoginPage lp = new LoginPage(driver);
		lp.getAusernameTF().sendKeys(EUN);
		lp.getApasswordTF().sendKeys(EPWD);
		lp.getLoginBtn().click();
		hp.getHrmLink().click();
		HrmPage hrm = new HrmPage(driver);
		hrm.getLeaveNewLink().click();
		NewLeavePage nlp = new NewLeavePage(driver);
		nlp.getLeaveDD().click();
		nlp.getSelectSickLeave().click();
		LocalDate today = LocalDate.now();
		LocalDate startDate = today.plusDays(1);
		LocalDate endDate = today.plusDays(2);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String start = startDate.format(dtf);
		String end = endDate.format(dtf);
		nlp.getStartLeaveDateTF().sendKeys(start);
		nlp.getEndLeaveDateTF().sendKeys(end);
		nlp.getValidatorDD().click();
		nlp.getSelectSuperAdmin().click();
		nlp.getDescriptionTF().sendKeys(DESC);
		nlp.getCreateLeaveBtn().click();
		nlp.getCloseBtn().click();
		Reporter.log("Employee leave applied successfully", true);
		hp.getLogoutDD().click();
		hp.getLogoutBtn().click();
		lp.getAusernameTF().sendKeys(AUN);
		lp.getApasswordTF().sendKeys(APWD);
		lp.getLoginBtn().click();
		hp.getHrmLink().click();
		ListPage lip = new ListPage(driver);
		lip.getEmpListLink().click();
		WebElement draftID = lip.getDraftIdBtn();
		draftID.click();
		String expec = EXPECTED;
		String actu = lip.getEmpApproveButton().getText();
		Assert.assertEquals(expec, actu);
		Reporter.log("Approved leave message present in employee list", true);
	}

	@Test(groups = "RegressionTest")
	public void approveExpenceTest() throws IOException, Throwable {
		HomePage hp = new HomePage(driver);
		hp.getHrmLink().click();
		wutil.javascriptScrollBy(driver);
		HrmPage hrm = new HrmPage(driver);
		WebElement ele = hrm.getExpenseReportsNewLink();
		wutil.explicitwaitforelementToBeClickable(driver, ele);
		ele.click();
		NewExpensePage nexp = new NewExpensePage(driver);
		String NETAMO = eutil.getDataFromExcel("Expense", 1, 3);
		String TAXAMO = eutil.getDataFromExcel("Expense", 1, 4);
		String DATE = eutil.getDataFromExcel("Expense", 1, 5);
		LocalDate today = LocalDate.now();
        // generate random unique date range
		int randomDays = new Random().nextInt(5) + 1;
		LocalDate start = today.plusDays(randomDays);
		LocalDate end = start.plusDays(1);
        // Format dates to MM/dd/yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String startDateStr = start.format(formatter);
		String endDateStr = end.format(formatter);
        // Enter dates (ONLY ONCE)
		nexp.getExpenseStartDate().clear();
		nexp.getExpenseStartDate().sendKeys(startDateStr);
		nexp.getExpenseEndDate().clear();
		nexp.getExpenseEndDate().sendKeys(endDateStr);
        // Create expense report
		WebElement btnEle = nexp.getCreateExpenseButton();
		wutil.explicitwaitforelementToBeClickable(driver, btnEle);
		btnEle.click();
		WebElement fdate = nexp.getDocDateButton();
		wutil.explicitwaitforelementToBeClickable(driver, fdate);
		fdate.sendKeys(DATE);
		nexp.getExpenseTypeDropDown().click();
		nexp.getExpenseTypeOptions().click();
		nexp.getAmountnetField().sendKeys(NETAMO);
		nexp.getAmounttxtField().sendKeys(TAXAMO);
		nexp.getAddButton().click();
		Reporter.log("Expense Report Submitted Successfully", true);
		nexp.getValidateandSubmitButton().click();
		nexp.getYesBtn().click();
		nexp.getApproveBtn().click();
		nexp.getYesBtn().click();
		nexp.getPaidButton().click();
		Reporter.log("Expense has Approved and Paid", true);
		
	}

	@Test(groups = "RegressionTest")
	public void deleteEmployee() throws Throwable {
		wutil.toimplicitWait(driver);
		HomePage hp = new HomePage(driver);
		hp.getHrmLink().click();
		HrmPage hrm = new HrmPage(driver);
		hrm.getNewEmployeeLink().click();
		NewEmployeePage nep = new NewEmployeePage(driver);
		int rno = jutil.toGenerateRandomNumber();

		String EFN = eutil.getDataFromExcel("Employee", 4, 2);
		String ELN = eutil.getDataFromExcel("Employee", 4, 3) + rno;
		String EMNO = eutil.getDataFromExcel("Employee", 4, 5);
		String EDOB = eutil.getDataFromExcel("Employee", 4, 6);
		String EXPECDA = eutil.getDataFromExcel("Employee", 4, 7);

		System.out.println(ELN);
		nep.getEmpLastNameTF().sendKeys(EFN);
		nep.getEmpFirstNameTF().sendKeys(ELN);
		nep.getEmpGenderDD().click();
		nep.getEmpSelectGender().click();
		nep.getEmpUserDD().click();
		nep.getSelectSuperAdmin().click();
		nep.getEmpExpenseDD().click();
		nep.getSelectSuperAdmin().click();
		nep.getEmpHolidayDD().click();
		nep.getSelectSuperAdmin().click();
		nep.getEmpPhoneNumberTF().sendKeys(EMNO);
		nep.getEmpDOBTF().sendKeys(EDOB);
		nep.getEmpCreateUserBtn().click();
		Reporter.log("New employee created successfully", true);
		hrm.getEmployeeListLink().click();
		String expectedValue = EXPECDA;
		EmpListPage elp = new EmpListPage(driver);
		String actuelValue = elp.getEmpList().getText();
		Assert.assertEquals(expectedValue, actuelValue);
		Reporter.log("Employee name present in the list of employee names..", true);
		hrm.getEmployeeListLink().click();
		wutil.javascriptScrollBy(driver);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + ELN + "')]"));
		wutil.explicitwaitforelementToBeClickable(driver, ele);
		ele.click();
		wutil.javascriptScrollBy(driver);
		ListPage lp = new ListPage(driver);
		lp.getDeleteButton().click();
		lp.getYesbutton().click();
		Reporter.log("Employee Record deleted successfully", true);
		Thread.sleep(3000);
	}

}