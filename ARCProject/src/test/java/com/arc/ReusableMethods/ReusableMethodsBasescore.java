package com.arc.ReusableMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsBasescore extends BaseClass{

	public static ExtentTest test;

	public void BasescoreAttempt() throws IOException,
			InterruptedException {
		
		CommonMethod.ArcSpecifictoggle("CreditAction");
		ClickBaseScore();
		CommonMethod.click("SiteDevelopment");
		
		for(int i=0;i<=18;i++){
			if(i==6){
				CommonMethod.testlog("Pass","Verifies Credits Renewable Energy and Carbon Offsets ");
				String Renewable = CommonMethod.getText("Rewnawal");
				Assert.assertEquals(Renewable, "Renewable Energy and Carbon Offsets");
				CommonMethod.testlog("Pass","Test Passed Renewable Energy and Carbon Offsets verifies successfully");
			}
			
			CommonMethod.click("Affirmations");
			CommonMethod.testlog( "Pass","Clicking on Affirmation");
			Thread.sleep(2000);
			CommonMethod.click("makeCreditEditable");
			CommonMethod.testlog( "Pass","Clicking on Edit Credit symbol");
			CommonMethod.click( "creditstatusdropdown");
			CommonMethod.testlog("Pass","Clicking Credit status dropdown");
			CommonMethod.click( "ReadyforreviewDropdown");
			CommonMethod.testlog("Pass","Selecting Ready for review");
			CommonMethod.click( "SaveButton");
			CommonMethod.testlog("Pass","Clicking on save button");
			Thread.sleep(1000);
			CommonMethod.click("clickOk");
			CommonMethod.testlog( "Pass","Clicking on ok button");
			Thread.sleep(2000);
			CommonMethod.click("NextButtonprerequisites");
			CommonMethod.testlog( "Pass","Clicking on Next button");
		}

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickBaseScore();
		Thread.sleep(3000);
	}
	
public void TBasescoreAttempt() throws IOException,
	InterruptedException {

CommonMethod.ArcSpecifictoggle( "CreditAction");
ClickBaseScore();
CommonMethod.click( "SiteDevelopment");

for(int i=0;i<=22;i++){
	
	
	CommonMethod.click( "Affirmations");
	CommonMethod.testlog( "Pass","Clicking on Affirmation");
	Thread.sleep(2000);
	CommonMethod.click( "makeCreditEditable");
	CommonMethod.testlog( "Pass","Clicking on Edit Credit symbol");
	CommonMethod.click( "creditstatusdropdown");
	CommonMethod.testlog( "Pass","Clicking Credit status dropdown");
	CommonMethod.click( "ReadyforreviewDropdown");
	CommonMethod.testlog( "Pass","Selecting Ready for review");
	CommonMethod.click( "SaveButton");
	CommonMethod.testlog( "Pass","Clicking on save button");
	Thread.sleep(1000);
	CommonMethod.click("clickOk");
	CommonMethod.testlog( "Pass","Clicking on ok button");
	Thread.sleep(2000);
	CommonMethod.click( "NextButtonprerequisites");
	CommonMethod.testlog( "Pass","Clicking on Next button");
}

CommonMethod.ArcSpecifictoggle( "CreditAction");
ClickBaseScore();
Thread.sleep(3000);
}
    public void ClickBaseScore() throws IOException{
		
	    CommonMethod.click( "basescore");
	    CommonMethod.testlog( "Pass","Clicking on BaseScore");
			
		}
	
 public void BasePointFileUplaod() throws IOException,InterruptedException {

CommonMethod.ArcSpecifictoggle( "CreditAction");
ClickBaseScore();
CommonMethod.click( "SiteDevelopment");

for(int i=0;i<=17;i++){
	
	//CommonMethod.click( "BclickFileUpload");
	//CommonMethod.FluentWait( "UploadDataMeterHidden");
    //CommonMethod.moveToElement( "UploadDataMeterHidden");
/*	CommonMethod.displayhiddenElement("UploadDataMeterHidden");
	Thread.sleep(3000);*/
    //CommonMethod.click( "BclickFileUpload");
	//Runtime.getRuntime().exec(System.getProperty("user.dir")+"/ARCDataTemplete/PdfScript.exe");
	//System.out.println(System.getProperty("user.dir")+"/ARCDataTemplete/PdfScript.exe");
	CommonMethod.displayhiddenElement("UploadBasePointHidden");
	
	CommonMethod.sendKeys("UploadBasePointHidden", CommonMethod.basepointFilePdf);
	
	System.out.println(CommonMethod.basepointFilePdf);
	
	//Thread.sleep(6000);
	/*WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='messenger-message-inner']")));
	*/
	CommonMethod.WaitUntilVisibility("pdfFileUploaded");
	
	//CommonMethod.FluentWait("InfoMessage");
	//CommonMethod.assertEqualsmessage( "InfoMessage", "File successfully uploaded.", "something went wrong");
	
	CommonMethod.Isdisplayed("pdfFileUploaded", "File Not  Uploaded Successfully");
	
	CommonMethod.click( "NextButtonprerequisites");
	CommonMethod.testlog( "Pass","Clicking on Next button");
	Thread.sleep(3000);

}

CommonMethod.ArcSpecifictoggle( "CreditAction");
ClickBaseScore();
Thread.sleep(3000);
}
public void TBasePointFileUplaod() throws IOException,InterruptedException {

CommonMethod.ArcSpecifictoggle( "CreditAction");
ClickBaseScore();
CommonMethod.click( "SiteDevelopment");

for(int i=0;i<=22;i++){
	
    CommonMethod.displayhiddenElement("UploadBasePointHidden");
	
	CommonMethod.sendKeys("UploadBasePointHidden", CommonMethod.basepointFilePdf);
	
	/*CommonMethod.FluentWait( "BclickFileUpload");
    CommonMethod.moveToElement( "BclickFileUpload");
	CommonMethod.click( "BclickFileUpload");
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"/ARCDataTemplete/PdfScript.exe");
	*/Thread.sleep(6000);
	CommonMethod.assertEqualsmessage( "InfoMessage", "File successfully uploaded.", "something went wrong");
	
	CommonMethod.click( "NextButtonprerequisites");
	CommonMethod.testlog( "Pass","Clicking on Next button");
	Thread.sleep(3000);

}

CommonMethod.ArcSpecifictoggle( "CreditAction");
ClickBaseScore();
Thread.sleep(3000);
}
 
 
}
	
	
	
	
	

