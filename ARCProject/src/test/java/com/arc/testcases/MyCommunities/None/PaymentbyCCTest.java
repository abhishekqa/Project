package com.arc.testcases.communities;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class PaymentbyCCTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.communities.LoginCaseTest.loginCaseTest","com.arc.testcases.communities.SearchProgramTest.searchProgramTest","com.arc.testcases.communities.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.communities.AddNewProjectTest.addNewProjectTest" })
	public void paymentbyCCTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("Payment By Creditcard-Communities", "Verifies if Payment done through creditcard is successful").assignCategory("CheckPayment");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		ReusableMethodsSearch reusePublicSearch = new ReusableMethodsSearch();
		try {
			
			
			reuse.LoginWithCommunities(2, "My Communities");
			reusePublicSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_communities));
			reusePublicSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_communities));
			reuseAddProject.PaymentbyCC(driver,"paymentsuccessvalidation","Congratulations!");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "paymentbyCCTest-communities");
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
