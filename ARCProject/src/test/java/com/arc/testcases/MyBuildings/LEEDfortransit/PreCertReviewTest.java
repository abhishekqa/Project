package com.arc.testcases.MyBuildings.LEEDfortransit;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PreCertReviewTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEEDfortransit.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEEDfortransit.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet","paymentSheet"})
	public void PreCertReview(int rowNum, String buildingSheet, String loginSheet, String paymentSheet) throws IOException {
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AllSearaioPrecCertReviewTest-TransitU", "Verifies  ReviewPageTest successully ").assignCategory("SubmitForReview");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePreCert= new ReusableMethodsReviewCertification();
		try {
					
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			//reuseSearch.VerifySearchedProgram( "1000137567");
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePreCert.verifyPreCertReviewSelection("Review");
			reusePreCert.R_PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);
			reusePreCert.ClickProceedPrecertification();
			reusePreCert.verifySuccessfullySubmittedPayment();
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "allSearaioPrecCertReviewTest-TransitU");
			throw e1;
		}
	}
}
