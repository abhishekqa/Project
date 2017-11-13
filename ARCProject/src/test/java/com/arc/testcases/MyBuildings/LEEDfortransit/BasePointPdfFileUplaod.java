package com.arc.testcases.MyBuildings.LEEDfortransit;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsBasescore;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class BasePointPdfFileUplaod extends BaseClass {
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEEDfortransit.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEEDfortransit.PaymentbyCCTest.paymentbyCCTest" })
	public void baseScoreAttemptTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("BaseScorePdfUploadTest-TransitU", "Making credits Ready for review in Basescore Credits").assignCategory("CheckBasescore");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsBasescore reuseBS = new ReusableMethodsBasescore();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(4, "My Projects");
		
			//reuseSearch.VerifySearchedProgram(driver, "1000136533");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reuseBS.TBasePointFileUplaod(driver);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "baseScorePdfUploadTest-TransitU");
			throw e1;
		}
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		
		 if (result.getStatus() == ITestResult.FAILURE) {
			 CommonMethod.test.log(LogStatus.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	        CommonMethod.test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	        } else {
	        CommonMethod.test.log(LogStatus.PASS, "Test passed");
	        }

  
		CommonMethod.extent.endTest(CommonMethod.test);
		CommonMethod.extent.flush();
		
		
		
	}

}
