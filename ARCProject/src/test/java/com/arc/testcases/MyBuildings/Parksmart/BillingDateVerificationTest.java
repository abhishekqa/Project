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
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.Parksmart.SearchProgramTest.searchProgram","com.arc.testcases.MyBuildings.Parksmart.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.Parksmart.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","buildingSheet"})
	public void billingDateVerification(int rowNum, String loginSheet, String buildingSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Billing DateTest-Parking", "Verifies if Billing Date is correct").assignCategory("CheckBilling");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(rowNum,"My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseManage.verifyBillingDate();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("billingDateVerificationTest-Parking");
			throw e1;
		}
	}
}
