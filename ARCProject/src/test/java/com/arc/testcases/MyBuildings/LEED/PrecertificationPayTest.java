package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class PrecertificationPayTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest","com.arc.testcases.MyBuildings.LEED.PrerequisitesAttemptTest.prerequisitesAttemptTest","com.arc.testcases.MyBuildings.LEED.VerifyRequirementsCompleteTest.verifyRequirementsCompleteTest" })
	@Parameters({"rowNum" ,"buildingSheet","paymentSheet","loginSheet"})
	public void precertificationPayTest(int rowNum, String buildingSheet, String paymentSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("PrecertificationPayTest-LEED", "Verifies if Precertifiction functionality is correct").assignCategory("CheckPrecertification");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsReviewCertification reusePreCert = new ReusableMethodsReviewCertification();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			reuse.LoginToArc(rowNum, "My Projects",loginSheet);
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePrereq.ClickSubmitforReview();
			reusePreCert.ClickProceedPrecertification();
			reuseAddProject.PaymentbyCC("SearchsuccessMessage","All Actions", paymentSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "precertificationPayTest-LEED");
			throw e1;
		}
	}
}
