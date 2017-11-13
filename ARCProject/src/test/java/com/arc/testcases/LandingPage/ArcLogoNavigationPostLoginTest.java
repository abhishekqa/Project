package com.arc.testcases.LandingPage;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLandingPage;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class ArcLogoNavigationPostLoginTest extends BaseClass {

	@Test
	@Parameters({"rowNum" , "loginSheet" })
	public void arcLogoNavigationTest(int rowNum, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("ArcLogoNavigationPostLoginTest", "Verifies if logo navigation functionality is working fine").assignCategory("CheckNavigation");
		ReusableMethodsLandingPage reuse = new ReusableMethodsLandingPage();
		ReusableMethodsLogin login = new ReusableMethodsLogin();
		
		try {
			
			login.LoginToArc(rowNum,"My Projects", loginSheet);
			reuse.clickArcLogoPostLogin();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("arcLogoNavigationTest-Arc");
			throw e1;
		}
	}
}
