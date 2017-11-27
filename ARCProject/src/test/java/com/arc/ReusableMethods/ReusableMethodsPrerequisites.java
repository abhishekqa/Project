package com.arc.ReusableMethods;

import java.io.IOException;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsPrerequisites extends BaseClass {

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
	public void parkinInnovation(String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle( "Innovation");
		CommonMethod.click( firstCredit);
		CommonMethod.testlog("Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {			
			
			CommonMethod.testlog( "Pass", "Clicking on Checkbox1");
			
			if(i==0)
			{
				CommonMethod.click("Checkbox1");
				Thread.sleep(3000);
				CommonMethod.click("Checkbox2");
				CommonMethod.click("Checkbox3");
				CommonMethod.click("Checkbox4");
				CommonMethod.click("Checkbox5");
				
				Thread.sleep(4000);
				
				CommonMethod.testlog("Pass", "Measure D1 - Innovative Approach total point Test Started");
		    	CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure D1 - Innovative Approach points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			 
			}
	       
				
			
			CommonMethod.click("BNext");
			CommonMethod.testlog("Pass", "Clicking on Next button");
			Thread.sleep(2000);
		}
		CommonMethod.click("sliderManagement");
		CommonMethod.ArcSpecifictoggle( "Innovation");
		CommonMethod.testlog("Pass", "Verified Total Points By Marking all credit for Management section successuflly");
		Thread.sleep(2000);
	}
	
	
	 public void AllMeasureFileUpload(  String firstCredit, int NoOfCredits)
			   throws IOException, InterruptedException {

			  CommonMethod.ArcSpecifictoggle( "AllMeasure");
			  CommonMethod.click( firstCredit);
			  CommonMethod.testlog( "Pass", "Clicking on Credit " + firstCredit);

			  for (int i = 0; i <= NoOfCredits; i++) {
			   
			   CommonMethod.displayhiddenElement("ParkPdfUpload");
			   Thread.sleep(6000);
			   CommonMethod.sendKeys("ParkPdfUpload", CommonMethod.basepointFilePdf);    
			   CommonMethod.WaitUntilInVisibility("ImageLoader");
			   CommonMethod.testlog( "Pass","Pdf file Uploaded successfully");
			   CommonMethod.click("BNext");
			   CommonMethod.testlog( "Pass","Clicking on Next button");
			   Thread.sleep(3000); 
			  }
			  CommonMethod.click("sliderManagement");
			  CommonMethod.ArcSpecifictoggle( "AllMeasure");
			  Thread.sleep(3000);
			 }
	
	
	public void parkingTechnology(String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle( "Technology");
		CommonMethod.click( firstCredit);
		CommonMethod.testlog("Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {			
			CommonMethod.click("Checkbox1");
			CommonMethod.testlog( "Pass", "Clicking on Checkbox1");
			
			if(i==0)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C1 - Idle Reduction Payment Systems total point Test Started");
		    	CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C1 - Idle Reduction Payment Systems total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			 
			}
	       
			if(i==1)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C2 - Fire Suppression Systems total points Test Started");		
				//Reported issue will be fixed in 1.6
				//CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C2 - Fire Suppression Systems total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==2)
			{
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure C3 - No/Low-VOC Coatings, Paints and Sealants total points Test Started");
				CommonMethod.click("Checkbox2");
				CommonMethod.click("Checkbox2");
				Thread.sleep(4000);
				//Reported issue will be fixed in 1.6
			//	CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C3 - No/Low-VOC Coatings, Paints and Sealants total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==3)
			{
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure C4 - Tire Inflation Stations total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "2 of 2 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C4 - Tire Inflation Stations total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			  
			}
			
			if(i==4)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox5");
				Thread.sleep(4000);
				CommonMethod.testlog("Pass", "Measure C5 - Electric Vehicle (EV) Charging Stations total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C5 - Electric Vehicle (EV) Charging Stations total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
		
			}
			
			if(i==5)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox5");
				Thread.sleep(2000);
				CommonMethod.click("Checkbox8");
				Thread.sleep(2000);
				CommonMethod.click("Checkbox13");
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure C6 - HVAC Systems - Occupied Spaces total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C6 - HVAC Systems - Occupied Spaces total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==6)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox4");
				CommonMethod.click("Checkbox7");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C7 - Ventilation Systems - Parking Decks total points Test");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C7 - Ventilation Systems - Parking Decks total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			
			}
			
			if(i==7)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox5");
				Thread.sleep(4000);
				CommonMethod.testlog("Pass", "Measure C8 - Lighting Controls total points Verified Successully");
				//Reported issue will be fixed in 1.6 
			//	CommonMethod.assertcontainsmessage("ParkingPoint", "8 of 8 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C8 - Lighting Controls total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==8)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C9 - Energy-efficient Lighting System total points Test Started");
				CommonMethod.click("Checkbox3");
				Thread.sleep(4000);
				//Reported issue will be fixed in 1.6
				//CommonMethod.assertcontainsmessage("ParkingPoint", "8 of 8 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C9 - Energy-efficient Lighting System total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==9)
			{  
				Thread.sleep(2000);
				CommonMethod.click("Checkbox3");
				CommonMethod.click("Checkbox5");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C10 - Stormwater Management total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C10 - Stormwater Management total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			}
			if(i==10)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C11 - Rainwater Harvesting total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C11 - Rainwater Harvesting total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			}
			if(i==11)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C12 - Greywater Reuse total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "2 of 2 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C12 - Greywater Reuse total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==12)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C13 - Indoor Water-efficiency total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "2 of 2 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C13 - Indoor Water-efficiency total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			  
			}
			if(i==13)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C14 - Water-efficient Landscaping total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "2 of 2 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C14 - Water-efficient Landscaping total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==14)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C15 - Roofing Systems total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C15 - Roofing Systems total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==15)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C16 - Renewable Energy Generation total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "12 of 12 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C16 - Renewable Energy Generation total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			  
			}	
			
			if(i==16)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C17 - Design for Durability total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C17 - Design for Durability total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			  
			}
			if(i==17)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox4");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure C18 - Energy Resiliency - Storage total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure C18 - Energy Resiliency - Storage total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			  
			}
			
			CommonMethod.click("BNext");
			CommonMethod.testlog("Pass", "Clicking on Next button");
			Thread.sleep(2000);
		}
		CommonMethod.click("sliderManagement");
		CommonMethod.ArcSpecifictoggle( "Technology");
		CommonMethod.testlog("Pass", "Verified Total Points By Marking all credit for Management section successuflly");
		Thread.sleep(2000);
	}
	public void parkingman(String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle( "Management");
		CommonMethod.click( firstCredit);
		CommonMethod.testlog("Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {			
			CommonMethod.click("Checkbox1");
			CommonMethod.testlog( "Pass", "Clicking on Checkbox1");
			
			if(i==0)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A1 - Parking Pricing total point Test Started");
		    	CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A1 - Parking Pricing total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			 
			}
	       
			if(i==1)
			{
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure A2 - Shared Parking total points Test Started");
				CommonMethod.click("Checkbox6");
				Thread.sleep(5000);
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A2 - Shared Parking total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==2)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A3 - Transportation Management total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A3 - Transportation Management total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==3)
			{
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure A4 - Recycling Program total points Test Started");
				CommonMethod.click("Checkbox6");
				Thread.sleep(4000);
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A4 - Recycling Program total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			  
			}
			
			if(i==4)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A5 - Sustainable Purchasing Program total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "2 of 2 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A5 - Sustainable Purchasing Program total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
		
			}
			
			if(i==5)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A6 - Proactive Operational Maintenance total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A6 - Proactive Operational Maintenance total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==6)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A7 - Cleaning Procedures - Occupied Spaces total points Test");
				CommonMethod.assertcontainsmessage("ParkingPoint", "2 of 2 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A7 - Cleaning Procedures - Occupied Spaces total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			
			}
			
			if(i==7)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox5");
				CommonMethod.click("Checkbox9");
				Thread.sleep(4000);
				CommonMethod.testlog("Pass", "Measure A8 - Cleaning Procedures - Parking Decks total points Verified Successully");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A8 - Cleaning Procedures - Parking Decks total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==8)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A9 - Building Systems Commissioning total points Test Started");
				CommonMethod.click("Checkbox5");
				CommonMethod.click("Checkbox9");
				Thread.sleep(4000);
				CommonMethod.assertcontainsmessage("ParkingPoint", "8 of 8 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A9 - Building Systems Commissioning total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==9)
			{  
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure A10 - Construction Waste Management total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A10 - Construction Waste Management total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			}
			if(i==10)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A11 - Regional Materials for New Construction, Rehabilitation, or Retrofit total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A11 - Regional Materials for New Construction, Rehabilitation, or Retrofit total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			}
			if(i==11)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox3");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A12 - Regional Labor for New Construction, Rehabilitation, or Retrofit total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A12 - Regional Labor for New Construction, Rehabilitation, or Retrofit total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==12)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A13 - Reused, Repurposed or Recycled Materials total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A13 - Reused, Repurposed or Recycled Materials total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			  
			}
			if(i==13)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A14 - Third Party Sustainability Certification total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "12 of 12 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A14 - Third Party Sustainability Certification total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==14)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A15 - Credentialed Management total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A15 - Credentialed Management total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==15)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure A16 - Life-cycle Assessment total points Test started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "8 of 8 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure A16 - Life-cycle Assessment total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			  
			}			
			
			CommonMethod.click("BNext");
			CommonMethod.testlog("Pass", "Clicking on Next button");
			Thread.sleep(2000);
		}
		CommonMethod.click("sliderManagement");
		CommonMethod.ArcSpecifictoggle( "Management");
		CommonMethod.testlog("Pass", "Verified Total Points By Marking all credit for Management section successuflly");
		Thread.sleep(2000);
	}
	public void parkingprogram(String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {
		   CommonMethod.ArcSpecifictoggle( "Program");
		   CommonMethod.click( firstCredit);
		   CommonMethod.testlog("Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {			
			CommonMethod.click("Checkbox1");
			CommonMethod.testlog( "Pass", "Clicking on Checkbox1");
			
			if(i==0)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox2");
				CommonMethod.click("Checkbox3");
				CommonMethod.click("Checkbox4");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B1 - Placemaking total point Test Started");
				//Fetching Reported issue 
		    //	CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B1 - Placemaking total point Test Started total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			 
			}
	       
			if(i==1)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B2 - Access to Mass Transit total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B2 - Access to Mass Transit total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==2)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox4");
				Thread.sleep(3000);
				CommonMethod.click("Checkbox6");
				Thread.sleep(5000);
				CommonMethod.testlog("Pass", "Measure B3 - Wayfinding Systems - External total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B3 - Wayfinding Systems - External total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==3)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B4 - Wayfinding Systems - Internal total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B4 - Wayfinding Systems - Internal total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			  
			}
			
			if(i==4)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B5 - Traffic Flow Plan total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B5 - Traffic Flow Plan total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
		
			}
			
			if(i==5)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox6");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B6 - Carshare Program total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B6 - Carshare Program total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==6)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox7");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B7 - Rideshare Program total points Test");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B7 - Rideshare Program total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			
			}
			
			if(i==7)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox6");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B8 - Low-emitting and Fuel-efficient Vehicle Program total points Verified Successully");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B8 - Low-emitting and Fuel-efficient Vehicle Program total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			
			if(i==8)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B9 - Alternative Fuel Vehicles total points Test Started");
				CommonMethod.click("Checkbox5");
				Thread.sleep(4000);
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B9 - Alternative Fuel Vehicles total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==9)
			{  
				Thread.sleep(2000);
				CommonMethod.testlog("Pass", "Measure B10 - Alternative Fuel Fleet Vehicles total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B10 - Alternative Fuel Fleet Vehicles total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			}
			if(i==10)
			{
				Thread.sleep(3000);
				CommonMethod.click("Checkbox6");
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B11 - Bicycle Parking total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B11 - Bicycle Parking points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			    
			}
			if(i==11)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B12 - Bicycle Sharing/Rental total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "6 of 6 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B12 - Bicycle Sharing/Rental total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			   
			}
			if(i==12)
			{
				Thread.sleep(3000);
				CommonMethod.testlog("Pass", "Measure B13 - Marketing/Educational Program total points Test Started");
				CommonMethod.assertcontainsmessage("ParkingPoint", "4 of 4 Points Pursued", "Point is Incorrect");
			    CommonMethod.testlog("Pass", "Measure B13 - Marketing/Educational Program total points Verified Successully");
			    CommonMethod.testlog("Pass", "Test passed");
			  
			}
			
			CommonMethod.click("BNext");
			CommonMethod.testlog("Pass", "Clicking on Next button");
			Thread.sleep(2000);
		}
		CommonMethod.click("sliderManagement");
		CommonMethod.ArcSpecifictoggle( "Program");
		CommonMethod.testlog("Pass", "Verified Total Points By Marking all credit for Management section successuflly");
		Thread.sleep(2000);
	}
	
	public void PrereqTextFileUpload( String firstCredit, int NoOfCredits)
			throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickPrerequisites();
		CommonMethod.click( firstCredit);
		CommonMethod.testlog( "Pass", "Clicking on Credit " + firstCredit);

		for (int i = 0; i <= NoOfCredits; i++) {
			
			
			CommonMethod.displayhiddenElement("UploadBasePointHidden");
			Thread.sleep(6000);
			CommonMethod.sendKeys("UploadBasePointHidden", CommonMethod.prerequisiteTextFile);
			CommonMethod.WaitUntilInVisibility("ImageLoader");
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
			//Thread.sleep(6000);
			CommonMethod.sendKeys("UploadBasePointHidden", CommonMethod.basepointFilePdf);
			//Thread.sleep(6000);
			CommonMethod.WaitUntilInVisibility("ImageLoader");
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
