package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsBasescore;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class RenewableAllBaseScoreAttemptTest extends BaseClass {
	@Test//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet"})
	public void baseScoreAttemptTest(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("RenewableAllBaseScoreAttemptTest-LEED", "Making credits Ready for review in Basescore Credits").assignCategory("CheckBasescore");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsBasescore reuseBS = new ReusableMethodsBasescore();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			//reuseSearch.VerifySearchedProgram( "1000137133");
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseBS.BasescoreAttempt();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "renewableAllBaseScoreAttemptTest-BLEED");
			throw e1;
		}
	}

}