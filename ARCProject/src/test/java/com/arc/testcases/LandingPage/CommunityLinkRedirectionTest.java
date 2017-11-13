package com.arc.testcases.LandingPage;



import java.io.IOException;

import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLandingPage;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class CommunityLinkRedirectionTest extends BaseClass {

	@Test
	public void communityLinkRedirectionTest() throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Communities Link Redirection Test", "Verifies if Navigation functionality is working fine").assignCategory("CheckNavigation");
    
		ReusableMethodsLandingPage reuse = new ReusableMethodsLandingPage();

		
		try {
			
			
			reuse.clickLink("CommunitiesLink","Clicking Community link on Landing Page");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("communityLinkRedirectionTest");
			throw e1;
		}
	}
}
