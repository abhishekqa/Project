package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class AddNewProjectTest extends BaseClass {
	
	@Test//(dependsOnMethods={"com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"loginSheet","buildingSheet"})
	public void addNewProjectTest(int rowNum, String loginSheet, String buildingSheet ) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectUSTest-BLEED", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		try {
			
			reuse.LoginWithBuildings(rowNum, "My Buildings", loginSheet);
			reuseAddProject.AddProjectLEEDUS(buildingSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError("<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectUSTest-BLEEd");
			throw e1;
		}
	}

	
}
