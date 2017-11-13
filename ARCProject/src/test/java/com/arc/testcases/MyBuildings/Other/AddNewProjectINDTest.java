package com.arc.testcases.MyBuildings.Other;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class AddNewProjectINDTest extends BaseClass {
	
	@Test(dependsOnMethods={"com.arc.testcases.MyBuildings.Other.LoginCaseTest.loginCaseTest"})
	public void addNewProjectTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectINDTest-BOther", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		try {
			
			reuse.LoginWithBuildings(4, "My Buildings");
			reuseAddProject.AddProjectOtherIND(driver);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "addNewProjectUSTest-BOther");
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
