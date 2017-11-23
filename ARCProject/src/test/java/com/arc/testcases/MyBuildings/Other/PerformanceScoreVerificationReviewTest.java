package com.arc.testcases.MyBuildings.Other;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PerformanceScoreVerificationReviewTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.Other.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.Other.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet", "paymentSheet"})
	public void performanceScoreVerification(int rowNum, String buildingSheet, String loginSheet, String paymentSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("SubmitPerformanceScoreAllFunctionalityTest-BOther", "Verifies  ReviewPageTest successully ").assignCategory("SubmitForReview");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePerformanceReview= new ReusableMethodsReviewCertification();
		try {
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			//reuseSearch.VerifySearchedProgram( "1000137141");
			reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePerformanceReview.verifyPerformanceReviewSelection("Review");
			reusePerformanceReview.R_PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);
			reusePerformanceReview.ClickProceedPerformanceScore();
			reusePerformanceReview.verifySuccessfullySubmittedPayment();
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "submitPerformanceScoreAllFunctionalityTest-BOther");
			throw e1;
		}
	}
}
