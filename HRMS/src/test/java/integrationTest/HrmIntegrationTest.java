package integrationTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import inno.hrm.basetest.BaseClass1;
import inno.hrm.objectRepositoryUtility.EmpListPage;
import inno.hrm.objectRepositoryUtility.HomePage;
import inno.hrm.objectRepositoryUtility.HrmPage;
import inno.hrm.objectRepositoryUtility.ListOfJobPositionPage;
import inno.hrm.objectRepositoryUtility.LoginPage;
import inno.hrm.objectRepositoryUtility.NewEmployeePage;
import inno.hrm.objectRepositoryUtility.NewJobPositionsPage;
import inno.hrm.objectRepositoryUtility.NewLeavePage;

public class  HrmIntegrationTest extends BaseClass1{
@Test(groups = "RegressionTest")
public void listOfEmployee() throws Throwable{
	wutil.toimplicitWait(driver);
	HomePage hp=new HomePage(driver);
	hp.getHrmLink().click();
    HrmPage hrm=new HrmPage(driver);
    hrm.getNewEmployeeLink().click();
    NewEmployeePage nep=new NewEmployeePage(driver);
    int rno = jutil.toGenerateRandomNumber();
    
    String EFN = eutil.getDataFromExcel("Employee", 4, 2);
    String ELN = eutil.getDataFromExcel("Employee", 4, 3);
    String EMAIL = eutil.getDataFromExcel("Employee", 4, 4);
    String EMNO = eutil.getDataFromExcel("Employee", 4, 5);
    String EDOB = eutil.getDataFromExcel("Employee", 4, 6);
    String EXPECDA = eutil.getDataFromExcel("Employee", 4, 7);
    
   
    nep.getEmpLastNameTF().sendKeys(EFN);
    nep.getEmpFirstNameTF().sendKeys(ELN+rno);
    nep.getEmpGenderDD().click();
    nep.getEmpSelectGender().click();
    nep.getEmpUserDD().click();
    nep.getSelectSuperAdmin().click();
    nep.getEmpExpenseDD().click();
    nep.getSelectSuperAdmin().click();
    nep.getEmpHolidayDD().click();
    nep.getSelectSuperAdmin().click();
    nep.getEmpPhoneNumberTF().sendKeys(EMNO);
    nep.getEmpEmailTF().sendKeys(EMAIL);
    nep.getEmpDOBTF().sendKeys(EDOB);
    nep.getEmpCreateUserBtn().click();
    Reporter.log("New employee created successfully",true);
    hrm.getEmployeeListLink().click();
	String expectedValue=EXPECDA;
	EmpListPage elp=new EmpListPage(driver);
	String actuelValue =elp.getEmpList().getText();
	Assert.assertEquals(expectedValue, actuelValue);
	Reporter.log("Employee name present in the list of employee names..",true);
	
}

@Test(groups = "RegressionTest")
public void listOfJobPosition() throws Throwable {
	 String QA = eutil.getDataFromExcel("Job", 1, 2);
	 String QTY = eutil.getDataFromExcel("Job", 1, 3);
	 String REMAIL = eutil.getDataFromExcel("Job", 1, 4);
	 String DATE = eutil.getDataFromExcel("Job", 1, 5);
	 String SAL = eutil.getDataFromExcel("Job", 1, 6);
	 String DESC = eutil.getDataFromExcel("Job", 1, 7);   
	    
	HomePage hp=new HomePage(driver);
	hp.getHrmLink().click();
	HrmPage hrm=new HrmPage(driver);
	hrm.getNewJobPositionsLink().click();
	NewJobPositionsPage njp=new NewJobPositionsPage(driver);
	njp.getLabelTF().sendKeys(QA);
	njp.getLabelQuantityTF().clear();
	njp.getLabelQuantityTF().sendKeys(QTY);
	njp.getRecruiterMailTF().sendKeys(REMAIL);
	njp.getDatePlannedTF().sendKeys(DATE);
	njp.getSalaryTF().sendKeys(SAL);
	njp.getDescriptionTF().sendKeys(DESC);
	njp.getJobCreateBtn().click();
	Reporter.log("Job position created successfully",true);
	hrm.getListOfJobPositionsLink().click();
	String expectedValue=QA;
	ListOfJobPositionPage lojp=new ListOfJobPositionPage(driver);
	String actualValue =lojp.getListOfJobs().getText();
	Assert.assertEquals(expectedValue, actualValue);
	Reporter.log("Created job position is present in list of job position viewed successfully..",true);
}

@Test(groups = "RegressionTest")
public void employeeApplyLeave() throws Throwable {
	String ELN = eutil.getDataFromExcel("Employee", 4, 2);
	String EFN = eutil.getDataFromExcel("Employee", 4, 3)+jutil.toGenerateRandomNumber();
	String PNO = eutil.getDataFromExcel("Employee", 4, 5);
	String EUN = eutil.getDataFromExcel("Employee", 4, 8);
	String EPWD = eutil.getDataFromExcel("Employee", 4, 9);
	String SDATE = eutil.getDataFromExcel("Leave", 1, 3);
	String EDATE = eutil.getDataFromExcel("Leave", 1, 4);
	String DESC = eutil.getDataFromExcel("Leave", 1, 5);
	
	wutil.toimplicitWait(driver);
	HomePage hp=new HomePage(driver);
	hp.getHrmLink().click();
    HrmPage hrm=new HrmPage(driver);
    hrm.getNewEmployeeLink().click();
    NewEmployeePage nep=new NewEmployeePage(driver);
    //int rno = jutil.toGenerateRandomNumber();
    nep.getEmpLastNameTF().sendKeys(ELN);
    nep.getEmpFirstNameTF().sendKeys(EFN);
    nep.getEmpGenderDD().click();
    nep.getEmpSelectGender().click();
    nep.getEmpUserDD().click();
    nep.getSelectSuperAdmin().click();
    nep.getEmpExpenseDD().click();
    nep.getSelectSuperAdmin().click();
    nep.getEmpHolidayDD().click();
    nep.getSelectSuperAdmin().click();
    nep.getEmpPhoneNumberTF().sendKeys(PNO);
    nep.getEmpDOBTF().sendKeys(eutil.getDataFromExcel("Employee", 4, 6));
    nep.getEmpCreateUserBtn().click();
    nep.getCloseIcon().click();
    Reporter.log("Employee created successfully",true);
    hp.getLogoutDD().click();
    hp.getLogoutBtn().click();
    LoginPage lp=new LoginPage(driver);
    lp.getAusernameTF().sendKeys(EUN);
    lp.getApasswordTF().sendKeys(EPWD);
    lp.getLoginBtn().click();
    hp.getHrmLink().click();
    hrm.getLeaveNewLink().click();
    NewLeavePage nlp=new NewLeavePage(driver);
    nlp.getLeaveDD().click();
    nlp.getSelectSickLeave().click();
    nlp.getStartLeaveDateTF().sendKeys(SDATE);
    nlp.getEndLeaveDateTF().sendKeys(EDATE);
    nlp.getValidatorDD().click();
    nlp.getSelectSuperAdmin().click();
    nlp.getDescriptionTF().sendKeys(DESC);
    nlp.getCreateLeaveBtn().click();
    nlp.getCloseBtn().click();
    Reporter.log("Employee leave applied successfully",true);
}
}