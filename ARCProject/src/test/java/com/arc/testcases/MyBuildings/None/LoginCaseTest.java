package com.arc.testcases.MyBuildings.None;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class LoginCaseTest extends BaseClass {

	@Test
	public void loginCaseTest()throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("LoginTest-BNone", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();

		
		try {
			
			reuse.LoginWithBuildings(4, "My Buildings");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "LoginTest-BNone");
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
