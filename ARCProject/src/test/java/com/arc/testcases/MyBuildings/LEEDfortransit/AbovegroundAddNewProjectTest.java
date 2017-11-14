package com.arc.testcases.MyBuildings.LEEDfortransit;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
public class AbovegroundAddNewProjectTest extends BaseClass {
	
	@Test(dependsOnMethods={"com.arc.testcases.LEEDfortransit.LoginCaseTest.loginCase"})
	@Parameters({"rowNum" ,"loginSheet","buildingSheet"})
	public void addNewProject(int rowNum, String loginSheet, String buildingSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectTest-TransitA", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			reuse.LoginWithtransit(rowNum, "My Transit", loginSheet);
			reuseAddProject.AddAboveProjectLEEDfortransit(rowNum, buildingSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "addNewProjectTest-TransitA");
			throw e1;
		}
	}
}
