package com.arc.ReusableMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsLandingPage {

	public static ExtentTest test;
	
public void clickArcLogoPostLogin(WebDriver driver) throws IOException, InterruptedException{
		
		CommonMethod.click("Logo");
		CommonMethod.testlog( "Pass", "Clicking Arc Logo on LandingPostLogin");
		Thread.sleep(5000);
		CommonMethod.assertcurrentUrlTest("http://stg.arconline.io/");
		CommonMethod.testlog( "Pass", "Logo redirects to http://stg.arconline.io/");
	}
	
public void clickArcLogo(WebDriver driver) throws IOException{
		
		CommonMethod.click( "ArcLogo");
		CommonMethod.testlog( "Pass", "Clicking Arc Logo on Landing Page");
	    CommonMethod.assertcurrentUrl( "http://stg.arconline.io/", "Navigation Url is not correct");
		CommonMethod.testlog( "Pass", "Logo redirects to http://stg.arconline.io/");
	}

public void clickLink(String objectlink, String message) throws IOException{
	
	CommonMethod.scrolldowntoElement( objectlink);
	CommonMethod.Isdisplayed( objectlink, "Link overlapped with navbar");
	CommonMethod.click( objectlink);
	CommonMethod.testlog( "Pass", message);
	CommonMethod.Isdisplayed( "LoginModalWindow", "Login Modal window is not displayed");
	CommonMethod.testlog( "Pass", "Redirects to login modal window");
}


	
	
	
	
	
	
	
	
	
}
