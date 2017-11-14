package com.arc.testcases.MyBuildings.LEEDfortransit;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
public class UnderGroundAddNewProjectTest extends BaseClass {
	
	@Test
	//(dependsOnMethods={"com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"buildingSheet","loginSheet"})
	public void addNewProject(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectTest-TransitU", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			reuse.LoginWithtransit(rowNum, "My Transit", loginSheet);
			reuseAddProject.AddUndergroundProjectLEEDfortransit(rowNum, buildingSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError("<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectTest-TransitU");
			throw e1;
		}
	}
}
