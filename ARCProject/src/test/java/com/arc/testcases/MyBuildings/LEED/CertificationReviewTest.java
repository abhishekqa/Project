package com.arc.testcases.MyBuildings.LEED;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
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
	@Parameters({"rowNum" ,"buildingSheet","paymentSheet","loginSheet"})
	public void waterFileUploadTest(int rowNum, String buildingSheet, String paymentSheet, String loginSheet) throws IOException {
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("PrecCertReviewTest", "Verifies  ReviewPageTest successully ").assignCategory("FileUpload");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsReviewCertification reusePreCert= new ReusableMethodsReviewCertification();
		try {
					
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
		    reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePreCert.verifyCertReviewSelection("Review");
			reusePreCert.R_PaymentbyCC("paymentsuccessvalidation","Congratulations!",paymentSheet, rowNum );
			reusePreCert.ClickProceedCertification();
			reusePreCert.verifySuccessfullySubmittedPayment();
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "WaterFileUploadTest-LEED");
			throw e1;
		}
	}

}