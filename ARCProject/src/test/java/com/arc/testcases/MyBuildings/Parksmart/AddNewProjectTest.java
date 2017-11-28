package com.arc.testcases.MyBuildings.Parksmart;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AddNewProjectTest extends BaseClass {
	
	@Test(dependsOnMethods={"com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"loginSheet","parkingSheet"})
	public void addNewProjectTest(int rowNum, String loginSheet, String parkingSheet ) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectUSTest-Parking", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {	
			reuse.LoginWithparking(rowNum, "My Parking", loginSheet);
			reuseAddProject.AddProjectParksmartUS(parkingSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError("<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectUSTest-Parking");
			throw e1;
		}
	}

	
}
