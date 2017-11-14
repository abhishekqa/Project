package com.arc.testcases.MyBuildings.LEEDfortransit;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class VerifyCertificationStatusTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet"})
	public void verifyCertificationStatus(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("CertificationStatusTest-LEED", "Verifies if Certification status is displayed correctly").assignCategory("CheckCertification");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseManage.CertificationStatus();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("verifyCertificationStatusTest-LEED");
			throw e1;
		}
	}
}
