package com.arc.testcases.MyBuildings.LEED;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class CertificationReviewTest extends BaseClass {

	
	@Test
	//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest" })
	public void waterFileUploadTest() throws IOException {
		CommonMethod.ExtentReportConfig(driver);
		CommonMethod.test = CommonMethod.extent.startTest("PrecCertReviewTest", "Verifies  ReviewPageTest successully ").assignCategory("FileUpload");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePreCert= new ReusableMethodsReviewCertification();
		try {
					
			
			reuse.LoginToArc(4, "My Projects");
			reuseSearch.VerifySearchedProgram(driver, "1000136722");
		//	reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
		//	reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reusePreCert.verifyCertReviewSelection(driver,"Review");
			reusePreCert.R_PaymentbyCC(driver,"paymentsuccessvalidation","Congratulations!");
			reusePreCert.ClickProceedCertification(driver);
			reusePreCert.verifySuccessfullySubmittedPayment(driver);
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "WaterFileUploadTest-LEED");
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
