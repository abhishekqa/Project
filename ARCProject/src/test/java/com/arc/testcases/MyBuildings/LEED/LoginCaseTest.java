package com.arc.testcases.MyBuildings.LEED;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class LoginCaseTest extends BaseClass {

	@Test
	@Parameters({"rowNum" ,"loginSheet"})
	public void loginCaseTest(int col, String loginSheet  )throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("LoginTest-BLEED", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();

		
		try {
			reuse.LoginWithBuildings(col, "My Buildings", loginSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "loginTest-BLEED");
			throw e1;
		}
	}
}
