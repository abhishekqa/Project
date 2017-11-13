package com.arc.testcases.MyBuildings.Other;


import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class WaterMeterCreateTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.Other.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.Other.ClickSearchedProgramTest.clickSearchedProgramTest","com.arc.testcases.MyBuildings.Other.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet", "waterSheet"})
	public void waterMeterCreate(int rowNum, String buildingSheet, String loginSheet, String waterSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("CreateWaterMeterTest-BOther", "Verifies if Water meter created and added successfully").assignCategory("CheckMeter");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseDI.CreateWaterWMeter("Water", "Test Water Meter","AddMeterWater", waterSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "CreateWaterMeterTest-BOther");
			throw e1;
		}
	}

}
