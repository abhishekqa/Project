package com.arc.testcases.MyBuildings.LEEDfortransit;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class EnergyMeterCreateTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEEDfortransit.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEEDfortransit.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet","energySheet"})
	public void energyMeterCreate(int rowNum, String buildingSheet, String loginSheet, String energySheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("CreateEnergyMeterTest-TransitUS", "Verifies if Energy meter created and added successfully").assignCategory("CreateMeter");
        ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
		//	reuseSearch.VerifySearchedProgram( "1000137567");
			reuseSearch.SearchProgram(  data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram(  data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseDI.CreateMeter("Energy", "AddEnergyMeterTest","AddMeterEnergy", energySheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "energyMeterCreateTest-TransitUS");
			throw e1;
		}
	}
}
