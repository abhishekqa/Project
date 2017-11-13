package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class TeamMemberCreditAssertionTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.Login.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.PublicSearch.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.LEED.PublicSearch.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.AddProject.PaymentbyCCTest.paymentbyCCTest" })
	public void prerequisitesAttemptTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("PrerequisitesAttemptTest-LEED", "Verifies if Prerequisites functionality is working fine").assignCategory("CheckPrerequisites","ARCPPS-465").assignCategory("ARCPPS");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(4, "My Projects");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reusePrereq.teamMemberAssignCredit(driver,"sitemanagement",9);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "prerequisitesAttemptTest-LEED");
			throw e1;
		}
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		
		 if (result.getStatus() == ITestResult.FAILURE) {
			 CommonMethod.test.log(LogStatus.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	        CommonMethod.test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	        } else {
	        CommonMethod.test.log(LogStatus.PASS, "Test passed");
	        }

  
		CommonMethod.extent.endTest(CommonMethod.test);
		CommonMethod.extent.flush();
		
		
		
	}

}
