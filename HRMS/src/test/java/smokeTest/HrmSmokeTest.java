package smokeTest;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import inno.hrm.basetest.BaseClass1;
import inno.hrm.objectRepositoryUtility.HomePage;
import inno.hrm.objectRepositoryUtility.HrmPage;
@Listeners(inno.hrm.listenerutility.ListImpClass.class)
public class HrmSmokeTest extends BaseClass1{
@Test(groups = "SmokeTest")
public void createEmployeeTest() {
wutil.toimplicitWait(driver);
HomePage hp=new HomePage(driver);
hp.getHrmLink().click();
HrmPage hrm=new HrmPage(driver);
hrm.getEmployeeLink().click();
hrm.getNewEmployeeLink().click();
Reporter.log("Create New employee page is displayed successfully",true);
}

@Test(groups = "SmokeTest")
public void leaveRequestTest() {
	wutil.toimplicitWait(driver);
	HomePage hp=new HomePage(driver);
	hp.getHrmLink().click();
	HrmPage hrm=new HrmPage(driver);
	hrm.getLeaveNewLink().click();
	Reporter.log("Create New leave request page is displayed successfully",true);
}

@Test(groups = "SmokeTest")
public void CreateJobPositionTest() {
	wutil.toimplicitWait(driver);
	HomePage hp=new HomePage(driver);
	hp.getHrmLink().click();
	HrmPage hrm=new HrmPage(driver);
	hrm.getNewJobPositionsLink().click();
	Reporter.log("Create New Job Position page is displayed successfully",true);
}

}
