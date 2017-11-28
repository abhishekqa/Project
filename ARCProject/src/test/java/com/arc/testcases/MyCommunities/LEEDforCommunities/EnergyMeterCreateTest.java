package com.arc.testcases.MyCommunities.LEEDforCommunities;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class EnergyMeterCreateTest extends BaseClass {
	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyCommunities.LEEDforCommunities.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.LEEDforCommunities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.LEEDforCommunities.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet", "communitySheet","cdataInputSheet"})
	public void energyMeterCreate(int rowNum, String loginSheet, String communitySheet, String cdataInputSheet) throws IOException {
	
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("EnergyMeterCreateTest-ComLEED", "Verifies if added meter redaing is working fine").assignCategory("CreateMeter");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseDI.CreateEnergyMeterCities("Energy", cdataInputSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("energyMeterCreateTest-ComLEED");
			throw e1;
		}
	}
}
