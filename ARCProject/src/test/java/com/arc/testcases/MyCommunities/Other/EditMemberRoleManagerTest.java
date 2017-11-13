package com.arc.testcases.communities;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class EditMemberRoleManagerTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.communities.LoginCaseTest.loginCaseTest","com.arc.testcases.communities.SearchProgramTest.searchProgramTest","com.arc.testcases.communities.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.communities.PaymentbyCCTest.paymentbyCCTest","com.arc.testcases.communities.AddTeamMemberTest.addTeamMemberTest" })
	public void editMemberRoleManagerTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("EditTeamMemberRole Test-Communities", "Verifies if edit team member functionality is working fine").assignCategory("CheckTeam");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginWithCommunities(2, "My Communities");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_communities));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_communities));
			reuseManage.EditTeamMemberRole(driver, "ARC Project Team Manager");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "editMemberRoleManagerTest-communities");
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
