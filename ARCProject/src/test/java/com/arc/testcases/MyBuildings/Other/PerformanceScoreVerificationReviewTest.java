package com.arc.testcases.MyBuildings.Other;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class PerformanceScoreVerificationReviewTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.Other.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.Other.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.Other.PaymentbyCCTest.paymentbyCCTest" })
	public void waterFileUploadTest() throws IOException {
		CommonMethod.ExtentReportConfig(driver);
		CommonMethod.test = CommonMethod.extent.startTest("SubmitPerformanceScoreAllFunctionalityTest-BOther", "Verifies  ReviewPageTest successully ").assignCategory("SubmitForReview");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePerformanceReview= new ReusableMethodsReviewCertification();
		try {
					
			
			reuse.LoginToArc(4, "My Projects");
			//reuseSearch.VerifySearchedProgram(driver, "1000137141");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reusePerformanceReview.verifyPerformanceReviewSelection(driver,"Review");
			reusePerformanceReview.R_PaymentbyCC(driver,"paymentsuccessvalidation","Congratulations!");
			reusePerformanceReview.ClickProceedPerformanceScore(driver);
			reusePerformanceReview.verifySuccessfullySubmittedPayment(driver);
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "submitPerformanceScoreAllFunctionalityTest-BOther");
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