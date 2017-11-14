package com.arc.testcases.MyBuildings.LEEDfortransit;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class BasePointActivityTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet"})
	public void energyMeterCreate(int rowNum, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("CreateEnergyMeterTest-BLEED", "Verifies if Energy meter created and added successfully").assignCategory("CheckMeter");
        ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		try {
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.VerifySearchedProgram( "1000137577");
			//reuseSearch.SearchProgram( CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			//reuseSearch.VerifySearchedProgram( CommonMethod.filereadID(CommonMethod.ArcProjectIDUrl_building));
			reuseDI.VerifyDataInputActivity("Energy");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "energyMeterCreateTest-BLEED");
			throw e1;
		}
	}
}
