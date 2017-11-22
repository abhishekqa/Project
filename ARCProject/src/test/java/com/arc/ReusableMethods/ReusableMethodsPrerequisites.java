package com.arc.ReusableMethods;

import java.io.IOException;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsPrerequisites {

	public static ExtentTest test;

	public void PrereqAttempt(String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		CommonMethod.click( firstCredit);
		CommonMethod.testlog( "Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {
			
			CommonMethod.click( "Affirmations");
			CommonMethod.testlog( "Pass", "Clicking on Affirmations");
			Thread.sleep(2000);
			CommonMethod.click( "makeCreditEditable");
			CommonMethod.testlog( "Pass", "Clicking on edit credit");
			CommonMethod.click( "creditstatusdropdown");
			CommonMethod.testlog( "Pass", "Clicking on credit status dropdown");
			CommonMethod.click( "ReadyforreviewDropdown");
			CommonMethod.testlog( "Pass", "Selecting ready for review");
			CommonMethod.click( "SaveButton");
			CommonMethod.testlog( "Pass", "Clicking on save button");
			Thread.sleep(3000);
			CommonMethod.click( "NextButtonprerequisites");
			CommonMethod.testlog( "Pass", "Clicking on Next button");
			Thread.sleep(2000);
		}
		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		Thread.sleep(3000);
	}
	public void PrereqTextFileUpload( String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		CommonMethod.click( firstCredit);
		CommonMethod.testlog( "Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {
			
			/*CommonMethod.FluentWait( "BclickFileUpload");
		    CommonMethod.moveToElement( "BclickFileUpload");
			CommonMethod.click( "BclickFileUpload");
			Runtime.getRuntime().exec(System.getProperty("user.dir") +"/ARCDataTemplete/txtFileUploadScript.exe");*/
			CommonMethod.displayhiddenElement("UploadBasePointHidden");
			Thread.sleep(6000);
			CommonMethod.sendKeys("UploadBasePointHidden", System.getProperty("user.dir")+"/ARCDataTemplete/txtFileUpload.txt");
			Thread.sleep(5000);
			CommonMethod.assertEqualsmessage( "InfoMessage", "File successfully uploaded.", "something went wrong");
			CommonMethod.testlog( "Pass","text file Uploaded successfully");
			CommonMethod.click( "NextButtonprerequisites");
			CommonMethod.testlog( "Pass","Clicking on Next button");
			Thread.sleep(3000);
		}
		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		Thread.sleep(3000);
	}
	public void ClickSubmitforReview( ) throws IOException {

		CommonMethod.click( "SubmitforReview");
		CommonMethod.testlog( "Pass", "Clicking Submit for Review");

	}

	public void ClickPrerequisites() throws IOException {

		CommonMethod.click( "prerequisites");
		CommonMethod.testlog( "Pass", "Clicking on prerequisites");

	}

	public void VerifyRequirementscomplete( ) throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		CommonMethod.click( "prerequisites");
		CommonMethod.testlog( "Pass", "Clicking on prerequisites");
		CommonMethod.click( "SubmitforReview");
		CommonMethod.testlog( "Pass", "Clicking Submit for Review");
		CommonMethod.Isdisplayed( "RequirementVerify", "Requirements are still not completed");
		CommonMethod.testlog( "Pass", "Verifying if requirements is complete");

	}

	public void teamMemberAssignCredit(  String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		CommonMethod.click( firstCredit);
		CommonMethod.testlog( "Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {

			CommonMethod.click( "CreditAssignedtoMemberEdit");
			CommonMethod.testlog( "Pass", "Clicking on edit Assign Team Member to credit");
			CommonMethod.click( "teamMemberassignDropdown");
			CommonMethod.testlog( "Pass", "Clicking on team member dropdown");
			CommonMethod.click( "teamMemberassignDropdownValue");
			CommonMethod.testlog( "Pass", "Assigning team member");
			CommonMethod.click( "SaveButtonTeamMemberAssign");
			CommonMethod.testlog( "Pass", "Clicking on save button");
			Thread.sleep(3000);
			CommonMethod.click( "NextButtonprerequisites");
			CommonMethod.testlog( "Pass", "Clicking on Next button");
		}
		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		Thread.sleep(8000);
		CommonMethod.assertcontainsmessage( "VerifyteamMemberassigned", "Me", "Team Member Assigned to Credit is not displayed");
	}
	public void PrereqFileUpload(  String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		CommonMethod.click( firstCredit);
		CommonMethod.testlog( "Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {
			
			/*CommonMethod.FluentWait( "BclickFileUpload");
		    CommonMethod.moveToElement( "BclickFileUpload");
			CommonMethod.click( "BclickFileUpload");
			Runtime.getRuntime().exec(System.getProperty("user.dir") +"/ARCDataTemplete/PdfScript.exe");*/
			CommonMethod.displayhiddenElement("UploadBasePointHidden");
			Thread.sleep(6000);
			CommonMethod.sendKeys("UploadBasePointHidden", System.getProperty("user.dir")+"/ARCDataTemplete/USGBC.pdf");
			Thread.sleep(6000);
			CommonMethod.assertEqualsmessage( "InfoMessage", "File successfully uploaded.", "something went wrong");
			CommonMethod.testlog( "Pass","text file Uploaded successfully");
			CommonMethod.click( "NextButtonprerequisites");
			CommonMethod.testlog( "Pass","Clicking on Next button");
			Thread.sleep(3000);
		
		
		
		
			
		}
		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		Thread.sleep(3000);
	}

}
