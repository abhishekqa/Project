package com.arc.testcases.MyBuildings.LEED;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class  ETotalAnalyticsTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"buildingSheet" ,"loginSheet"})
	public void energyTotalAnalyticsTest(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("AEnergyCalculatioonTest-BLEED", "Verifies Total Analytics Tool Tip successfully").assignCategory("CheckAnalytics");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
		 //   reuseSearch.VerifySearchedProgram( "1000137787");
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
		    reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseDI.verifyEDailiyMTCO2e("Atotal");		

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "aenergyCalculatioonTest-BLEED");
			throw e1;
		}
	}
}
