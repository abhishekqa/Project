package com.arc.testcases.MyCommunities.None;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PreCertReviewTest extends BaseClass {

	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyCommunities.None.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.None.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.None.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"communitySheet", "paymentSheet", "loginSheet" })
	public void precertificationReview(int rowNum, String communitySheet, String paymentSheet, String loginSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AllSearaioPrecCertReviewTestCommNone", "Verifies  ReviewPageTest successully ").assignCategory("SubmitForReview");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePreCert= new ReusableMethodsReviewCertification();
		try {
					
			
			reuse.LoginToArc(rowNum, "My Projects",loginSheet);
			reuseSearch.SearchProgram( data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(communitySheet, "ProjectName", rowNum));
			reusePreCert.verifyPreCertReviewSelection("Review");
			reusePreCert.R_PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);
			reusePreCert.ClickProceedPrecertification();
			reusePreCert.verifySuccessfullySubmittedPayment();
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot( "allSearaioPrecCertReviewTestCommNone");
			throw e1;
		}
	}
}
