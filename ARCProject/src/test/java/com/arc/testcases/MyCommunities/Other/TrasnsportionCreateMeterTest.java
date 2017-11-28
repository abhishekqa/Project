package com.arc.testcases.MyCommunities.Other;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class TrasnsportionCreateMeterTest extends BaseClass {
	
	@Test //(dependsOnMethods = { "com.arc.testcases.MyCommunities.Other.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.Other.SearchProgramTest.searchProgram","com.arc.testcases.MyCommunities.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.Other.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet", "communitySheet","cdataInputSheet"})
	public void transprotionMeterCreate(int rowNum, String loginSheet, String communitySheet, String cdataInputSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("CreateTransportationMeterTest-ComOther", "Verifies if Create Transportation Meter functionality is working fine").assignCategory("CreateMeter");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseDI.CreateTransportMeterCities("Transportation", cdataInputSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("createTransportationMeterTest-ComOther");
			throw e1;
		}
	}
}
