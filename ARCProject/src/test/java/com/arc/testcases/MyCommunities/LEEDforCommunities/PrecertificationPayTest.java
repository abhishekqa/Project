package com.arc.testcases.communities;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPreCertification;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class PrecertificationPayTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.communities.LoginCaseTest.loginCaseTest","com.arc.testcases.communities.SearchProgramTest.searchProgramTest","com.arc.testcases.communities.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.communities.PaymentbyCCTest.paymentbyCCTest","com.arc.testcases.communities.PrerequisitesAttemptTest.prerequisitesAttemptTest","com.arc.testcases.communities.VerifyRequirementsCompleteTest.verifyRequirementsCompleteTest" })
	public void precertificationPayTest() throws IOException {
		
		CommonMethod.ExtentReportConfig(driver);
		
		CommonMethod.test = CommonMethod.extent.startTest("PrecertificationPay Test-Communities", "Verifies if Precertifiction functionality is correct").assignCategory("CheckPrecertification");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsPreCertification reusePreCert = new ReusableMethodsPreCertification();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			
			reuse.LoginWithCommunities(2, "My Communities");
			reuseSearch.SearchProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_communities));
			reuseSearch.VerifySearchedProgram(driver, CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_communities));
			reusePrereq.ClickSubmitforReview(driver);
			reusePreCert.ClickProceedPrecertification(driver);
			reuseAddProject.PaymentbyCC(driver,"SearchsuccessMessage", "All Actions");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot(driver, "precertificationPayTest-communities");
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
