package com.arc.testcases.MyBuildings.Parksmart;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;


public class BillingDateVerificationTest extends BaseClass {
	@Test (dependsOnMethods = { "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.Parksmart.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.Parksmart.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"parkingSheet" ,"loginSheet"})
	public void billingDateVerificationTest(int rowNum, String parkingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("BillingDateTest-Parking", "Verifies if Billing Date is correct").assignCategory("CheckBilling");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects",loginSheet);
			reuseSearch.SearchProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
		    reuseSearch.VerifySearchedProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
			reuseManage.verifyBillingDate();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("billingDateTest-Parking");
			throw e1;
		}
	}

}
