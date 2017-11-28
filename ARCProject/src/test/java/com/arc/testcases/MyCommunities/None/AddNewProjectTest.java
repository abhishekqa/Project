package com.arc.testcases.MyCommunities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AddNewProjectTest extends BaseClass {

	
	@Test
	//(dependsOnMethods = { "com.arc.testcases.MyCommunities.None.LoginCaseTest.loginCase" })
	@Parameters({"rowNum" ,"loginSheet","communitySheet"})
	public void addNewProject(int rowNum, String loginSheet, String communitySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Add New Project-Communities", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			
			reuse.LoginWithCommunities(rowNum, "My Communities", loginSheet);
			reuseAddProject.AddProjectCommunitiesNone(rowNum,communitySheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("addNewProjectTest-communities");
			throw e1;
		}
	}
}
