package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class BillingRegistrationAmountVerificationTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"buildingSheet","paymentSheet" ,"loginSheet"})
	public void billingRegistrationAmountVerificationTest(int rowNum, String buildingSheet, String paymentSheet, String loginSheet ) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("ProjRegAmountTest-BLEED", "Verifies if registration amount is displayed correct in billing page").assignCategory("CheckBilling");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			//reuseSearch.VerifySearchedProgram(, "1000136044");
			reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseManage.verifyRegAmount( paymentSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "projRegAmountTest-BLEED");
			throw e1;
		}
	}

}
