package com.arc.testcases.MyCommunities.Other;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class WasteMeterEditReadingTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyCommunities.Other.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.Other.SearchProgramTest.searchProgram","com.arc.testcases.MyCommunities.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.Other.sPaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","communitySheet"})
	public void wasteMeterEditReading(int rowNum, String loginSheet, String communitySheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Waste Meter Edit Test", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {

			reuse.LoginWithCommunities(rowNum, "My Communities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseDI.EditWasteMeter( "Waste");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("wasteMeterEditReadingTest-communities");
			throw e1;
		}
	}
}
