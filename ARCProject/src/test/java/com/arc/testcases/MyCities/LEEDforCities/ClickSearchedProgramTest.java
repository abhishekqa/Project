package com.arc.testcases.MyCities.LEEDforCities;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class ClickSearchedProgramTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.arc.testcases.MyCities.LEEDforCities.LoginCaseTest.loginCase"})
	@Parameters({"rowNum" ,"loginSheet", "citySheet"})
	public void clickSearchedProgram(int rowNum, String loginSheet, String citySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("SearchNavigation Test-MyCities.LEEDforCities", "Verifies if Search functionality is working fine").assignCategory("CheckSearch");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();

		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("clickSearchedProgramTest-cityLeed");
			throw e1;
		}
	}
}
