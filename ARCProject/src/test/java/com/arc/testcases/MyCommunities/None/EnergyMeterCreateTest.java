package com.arc.testcases.MyCommunities.None;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class EnergyMeterCreateTest extends BaseClass {
	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyCommunities.None.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.None.SearchProgramTest.searchProgram","com.arc.testcases.MyCommunities.None.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.None.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","communitySheet","energySheet"})
	public void energyMeterCreate(int rowNum, String loginSheet, String communitySheet, String energySheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("dd", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginWithCommunities(rowNum, "My Communities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseDI.CreateMeter("Energy", "Test Energy Meter","AddMeterEnergy", energySheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("energyMeterCreateTest-communities");
			throw e1;
		}
	}
}
