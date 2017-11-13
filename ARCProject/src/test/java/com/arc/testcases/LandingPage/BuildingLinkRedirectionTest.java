package com.arc.testcases.LandingPage;
import java.io.IOException;

import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLandingPage;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class BuildingLinkRedirectionTest extends BaseClass {

	@Test
	public void buildingLinkRedirectionTest() throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Building Link RedirectionTest", "Verifies if Navigation functionality is working fine").assignCategory("CheckNavigation");
    
		ReusableMethodsLandingPage reuse = new ReusableMethodsLandingPage();

		try {
			
			
			reuse.clickLink("BuildingLink","Clicking Building link on Landing Page");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("buildingLinkRedirectionTest");
			throw e1;
		}
	}
}
