package com.arc.testcases.MyCities.Other;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PrecertificationPayTest extends BaseClass {


	@Test//(dependsOnMethods = { "com.arc.testcases.MyCities.Other.LoginCaseTest.loginCase","com.arc.testcases.MyCities.Other.SearchProgramTest.searchProgram","com.arc.testcases.MyCities.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCities.Other.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","citySheet","paymentSheet"})
	public void precertificationPay(int rowNum, String loginSheet, String citySheet, String paymentSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("PrecertificationPay Test-Cities", "Verifies if Precertifiction functionality is correct").assignCategory("CheckPrecertification");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsReviewCertification reusePreCert = new ReusableMethodsReviewCertification();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reusePrereq.ClickSubmitforReview();
			reusePreCert.ClickProceedPrecertification();
			reuseAddProject.PaymentbyCC("SearchsuccessMessage", "All Actions",paymentSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("precertificationPayTest-city");
			throw e1;
		}
	}
}
