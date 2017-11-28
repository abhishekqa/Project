package com.arc.testcases.MyBuildings.Parksmart;



import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class SearchProgramTest extends BaseClass {

	@Test //(dependsOnMethods = { "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"loginSheet","parkingSheet"})
	public void searchProgramTest(int rowNum, String loginSheet ,String parkingSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("SearchProgramTest-parking", "Verifies if Search functionality is working fine").assignCategory("CheckSearch");
        
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();

		
		try {
			
			reuse.LoginToArc(rowNum,"My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(parkingSheet, "ProjectName", rowNum));

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "searchProgramTest-parking");
			throw e1;
		}
	}
}
