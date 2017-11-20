package com.arc.ReusableMethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsReviewCertification extends BaseClass{

	public static ExtentTest test;

	
	
	public void ClickProceedPrecertification() throws IOException, InterruptedException{
	
		 CommonMethod.click( "PreCertification");
		 Thread.sleep(3000);
		 CommonMethod.testlog( "Pass", "Clicking on Proceed with Precertification");	
		 	
		}
	public void ClickProceedCertification() throws IOException, InterruptedException{
		
		 CommonMethod.click( "Certification");
		 Thread.sleep(3000);
		 CommonMethod.testlog( "Pass", "Clicking on Proceed with Precertification");	
		 	
		}
	
	public void ClickProceedPerformanceScore() throws IOException, InterruptedException{
		
		 CommonMethod.click( "PerformanceScoreVerification");
		 Thread.sleep(3000);
		 CommonMethod.testlog( "Pass", "Clicking on Proceed with Perforamace score verification successfully");	
		 	
		}
	
	public void R_PaymentbyCC( String Objectlocator, String successMessage, String sheetName, int rowNum)
			throws IOException, InterruptedException {
			
		
			String cardName   = data.getCellData(sheetName, "Card Name", rowNum);
			String cardlast   = data.getCellData(sheetName, "Card Last", rowNum);
			String cardNum    = data.getCellData(sheetName, "Card Number", rowNum);
			String cardDate   = data.getCellData(sheetName, "Date ", rowNum);
			String cardCvv    = data.getCellData(sheetName, "CVV", rowNum);
			String mobile     = data.getCellData(sheetName, "Mobile", rowNum);
			String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
			String address    = data.getCellData(sheetName, "Address", rowNum);
			String city       = data.getCellData(sheetName, "City", rowNum);
			String country    = data.getCellData(sheetName, "Country", rowNum);
			String state      = data.getCellData(sheetName, "State", rowNum);
			String zip        = data.getCellData(sheetName, "Zip", rowNum);
		    
		    CommonMethod.clear( "R_FirstName");
			CommonMethod.testlog("Pass","Verifying Review Payment Via Credit Card Test");
			CommonMethod.sendKeys("R_FirstName", cardName);
			CommonMethod.testlog("Pass","Entered First Name ");
			
			CommonMethod.clear( "R_LastName");
			CommonMethod.sendKeys("R_LastName", cardlast);
			CommonMethod.testlog("Pass","Entered Last Name ");
			
			CommonMethod.sendKeys( "R_CardNumber", cardNum);
			CommonMethod.testlog( "Pass", "Entering CardNumber 4012000010000");
			
			CommonMethod.sendKeys( "R_Exp", cardDate);
			CommonMethod.testlog( "Pass", "Entering Expiry Date");
			CommonMethod.sendKeys( "R_CVV", cardCvv);
			CommonMethod.testlog( "Pass", "Entering CVV No. 999");
			
			CommonMethod.sendKeys( "R_Streetaddress", address);
			CommonMethod.testlog( "Pass", "Entering Billing Address");
			
			CommonMethod.sendKeys( "R_City",city);
			CommonMethod.testlog( "Pass", "Entering City");
			
			CommonMethod.selectdropdown( "BillCountry", country);
			CommonMethod.testlog( "Pass", "Entering Entering Country");
			
			
			CommonMethod.selectdropdown( "BillState", state);
			CommonMethod.testlog( "Pass", "Entering State");
			
			CommonMethod.clear( "R_ZipCode");
			CommonMethod.sendKeys( "R_ZipCode", zip);
			CommonMethod.testlog( "Pass", "Entering Zipcode");
			
			CommonMethod.clear( "R_BillToPartyEmail");
			CommonMethod.sendKeys( "BillPartyEmail", partyEmail);
			CommonMethod.testlog( "Pass", "Entering Bill Party Email");
			
			
			CommonMethod.clear( "R_Phone");
			CommonMethod.sendKeys( "R_Phone", mobile);
			CommonMethod.testlog( "Pass", "Entering Phone Number");
				
			CommonMethod.click( "R_Continue");
		   	CommonMethod.testlog( "Pass","Test passed Review Payment Completed Successuflly ");
		   	Thread.sleep(3000);
			
		   

		}
	 public void verifyPreCertReviewSelection(String param) throws IOException, InterruptedException{
			CommonMethod.ArcSpecifictoggle( "CreditAction");
			
			 ClickReview("Review");
			
		   	 Thread.sleep(7000);
		   //	 CommonMethod.FluentWait("R_Energy");
			 MarkDataInput();
		   	 
	        CommonMethod.sendKeys("R_TextArea","Welcome to Arc -> Features of Arc to keep their LEED certification up to date. Project leads can also use Arc for performance data tracking ." );
		   	CommonMethod.testlog( "Pass","Sended text area values correctly");
			Thread.sleep(2000);
		   
			CommonMethod.click( "R_Continue");
		   	CommonMethod.testlog( "Pass","Clicking On Continue Selection Page ");
		   	Thread.sleep(3000);
		   	
		    CommonMethod.sendKeys( "R_DataSnapshot", "saurav@groupten.com");
		     
		    CommonMethod.click( "R_Send");
		    CommonMethod.testlog( "Pass","Clicking On Next Buttoion Successfully");
		    Thread.sleep(2000);
		    
			CommonMethod.assertEqualsmessage( "InfoMessage", "You will receive an email shortly.", "something went wrong");
			CommonMethod.testlog( "Pass","Verified Sended Email Successfully");
			
			
			
			CommonMethod.click( "R_Continue");
		   	CommonMethod.testlog( "Pass","Clicking On Continue Summery Page ");
		   	Thread.sleep(3000);
		
		   
		    CommonMethod.testlog("Pass","Marked DataInput Section  page successully ");
		   	
		   	
		   	
		   
	/*	   		public void aptTesting() throws Exception {
		   		try {
		   		URL url = new URL(
		   		“http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221;);
		   		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		   		conn.setRequestMethod(“GET”);
		   		conn.setRequestProperty(“Accept”, “application/json”);

		   		if (conn.getResponseCode() != 200) {
		   		throw new RuntimeException(” HTTP error code : ”
		   		+ conn.getResponseCode());
		   		}

		   		Scanner scan = new Scanner(url.openStream());
		   		String entireResponse = new String();
		   		while (scan.hasNext())
		   		entireResponse += scan.nextLine();

		   		System.out.println(“Response : “+entireResponse);

		   		scan.close();

		   		JSONObject obj = new JSONObject(entireResponse );
		   		String responseCode = obj.getString(“status”);
		   		System.out.println(“status : ” + responseCode);

		   		JSONArray arr = obj.getJSONArray(“results”);
		   		for (int i = 0; i < arr.length(); i++) {
		   		String placeid = arr.getJSONObject(i).getString(“place_id”);
		   		System.out.println(“Place id : ” + placeid);
		   		String formatAddress = arr.getJSONObject(i).getString(
		   		“formatted_address”);
		   		System.out.println(“Address : ” + formatAddress);

		   		//validating Address as per the requirement
		   		if(formatAddress.equalsIgnoreCase(“Chicago, IL, USA”))
		   		{
		   		System.out.println(“Address is as Expected”);
		   		}
		   		else
		   		{
		   		System.out.println(“Address is not as Expected”);
		   		}
		   		}

		   		conn.disconnect();
		   		} catch (MalformedURLException e) {
		   		e.printStackTrace();

		   		} catch (IOException e) {

		   		e.printStackTrace();

		   		}

		   		}
		   		}*/
			   }
	  public void ClickReview(String param) throws IOException{
			
		    CommonMethod.click( param);
		    
		    CommonMethod.testlog( "Pass","Clicking to Review "+ param);
				
			}
	   public void MarkDataInput() throws IOException, InterruptedException 
	 {
	   CommonMethod.moveToElement( "R_Energy");
	   CommonMethod.click( "R_Energy");
	   
	 //  Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Energy ");
	   CommonMethod.click( "R_Water");
	 //  Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Water ");
	   CommonMethod.click( "R_Waste");
	 //  Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Waste ");
	   CommonMethod.click( "R_Transportion");
	  // Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Transportation ");
	   CommonMethod.click( "R_HumanExperiance");
	  // Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked HumanExperiance ");
	   
	   
	 }
	   public void PRMarkDataInput() throws IOException, InterruptedException 
	 {
	   CommonMethod.moveToElement( "PR_Energy");
	   CommonMethod.click( "PR_Energy");
	   
	 //  Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Energy ");
	   CommonMethod.click( "PR_Water");
	 //  Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Water ");
	   CommonMethod.click( "PR_Waste");
	 //  Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked Waste ");
	   CommonMethod.click( "PR_Transportion");
	  // Thread.sleep(1000);
	   CommonMethod.testlog( "PPass","Marked Transportation ");
	   CommonMethod.click( "PR_HumanExperiance");
	  // Thread.sleep(1000);
	   CommonMethod.testlog( "Pass","Marked HumanExperiance ");
	   
	   
	 }
	public void verifySuccessfullySubmittedPayment() throws IOException {
		// TODO Auto-generated method stub
		
		String VerifySuccess= CommonMethod.getText( "R_Success");
		Assert.assertEquals("Successfully Submitted", VerifySuccess);
		CommonMethod.testlog("Pass","Verified Review Payment CC Successfully");
		
	}
	public void verifyCertReviewSelection(String param) throws IOException, InterruptedException{
		//CommonMethod.ArcSpecifictoggle( "CreditAction");
		
		 ClickReview("Review");
		
	   	Thread.sleep(7000);
	    CommonMethod.FluentWait("ClickCertification");
	   	CommonMethod.moveToElement( "ClickCertification");
	   	 
	   	CommonMethod.click( "ClickCertification");
	   	Thread.sleep(1000);
	   	CommonMethod.click( "SelectCertification");
		MarkDataInput();
	   	 
        CommonMethod.sendKeys("R_TextArea","Welcome to Arc -> Features of Arc to keep their LEED certification up to date. Project leads can also use Arc for performance data tracking ." );
	   	CommonMethod.testlog( "Pass","Sended text area values correctly");
		Thread.sleep(2000);
	   
		CommonMethod.click( "R_Continue");
	   	CommonMethod.testlog( "Pass","Clicking On Continue Selection Page ");
	   	Thread.sleep(3000);
	   	
	    CommonMethod.sendKeys( "R_DataSnapshot", "saurav@groupten.com");
	     
	    CommonMethod.click( "R_Send");
	    CommonMethod.testlog( "Pass","Clicking On Next Buttoion Successfully");
	    Thread.sleep(2000);
	    
		CommonMethod.assertEqualsmessage( "InfoMessage", "You will receive an email shortly.", "something went wrong");
		CommonMethod.testlog( "Pass","Verified Sended Email Successfully");
		
		CommonMethod.click( "R_Continue");
	   	CommonMethod.testlog( "Pass","Clicking On Continue Summery Page ");
	   	Thread.sleep(3000);   
	    CommonMethod.testlog("Pass","Marked DataInput Section  page successully ");
	   	
	}
	public void verifyPerformanceReviewSelection(String param) throws IOException, InterruptedException{
		//CommonMethod.ArcSpecifictoggle( "CreditAction");
		
		 ClickReview("Review");
		
	   	 Thread.sleep(7000);
	   //	 CommonMethod.FluentWait("R_Energy");
		 PRMarkDataInput();
	   	 
        CommonMethod.sendKeys("R_TextArea","Welcome to Arc -> Features of Arc to keep their LEED certification up to date. Project leads can also use Arc for performance data tracking ." );
	   	CommonMethod.testlog( "Pass","Sended text area values correctly");
		Thread.sleep(2000);
	   
		CommonMethod.click( "R_Continue");
	   	CommonMethod.testlog( "Pass","Clicking On Continue Selection Page ");
	   	Thread.sleep(3000);
	   	
	    CommonMethod.sendKeys( "R_DataSnapshot", "saurav@groupten.com");
	     
	    CommonMethod.click( "R_Send");
	    CommonMethod.testlog( "Pass","Clicking On Next Buttoion Successfully");
	    Thread.sleep(2000);
	    
		CommonMethod.assertEqualsmessage( "InfoMessage", "You will receive an email shortly.", "something went wrong");
		CommonMethod.testlog( "Pass","Verified Sended Email Successfully");
		
		CommonMethod.click( "R_Continue");
	   	CommonMethod.testlog( "Pass","Clicking On Continue Summery Page ");
	   	Thread.sleep(3000);
	
	   
	    CommonMethod.testlog("Pass","Marked DataInput Section  page successully ");
	   	
	   	
		   }
	
	
	
}

