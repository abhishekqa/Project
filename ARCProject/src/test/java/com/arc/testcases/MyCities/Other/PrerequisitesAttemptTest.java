package com.arc.testcases.cities;



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

public class PrerequisitesAttemptTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.cities.LoginCaseTest.loginCaseTest","com.arc.testcases.cities.SearchProgramTest.searchProgramTest","com.arc.testcases.cities.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.cities.PaymentbyCCTest.paymentbyCCTest" })
	public void prerequisitesAttemptTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("PrerequisitesAttempt Test-Cities", "Verifies if Prerequisites functionality is working fine").assignCategory("CheckPrerequisites");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginWithCities(2, "My Cities");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_cities));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_cities));
			reusePrereq.PrereqAttempt(driver,"commitToSharingData",5);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "prerequisitesAttemptTest-city");
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
