package com.arc.testcases.MyCities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class BillingRegistrationAmountVerificationTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.cities.LoginCaseTest.loginCase","com.arc.testcases.cities.SearchProgramTest.searchProgram","com.arc.testcases.cities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.cities.PaymentbyCCTest.paymentbyCC","com.arc.testcases.cities.PrecertificationPayTest.precertificationPay" })
	@Parameters({"rowNum" ,"loginSheet","citySheet","paymentSheet"})
	public void billingRegistrationAmountVerificationTest(int rowNum, String loginSheet, String citySheet, String paymentSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("RegistrationAmount Test-Cities", "Verifies if registration amount is displayed correct in billing page").assignCategory("CheckBilling");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseManage.verifyRegAmount(paymentSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("billingRegistrationAmountVerificationTest-city");
			throw e1;
		}
	}
}
