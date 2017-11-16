package com.arc.testcases.MyCommunities.None;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PerformanceReviewTest extends BaseClass {

	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"communitySheet", "paymentSheet", "loginSheet" })
	public void waterFileUploadTest(int rowNum, String communitySheet, String paymentSheet, String loginSheet) throws IOException {
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AllSearaioPrecCertReviewTest", "Verifies  ReviewPageTest successully ").assignCategory("SubmitForReview");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePreCert= new ReusableMethodsReviewCertification();
		try {
					
			
			reuse.LoginToArc(rowNum, "My Projects",loginSheet);
			//reuseSearch.VerifySearchedProgram( "1000137567");
			reuseSearch.SearchProgram( data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(communitySheet, "ProjectName", rowNum));
			reusePreCert.verifyPerformanceReviewSelection("Review");
			reusePreCert.R_PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);
			reusePreCert.ClickProceedPerformanceScore();
			reusePreCert.verifySuccessfullySubmittedPayment();
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "allSearaioPrecCertReviewTest");
			throw e1;
		}
	}
}
