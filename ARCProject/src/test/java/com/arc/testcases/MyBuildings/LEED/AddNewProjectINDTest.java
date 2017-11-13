package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AddNewProjectINDTest extends BaseClass {
	
	@Test(dependsOnMethods={"com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"buildingSheet","waterSheet" })
	public void addNewProjectTest(int rowNum, String sheetName) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectINDTest-LEED", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		try {
			
			reuse.LoginWithBuildings(rowNum, "My Buildings",sheetName);
			reuseAddProject.AddProjectLEEDIND();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectUSTest-LEED");
			throw e1;
		}
	}

	

}
