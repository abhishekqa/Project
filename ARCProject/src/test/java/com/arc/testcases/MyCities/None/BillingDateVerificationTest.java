package com.arc.testcases.MyCities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class BillingDateVerificationTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.cities.LoginCaseTest.loginCase","com.arc.testcases.cities.SearchProgramTest.searchProgram","com.arc.testcases.cities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.cities.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","citySheet"})
	public void billingDateVerificationTest(int rowNum, String loginSheet, String citySheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("BillingDate Test-Cities", "Verifies if Billing Date is correct").assignCategory("CheckBilling");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseManage.verifyBillingDate();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "billingDateVerificationTest-city");
			throw e1;
		}
	}
}
