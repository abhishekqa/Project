package com.arc.testcases.MyBuildings.None;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PaymentbyCheckTest extends BaseClass {

	
	@Test
	//(dependsOnMethods = { "com.arc.testcases.MyBuildings.None.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.None.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.None.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.None.AddNewProjectTest.addNewProjectTest" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet", "paymentSheet"})
	public void paymentbyCCTest(int rowNum, String buildingSheet, String loginSheet, String paymentSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
	    CommonMethod.test = CommonMethod.extent.startTest("PaymentByCheckTest-BNone", "Verifies if Payment done through creditcard is successful").assignCategory("CheckPayment");
        ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		ReusableMethodsSearch reusePublicSearch = new ReusableMethodsSearch();
		try {
			reuse.LoginToArc(rowNum,"My Projects",loginSheet);
			reusePublicSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePublicSearch.VerifySearchedProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseAddProject.PaymentbyCheck("paymentsuccessvalidation","Congratulations!", paymentSheet,rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("paymentbyCheckTest-BNone");
			throw e1;
		}
	}
}
