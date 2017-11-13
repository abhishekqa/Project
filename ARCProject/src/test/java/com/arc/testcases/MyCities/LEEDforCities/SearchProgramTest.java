package com.arc.testcases.MyCities.LEEDforCities;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class SearchProgramTest extends BaseClass {

	@Test(dependsOnMethods = { "com.arc.testcases.MyCities.LEEDforCities.LoginCaseTest.loginCaseTest"})
	public void searchProgramTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("SearchProgram Test-MyCities.LEEDforCities", "Verifies if Search functionality is working fine").assignCategory("CheckSearch");
        
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();

		
		try {
			
			reuse.LoginToArc(4, "My Projects");
			reuseSearch.SearchProgram(driver, "1000127170");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "searchProgramTest-city");
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
