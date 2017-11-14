package com.arc.testcases.MyCities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AddNewProjectTest extends BaseClass {

	
	@Test
	//(dependsOnMethods = { "com.arc.testcases.cities.LoginCaseTest.loginCaseTest" })
	@Parameters({"rowNum" ,"loginSheet","citySheet"})
	public void addNewProject(int rowNum, String loginSheet, String citySheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Add New Project-Cities", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseAddProject.AddProjectCities(rowNum, citySheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectTest-city");
			throw e1;
		}
	}
}
