package com.arc.testcases.MyBuildings.LEED;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class InternationalLanguagesSpecaialCharacterMeterCreateTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"buildingSheet", "loginSheet" })
	public void energyMeterCreateTest(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("CreateILSepcharMeterTest-BLEED", "Verifies if Energy meter created and added successfully").assignCategory("CheckMeter");
        ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
		//	reuseSearch.VerifySearchedProgram( "1000137567");
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseDI.CreateMeterInternationalLanguage("Energy", "Energy Meter Test","AddMeterEnergy");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "createILSepcharMeterTest-BLEED");
			throw e1;
		}
	}

}
