package com.arc.testcases.cities;



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

public class ProjectFieldVerificationTest extends BaseClass {


	@Test(dependsOnMethods = { "com.arc.testcases.cities.LoginCaseTest.loginCaseTest","com.arc.testcases.cities.SearchProgramTest.searchProgramTest","com.arc.testcases.cities.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.cities.PaymentbyCCTest.paymentbyCCTest" })
	public void projectFieldVerificationTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("ProjectField Test-Buildings", "Verifies if Project Field is displayed correct").assignCategory("CheckProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginWithCities(2, "My Cities");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_cities));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_cities));
			reuseManage.projectFieldDisplayed(driver);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "projectFieldVerificationTest-city");
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
