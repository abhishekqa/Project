package com.arc.testcases.MyBuildings.Other;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AddNewProjectTest extends BaseClass {
	
	@Test//(dependsOnMethods={"com.arc.testcases.MyBuildings.Other.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"loginSheet","buildingSheet"})
	public void addNewProject(int rowNum,String loginSheet,  String buildingSheet) throws IOException {
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectUSTest-BOther", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
        ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			reuse.LoginWithBuildings(rowNum,"My Buildings",loginSheet);
			reuseAddProject.AddProjectOtherUS(rowNum, buildingSheet);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "addNewProjectUSTest-BOther");
			throw e1;
		}
	}
}
