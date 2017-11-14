package com.arc.testcases.MyCities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PaymentbyCCTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.cities.LoginCaseTest.loginCase","com.arc.testcases.cities.SearchProgramTest.searchProgram","com.arc.testcases.cities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.cities.AddNewProjectTest.addNewProject" })
	@Parameters({"rowNum" ,"loginSheet","citySheet","paymentSheet"})
	public void paymentbyCC(int rowNum, String loginSheet, String citySheet, String paymentSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Payment By Creditcard-Cities", "Verifies if Payment done through creditcard is successful").assignCategory("CheckPayment");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		ReusableMethodsSearch reusePublicSearch = new ReusableMethodsSearch();
		try {
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reusePublicSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reusePublicSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseAddProject.PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("paymentbyCCTest-city");
			throw e1;
		}
	}
}
