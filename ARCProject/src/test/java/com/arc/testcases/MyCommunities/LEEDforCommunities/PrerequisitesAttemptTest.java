package com.arc.testcases.MyCommunities.LEEDforCommunities;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PrerequisitesAttemptTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyCommunities.LEEDforCommunities.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.LEEDforCommunities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.LEEDforCommunities.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","communitySheet"})
	public void prerequisitesAttempt(int rowNum, String loginSheet, String communitySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("PrerequisitesAttempt Test-CommunitiesLEED", "Verifies if Prerequisites functionality is working fine").assignCategory("CheckPrerequisites");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginWithCommunities(rowNum, "My Communities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reusePrereq.PrereqAttempt("commitToSharingData",5);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("prerequisitesAttemptTest-communitiesLEED");
			throw e1;
		}
	}
}
