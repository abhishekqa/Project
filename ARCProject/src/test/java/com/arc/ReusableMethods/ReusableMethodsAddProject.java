package com.arc.ReusableMethods;

import java.io.IOException;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsAddProject extends BaseClass{

	public static ExtentTest test;

	public void clickAddProjectMyBuildings() throws IOException, InterruptedException {
		CommonMethod.click("AddProjectButton");
		CommonMethod.testlog("Pass", "Clicking on Add Project Button");
		Thread.sleep(1000);

	}
	public void clickAddProject() throws IOException, InterruptedException {
		CommonMethod.click("AddProjectButton");
		CommonMethod.testlog( "Pass", "Clicking on Add Project Button");
		Thread.sleep(1000);

	}
	public void AddProjectNoneUS(int rowNum, String sheetName) throws IOException, InterruptedException {
		
		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"Project Name" ,rowNum, "US Building None"+" " + CommonMethod.randomNumber() );
														   
		String prjName 	= data.getCellData(sheetName, "Project Name", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys( "ProjectName", prjName);
				
		Thread.sleep(2000);
		CommonMethod.testlog("Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog("Pass","Selecting Project Type as Buildings");
	
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
		CommonMethod.testlog("Pass","Selecting Ratings as LEED for Buildings");
		
		CommonMethod.selectdropdownrandom("SpaceType");
		CommonMethod.testlog("Pass", "Selecting Space Type");
		
		CommonMethod.selectdropdown("OwnerType",ownerType);
		CommonMethod.testlog("Pass", "Selecting Owner Type Type");
		
		
		CommonMethod.sendKeys("OwnerOrg", ownerOrg);
		Thread.sleep(2000);
		CommonMethod.click("OwnerOrg");
		
		CommonMethod.click("ownerorg");
	//	Thread.sleep(1000);
	//	CommonMethod.testlog( "Pass", "Entering Owner Type");	
		
		CommonMethod.testlog("Pass", "Entering Owner Organization");
		CommonMethod.sendKeys("OwnerEmail", ownerMail);
		CommonMethod.testlog("Pass", "Entering Owner Email");
		CommonMethod.selectdropdown("OwnerCountry", ownerCountry);
		CommonMethod.testlog("Pass", "Entering Owner Country");
		CommonMethod.sendKeys("Area", prjArea);
		CommonMethod.testlog("Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys("Address", prjAddress);
		CommonMethod.testlog("Pass", "Entering Address");
		CommonMethod.sendKeys("City", prjCity);
		CommonMethod.testlog("Pass", "Entering City");
		CommonMethod.selectdropdown("Country", prjCountry);
		CommonMethod.testlog("Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog("Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		CommonMethod.testlog("Pass", "Entering Zipcode");
		CommonMethod.click("AgreeTermsProgReg");
		CommonMethod.testlog("Pass", "Clicking on agree to terms");
		CommonMethod.click("NextButton");
		CommonMethod.testlog("Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);

	}
	public void AddProjectNoneIND(String sheetName, int rowNum) throws IOException, InterruptedException {

		clickAddProjectMyBuildings();
		CommonMethod.sendKeys( "ProjectName",
				"MachineTestProject" + " " + CommonMethod.randomNumber());
		Thread.sleep(2000);
		CommonMethod.testlog("Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.click("ProjectTypeBuildings");
		Thread.sleep(1000);
		CommonMethod.click("ClickOnProjectType");
		CommonMethod.testlog("Pass", "Click On PorjectType");
		Thread.sleep(2000);
		CommonMethod.testlog("Pass", "Selecting Project Type as Buildings");
		Thread.sleep(2000);
		/*CommonMethod.click("ClickOnRatingSystem");
		Thread.sleep(2000);
		CommonMethod.click("RatingSystemLEED");
		Thread.sleep(5000);*/
		//CommonMethod.testlog( "Pass", "Selecting RatingSystem as LEED");
		CommonMethod.selectdropdownrandom("SpaceType");
		CommonMethod.testlog("Pass", "Selecting Space Type");
		CommonMethod.sendKeys("OwnerType", "Test Owner");
		CommonMethod.testlog("Pass", "Entering Owner Type");
		CommonMethod.sendKeys("OwnerOrg", "Test Org");
		CommonMethod.testlog("Pass", "Entering Owner Organization");
		CommonMethod.sendKeys("OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog("Pass", "Entering Owner Email");
		CommonMethod.selectdropdown("OwnerCountry", "United States");
		CommonMethod.testlog("Pass", "Entering Owner Country");
		CommonMethod.sendKeys("Area", "10000");
		CommonMethod.testlog("Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys("Address", "Test Address");
		CommonMethod.testlog("Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog("Pass", "Entering City");
		CommonMethod.selectdropdown("Country", "India");
		CommonMethod.testlog("Pass", "Entering Country");
		CommonMethod.selectdropdown("State", "Delhi");
		CommonMethod.testlog("Pass", "Entering State");
		CommonMethod.sendKeys("ZipCode", "350059");
		CommonMethod.testlog("Pass", "Entering Zipcode");
		CommonMethod.click("AgreeTermsProgReg");
		CommonMethod.testlog("Pass", "Clicking on agree to terms");
		CommonMethod.click("NextButton");
		CommonMethod.testlog("Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);

	}
	
	public void AddProjectLEEDIND() throws IOException, InterruptedException {

		clickAddProjectMyBuildings();
		CommonMethod.sendKeys( "ProjectName",
				"MachineTestProject" + " " + CommonMethod.randomNumber());
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.click("ProjectTypeBuildings");
		Thread.sleep(1000);
		CommonMethod.click("ClickOnProjectType");
		CommonMethod.testlog("Pass","Click On PorjectType");
		Thread.sleep(1000);
		CommonMethod.testlog("Pass","Selecting Project Type as Buildings");
		Thread.sleep(1000);
		CommonMethod.click("ClickOnRatingSystem");
		Thread.sleep(1000);
		CommonMethod.click("RatingSystemLEED");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Selecting RatingSystem as LEED");
		
		CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
		Thread.sleep(1000);
		CommonMethod.sendKeys( "OwnerType", "Test Owner");
		CommonMethod.testlog( "Pass", "Entering Owner Type");
		CommonMethod.sendKeys( "OwnerOrg", "Test Org");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", "United States");
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", "10000");
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", "Test Address");
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", "India");
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", "Delhi");
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", "350054");
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(10000);

	}
	
	
	
	public void AddProjectLEEDUS( String sheetName,int rowNum) throws IOException, InterruptedException {
		
		
		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"Project Name" ,rowNum, "US Building LEED v4"+" " + CommonMethod.randomNumber() );
														   
		String prjName 	= data.getCellData(sheetName, "Project Name", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys( "ProjectName", prjName);
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to Excel Sheet");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog("Pass","Selecting Project Type as Buildings");
	
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
		CommonMethod.testlog("Pass","Selecting Ratings as LEED for Buildings");
		
		CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
		
		CommonMethod.selectdropdown( "OwnerType",ownerType );
		CommonMethod.testlog( "Pass", "Selecting Owner Type ");
		
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		Thread.sleep(1000);
		CommonMethod.click( "OwnerOrg");
		
		CommonMethod.click( "ownerorg");
	//	Thread.sleep(1000);
	//	CommonMethod.testlog( "Pass", "Entering Owner Type");	
		
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
        String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

	}
	
	
	
	
	public void AddProjectLEEDfortransit() throws IOException, InterruptedException {
		
		clickAddProject();
		CommonMethod.sendKeys( "ProjectName",
				"UndergroundTestProject" + " " + CommonMethod.randomNumber());
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType","Buildings");
		CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem","LEED for transit");
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for transit");
		
	    CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
	    
		CommonMethod.selectdropdown( "Station", "Underground");
		CommonMethod.testlog( "Pass", "Selecting RatingSystem as LEED");
		Thread.sleep(1000);
		CommonMethod.sendKeys("Annualridership","1000");
		CommonMethod.testlog( "Pass", "Entered Annualridership");
		
		CommonMethod.sendKeys( "WeeklyHours","100");
		CommonMethod.testlog( "Pass", "Entered WeeklyHours");
		
		CommonMethod.sendKeys( "Full_time_staff","1000");
		CommonMethod.testlog( "Pass", "Entered Full time Staff");
		
		CommonMethod.sendKeys( "Avg_time_staff","1000");
		CommonMethod.testlog( "Pass", "Entered Full time Staff");
		
		CommonMethod.selectdropdownrandom( "OwnerType");
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", "T & W Corporation");
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		
		CommonMethod.sendKeys( "OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", "United States");
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", "10000");
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", "Test Address");
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", "United States");
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", "Alabama");
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", "35005");
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

	}
public void AddAboveProjectLEEDfortransit(int rowNum,  String sheetName ) throws IOException, InterruptedException {
		
		String prjType 		    = data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating    	= data.getCellData(sheetName, "Rating System", rowNum);
		String prjStation 	    = data.getCellData(sheetName, "is_station", rowNum);
		String prjRidership     = data.getCellData(sheetName, "annual_ridership", rowNum);
		String prjWeek_opr_hrs 	= data.getCellData(sheetName, "week_opr_hrs", rowNum);
		String prjFulltime_staff= data.getCellData(sheetName, "fulltime_staff", rowNum);
		String prjAvg_time_spent= data.getCellData(sheetName, "avg_time_spent", rowNum);
		String prjNo_park_space = data.getCellData(sheetName, "no_park_space", rowNum);
		String prjPark_level    = data.getCellData(sheetName, "park_level", rowNum);
		String prjdate_comm	    = data.getCellData(sheetName, "date_comm", rowNum);
		String ownerType   	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"Project Name" ,rowNum, "US Building Aboveground"+" " + CommonMethod.randomNumber() );
														   
		String prjName 	= data.getCellData(sheetName, "Project Name", rowNum);
		
		clickAddProjectMyBuildings();
		CommonMethod.sendKeys( "ProjectName", prjName);
		
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for transit");
		
	    CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
	    
		CommonMethod.selectdropdown( "Station", prjStation);
		CommonMethod.testlog( "Pass", "Selecting RatingSystem as LEED");
		Thread.sleep(1000);
		CommonMethod.sendKeys("Annualridership",prjRidership);
		CommonMethod.testlog( "Pass", "Entered Annualridership");
		
		CommonMethod.sendKeys( "WeeklyHours",prjWeek_opr_hrs);
		CommonMethod.testlog( "Pass", "Entered WeeklyHours");
		
		CommonMethod.sendKeys( "Full_time_staff",prjFulltime_staff);
		CommonMethod.testlog( "Pass", "Entered Full time Staff");
		
		CommonMethod.sendKeys( "Avg_time_staff",prjAvg_time_spent);
		CommonMethod.testlog( "Pass", "Entered Full time Staff");
		
		CommonMethod.selectdropdown( "OwnerType",ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry",ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		Thread.sleep(1000);
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

	}

public void AddUndergroundProjectLEEDfortransit(int rowNum,  String sheetName ) throws IOException, InterruptedException {
	
	String prjType 		    = data.getCellData(sheetName, "Project Type", rowNum);
	String prjRating    	= data.getCellData(sheetName, "Rating System", rowNum);
	String prjStation 	    = data.getCellData(sheetName, "is_station2", rowNum);
	String prjRidership     = data.getCellData(sheetName, "annual_ridership", rowNum);
	String prjWeek_opr_hrs 	= data.getCellData(sheetName, "week_opr_hrs", rowNum);
	String prjFulltime_staff= data.getCellData(sheetName, "fulltime_staff", rowNum);
	String prjAvg_time_spent= data.getCellData(sheetName, "avg_time_spent", rowNum);
	String prjNo_park_space = data.getCellData(sheetName, "no_park_space", rowNum);
	String prjPark_level    = data.getCellData(sheetName, "park_level", rowNum);
	String prjdate_comm	    = data.getCellData(sheetName, "date_comm", rowNum);
	String ownerType   	= data.getCellData(sheetName, "Owner Type", rowNum);
	String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
	String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
	String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
	String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
	String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
	String prjCity 		= data.getCellData(sheetName, "City", rowNum);
	String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
	String prjState 	= data.getCellData(sheetName, "State", rowNum);
	String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
	
	//creating the project name
	data.setCellData(sheetName,"Project Name" ,rowNum, "US Building Underground"+" " + CommonMethod.randomNumber() );
													   
	String prjName 	= data.getCellData(sheetName, "Project Name", rowNum);
	
	clickAddProjectMyBuildings();
	CommonMethod.sendKeys( "ProjectName", prjName);
	
	Thread.sleep(1000);
	CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
	
	CommonMethod.selectdropdown("ClickOnProjectType",prjType);
	CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
	
	CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for transit");
	
    CommonMethod.selectdropdownrandom( "SpaceType");
	CommonMethod.testlog( "Pass", "Selecting Space Type");
    
	CommonMethod.selectdropdown( "Station", prjStation);
	CommonMethod.testlog( "Pass", "Selecting RatingSystem as LEED");
	Thread.sleep(1000);
	CommonMethod.sendKeys("Annualridership",prjRidership);
	CommonMethod.testlog( "Pass", "Entered Annualridership");
	
	CommonMethod.sendKeys( "WeeklyHours",prjWeek_opr_hrs);
	CommonMethod.testlog( "Pass", "Entered WeeklyHours");
	
	CommonMethod.sendKeys( "Full_time_staff",prjFulltime_staff);
	CommonMethod.testlog( "Pass", "Entered Full time Staff");
	
	CommonMethod.sendKeys( "Avg_time_staff",prjAvg_time_spent);
	CommonMethod.testlog( "Pass", "Entered Full time Staff");
	
	CommonMethod.selectdropdown( "OwnerType", ownerType);
	CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
	
	CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
	CommonMethod.click( "OwnerOrg");
	Thread.sleep(1000);
	CommonMethod.click( "ownerorg");
	CommonMethod.testlog( "Pass", "Entering Owner Organization");
	
	CommonMethod.sendKeys( "OwnerEmail", ownerMail);
	CommonMethod.testlog( "Pass", "Entering Owner Email");
	CommonMethod.selectdropdown( "OwnerCountry",ownerCountry);
	CommonMethod.testlog( "Pass", "Entering Owner Country");
	CommonMethod.sendKeys( "Area", prjArea);
	CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
	CommonMethod.sendKeys( "Address", prjAddress);
	CommonMethod.testlog( "Pass", "Entering Address");
	CommonMethod.sendKeys( "City", prjCity);
	CommonMethod.testlog( "Pass", "Entering City");
	CommonMethod.selectdropdown( "Country", prjCountry);
	CommonMethod.testlog( "Pass", "Entering Country");
	CommonMethod.selectdropdown( "State", prjState);
	CommonMethod.testlog( "Pass", "Entering State");
	CommonMethod.sendKeys( "ZipCode", prjZip);
	CommonMethod.testlog( "Pass", "Entering Zipcode");
	Thread.sleep(1000);
	CommonMethod.click( "AgreeTermsProgReg");
	CommonMethod.testlog( "Pass", "Clicking on agree to terms");
	CommonMethod.click( "NextButton");
	CommonMethod.testlog( "Pass", "Clicking on Next button");
	Thread.sleep(10000);
	
	CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

}
	public void AddProjectOtherUS(int rowNum, String sheetName) throws IOException, InterruptedException {

		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"Project Name" ,rowNum, "US Building Other"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "Project Name", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys( "ProjectName", prjName);
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog("Pass","Selecting Project Type as Buildings");
	
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
		CommonMethod.testlog("Pass","Selecting Ratings as LEED for Buildings");
		
		CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
		
		CommonMethod.selectdropdown( "OwnerType", ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		Thread.sleep(2000);
		CommonMethod.click( "OwnerOrg");
		
		CommonMethod.click( "ownerorg");
	//	Thread.sleep(1000);
	//	CommonMethod.testlog( "Pass", "Entering Owner Type");	
		
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");


	}
	public void AddProjectOtherIND() throws IOException, InterruptedException {

		clickAddProjectMyBuildings();
		CommonMethod.sendKeys( "ProjectName",
				"MachineTestProject" + " " + CommonMethod.randomNumber());
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.click("ProjectTypeBuildings");
		Thread.sleep(1000);
		//CommonMethod.click("ClickOnProjectType");
		CommonMethod.testlog( "Pass", "Click On PorjectType");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
		Thread.sleep(1000);
		CommonMethod.click("RatingSystemOther");
		CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
		Thread.sleep(1000);
		CommonMethod.click("RatingSystemOther");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Selecting RatingSystem Other");
		CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
		CommonMethod.sendKeys( "OwnerType", "Test Owner");
		CommonMethod.testlog( "Pass", "Entering Owner Type");
		CommonMethod.sendKeys( "OwnerOrg", "Test Org");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", "United States");
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", "10000");
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", "Test Address");
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", "India");
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", "Delhi");
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", "350054");
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(10000);

	}
	
	public void AddProjectParksmartUS(int rowNum, String sheetName) throws IOException, InterruptedException {

		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjParkNo 	= data.getCellData(sheetName, "no_park_space", rowNum);
		String prjParkLevel	= data.getCellData(sheetName, "park_level", rowNum);
		String prjDateComm 	= data.getCellData(sheetName, "date_comm", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"Project Name" ,rowNum, "USMyParking"+" " + CommonMethod.randomNumber() );
														   
		String prjName 	= data.getCellData(sheetName, "Project Name", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys("ProjectName", prjName);
				
		Thread.sleep(2000);
		
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
		CommonMethod.testlog( "Pass", "Selecting RatingSystem Parksmart");
		
		CommonMethod.selectdropdown( "OwnerType", ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		/*CommonMethod.moveToElement( "ownerorg");
		CommonMethod.click( "ownerorg");
		CommonMethod.FluentWait( "ownerorg");
		*/
		
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "NumParkingSpaces", prjParkNo);
	
		CommonMethod.testlog( "Pass", "Entering No. of parking spaces");
		
		CommonMethod.scrolldowntoElement( "NumParkinglevel");
		CommonMethod.sendKeys( "NumParkinglevel", prjParkLevel);
		CommonMethod.testlog( "Pass", "Entering No. of parking Level");
		
		CommonMethod.sendKeys( "DataCommisioned", prjDateComm);
		CommonMethod.testlog( "Pass", "Entering Year constructed");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country",prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		
		Thread.sleep(10000);


	}
	public void AddProjectParksmartIND() throws IOException, InterruptedException {

		clickAddProjectMyBuildings();
		CommonMethod.sendKeys( "ProjectName",
				"MachineTestProject" + " " + CommonMethod.randomNumber( ));
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.click("ProjectTypeBuildings");
		Thread.sleep(1000);
		//CommonMethod.click("ClickOnProjectType");
		CommonMethod.testlog( "Pass", "Click On PorjectType");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Buildings");
		Thread.sleep(1000);
		CommonMethod.click("ClickOnRatingSystem");
		Thread.sleep(1000);
		CommonMethod.click("RatingSystemParksmart");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Selecting RatingSystem Parksmart");
		CommonMethod.sendKeys( "OwnerType", "Test Owner");
		CommonMethod.testlog( "Pass", "Entering Owner Type");
		CommonMethod.sendKeys( "OwnerOrg", "Test Org");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", "United States");
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "NumParkingSpaces", "20");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Entering No. of parking spaces");
		CommonMethod.scrolldowntoElement( "NumParkinglevel");
		CommonMethod.sendKeys( "NumParkinglevel", "18");
		CommonMethod.testlog( "Pass", "Entering No. of parking Level");
		Thread.sleep(1000);
		CommonMethod.sendKeys( "DataCommisioned", "2015-02-04");
		CommonMethod.testlog( "Pass", "Entering Year constructed");
		CommonMethod.sendKeys( "Address", "Test Address");
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", "India");
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", "Delhi");
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", "350053");
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(10000);


	}
	
	
	
	
	public void AddProjectCitiesLEED(int rowNum, String  sheetName) throws IOException, InterruptedException {

		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"ProjectName" ,rowNum, "CitiesLeed"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys( "ProjectName", prjName);
		Thread.sleep(1000);
		
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Cities");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for transit");
	    
	    CommonMethod.selectdropdown( "OwnerType", ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
	
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		
		CommonMethod.sendKeys( "Occupancy", prjPopulation);
		CommonMethod.testlog( "Pass", "Entering Population");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.FluentWait("NextButton");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

	}
	
	public void AddProjectCitiesOTHER(int rowNum, String  sheetName) throws IOException, InterruptedException {

		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"ProjectName" ,rowNum, "CitiesOther"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys( "ProjectName", prjName);
		Thread.sleep(1000);
		
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Cities");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for transit");
	    
	    CommonMethod.selectdropdown( "OwnerType", ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
	
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		
		CommonMethod.sendKeys( "Occupancy", prjPopulation);
		CommonMethod.testlog( "Pass", "Entering Population");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.FluentWait("NextButton");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

	}
	
	public void AddProjectCitiesNONE(int rowNum, String  sheetName) throws IOException, InterruptedException {

		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"ProjectName" ,rowNum, "CitiesNone"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum);
		
		clickAddProjectMyBuildings();
		
		CommonMethod.sendKeys( "ProjectName", prjName);
		Thread.sleep(1000);
		
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Cities");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for transit");
	    
	    CommonMethod.selectdropdownrandom( "OwnerType");
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
	
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		
		CommonMethod.sendKeys( "Occupancy", prjPopulation);
		CommonMethod.testlog( "Pass", "Entering Population");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.FluentWait("NextButton");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");

	}

	public void AddProjectCommunitiesLEED(String sheetName, int rowNum) throws IOException, InterruptedException {

		
		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String ownerType	= data.getCellData(sheetName, "OwnerType", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"ProjectName" ,rowNum, "CommunityLeed"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum);
				
		clickAddProject();
				
		CommonMethod.sendKeys( "ProjectName", prjName);

		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Communities");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for Communities");
	    
	    CommonMethod.selectdropdown("OwnerType",ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
	
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		
		CommonMethod.sendKeys( "Occupancy", prjPopulation);
		CommonMethod.testlog( "Pass", "Entering Population");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.FluentWait("NextButton");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
        String[] splits = CommonMethod.getText("amountPayable").split(" ");
		String Amount= splits[0]+" "+splits[1];
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");
	}
	
	
	public void AddProjectCommunitiesOther(String sheetName, int rowNum) throws IOException, InterruptedException {

		
		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"ProjectName" ,rowNum, "CommunityOther"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum);
				
		clickAddProject();
				
		CommonMethod.sendKeys( "ProjectName", prjName);
		
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Communities");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as Communities Other");
	    
	    CommonMethod.selectdropdown( "OwnerType", ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
	
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		
		CommonMethod.sendKeys( "Occupancy", prjPopulation);
		CommonMethod.testlog( "Pass", "Entering Population");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		String Amount= splits[0]+" "+splits[1];
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");
	}
	
	
	public void AddProjectCommunitiesNone(int rowNum, String sheetName) throws IOException, InterruptedException {

		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);
		
		//creating the project name
		data.setCellData(sheetName,"ProjectName" ,rowNum, "CommunityNone"+" " + CommonMethod.randomNumber() );
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum);
				
		clickAddProject();
				
		CommonMethod.sendKeys( "ProjectName", prjName);
		
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.selectdropdown("ClickOnProjectType",prjType);
		CommonMethod.testlog( "Pass", "Selecting Project Type as Communities");
		
		CommonMethod.selectdropdown("ClickOnRatingSystem",prjRating);
	    CommonMethod.testlog( "Pass", "Selecting ratings as LEED for Communities");
	    
	    CommonMethod.selectdropdown( "OwnerType", ownerType);
		CommonMethod.testlog( "Pass", "Selecting Owner Type Type");
		
		CommonMethod.sendKeys( "OwnerOrg", ownerOrg);
		CommonMethod.click( "OwnerOrg");
		Thread.sleep(1000);
		CommonMethod.click( "ownerorg");
		CommonMethod.testlog( "Pass","Entering Owner Organization");
	
		CommonMethod.sendKeys( "OwnerEmail", ownerMail);
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		
		CommonMethod.selectdropdown( "OwnerCountry", ownerCountry);
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		
		CommonMethod.sendKeys( "Area", prjArea);
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		
		CommonMethod.sendKeys( "Occupancy", prjPopulation);
		CommonMethod.testlog( "Pass", "Entering Population");
		
		CommonMethod.sendKeys( "Address", prjAddress);
		CommonMethod.testlog( "Pass", "Entering Address");
		
		CommonMethod.sendKeys( "City", prjCity);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "Country", prjCountry);
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", prjState);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", prjZip);
		
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		
		
		String[] splits = CommonMethod.getText("amountPayable").split(" ");
		String Amount= splits[0]+" "+splits[1];
		data.setCellData(sheetName, "Amount" , rowNum, Amount );
		
		Thread.sleep(10000);
		
		CommonMethod.FluentWait("VerifyPaymentDone");
		CommonMethod.testlog( "Pass", "Project details filled");
	}
	
	/*public void AddProjectTransit() throws IOException, InterruptedException {

		clickAddProject();
		CommonMethod.sendKeys( "ProjectName",
				"MachineTestProject" + " " + CommonMethod.randomnumber( CommonMethod.ArcProjectIDUrl_transit));
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		CommonMethod.selectdropdownrandom( "SpaceType");
		CommonMethod.testlog( "Pass", "Selecting Space Type");
		CommonMethod.sendKeys( "OwnerType", "Test Owner");
		CommonMethod.testlog( "Pass", "Entering Owner Type");
		CommonMethod.sendKeys( "OwnerOrg", "Test Org");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", "United States");
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "Area", "10000");
		CommonMethod.testlog( "Pass", "Entering Gross Floor Area");
		CommonMethod.sendKeys( "Address", "Test Address");
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", "United States");
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", "Alabama");
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", "35005");
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(10000);

	}*/

	/*public void AddProjectParking() throws IOException, InterruptedException {

		clickAddProject();
		CommonMethod.sendKeys( "ProjectName",
				"MachineTestProject" + " " + CommonMethod.randomnumber( CommonMethod.ArcProjectIDUrl_parking));
		CommonMethod.testlog( "Pass", "Feeding Random Unique name for Project and saving to external location");
		//CommonMethod.selectdropdownrandom( "SpaceType");
		//CommonMethod.testlog( "Pass", "Selecting Space Type");
		CommonMethod.sendKeys( "OwnerType", "Test Owner");
		CommonMethod.testlog( "Pass", "Entering Owner Type");
		CommonMethod.sendKeys( "OwnerOrg", "Test Org");
		CommonMethod.testlog( "Pass", "Entering Owner Organization");
		CommonMethod.sendKeys( "OwnerEmail", "Test@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Owner Email");
		CommonMethod.selectdropdown( "OwnerCountry", "United States");
		CommonMethod.testlog( "Pass", "Entering Owner Country");
		CommonMethod.sendKeys( "NumParkingSpaces", "20");
		Thread.sleep(1000);
		CommonMethod.testlog( "Pass", "Entering No. of parking spaces");
		CommonMethod.scrolldowntoElement( "NumParkinglevel");
		CommonMethod.sendKeys( "NumParkinglevel", "18");
		CommonMethod.testlog( "Pass", "Entering No. of parking Level");
		Thread.sleep(1000);
		CommonMethod.sendKeys( "DataCommisioned", "2015-02-04");
		CommonMethod.testlog( "Pass", "Entering Year constructed");
		CommonMethod.sendKeys( "Address", "Test Address");
		CommonMethod.testlog( "Pass", "Entering Address");
		CommonMethod.sendKeys( "City", "Test City");
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "Country", "United States");
		CommonMethod.testlog( "Pass", "Entering Country");
		CommonMethod.selectdropdown( "State", "Alabama");
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "ZipCode", "35005");
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(10000);

	}
	*/
	public void RegformfieldvalidationParking() throws IOException, InterruptedException {

		clickAddProject();
		CommonMethod.click( "AgreeTermsProgReg");
		CommonMethod.testlog( "Pass", "Clicking on agree to terms");
		CommonMethod.click( "NextButton");
		CommonMethod.testlog( "Pass", "Clicking on Next button");
		Thread.sleep(1000);
		CommonMethod.Isdisplayed( "Required_ProjectName", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_OwnerType", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_OwnerOrg", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_OwnerEmail", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_Area", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_parkingspacesnumber", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_parkingspacesabove", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_parkingspacebelow", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_Datacommisioned", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_Address", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_City", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		CommonMethod.Isdisplayed( "Required_Zipcode", "Required Field message is not displayed for ProjectName, Is it hidden ?");
		Thread.sleep(1000);

	}

	public void PaymentbyCC(String Objectlocator, String successMessage, String sheetName, int rowNum)
			throws IOException, InterruptedException {

		/********************Fetching the data via Excel Sheet ******************************/
		
		String cardName   = data.getCellData(sheetName, "Card Name", rowNum);
		String cardNum    = data.getCellData(sheetName, "Card Number", rowNum);
		String cardDate   = data.getCellData(sheetName, "Date ", rowNum);
		String cardCvv    = data.getCellData(sheetName, "CVV", rowNum);
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		String amount     = data.getCellData(sheetName, "Amount", rowNum);
		
		CommonMethod.sendKeys( "CardName", cardName);
		CommonMethod.testlog( "Pass", "Entering CardName");
		CommonMethod.sendKeys( "CardNumber", cardNum);
		CommonMethod.testlog( "Pass", "Entering CardNumber 4012000010000");
		CommonMethod.sendKeys( "ExpirationDate", cardDate);
		CommonMethod.testlog( "Pass", "Entering Expiry Date");
		CommonMethod.sendKeys( "CvvNumber", cardCvv);
		CommonMethod.testlog( "Pass", "Entering CVV No. 999");
		
		CommonMethod.clear( "BillPartyName");
		CommonMethod.sendKeys( "BillPartyName", partyName);
		CommonMethod.testlog( "Pass", "Entering Bill Party name");
		
		CommonMethod.clear( "BillPartyEmail");
		CommonMethod.sendKeys( "BillPartyEmail", partyEmail);
		CommonMethod.testlog( "Pass", "Entering Bill Party Email");
		
		CommonMethod.clear( "BillAddress1");
		CommonMethod.sendKeys( "BillAddress1", address);
		CommonMethod.testlog( "Pass", "Entering Billing Address");
		// CommonMethod.sendKeys( "BillAddress2", "sample Address");
		
		CommonMethod.clear( "BillCity");
		CommonMethod.sendKeys( "BillCity", city);
		CommonMethod.testlog( "Pass", "Entering City");
		
		CommonMethod.selectdropdown( "BillCountry", country);
		CommonMethod.testlog( "Pass", "Entering Entering Country");
		CommonMethod.selectdropdown( "BillState", state);
		CommonMethod.testlog( "Pass", "Entering State");
		
		CommonMethod.clear( "BillZipCode");
		CommonMethod.sendKeys( "BillZipCode",zip);
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		
		CommonMethod.click( "NextButtonPayment");
		CommonMethod.testlog( "Pass", "Clicking on Next Button");
		
		/*String[] splits = CommonMethod.getText("amountPayable").split(" ");
		
		String Amount= splits[0]+" "+splits[1];
		
		data.setCellData(sheetName, "Amount" , rowNum, Amount );*/
		
		Thread.sleep(20000);
		CommonMethod.assertEqualsmessage( Objectlocator, successMessage,
				"Seems like Payment is not successful or its a timeout");
		CommonMethod.testlog( "Pass", "Validating Payment Success Message");

	}
	public void PaymentbyCheck(String Objectlocator, String successMessage, String sheetName, int rowNum)
			throws IOException, InterruptedException {
		
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		
/*
		CommonMethod.sendKeys( "BillPartyName", "Test Party Name");
		CommonMethod.testlog( "Pass", "Entering BillPartyName");
		CommonMethod.sendKeys( "Email", "saurav.amca@gmail.com");
		CommonMethod.testlog( "Pass", "Entering Email");
		CommonMethod.sendKeys( "Address", "Karnataka Bangalore");
		CommonMethod.testlog( "Pass", "Address");
		CommonMethod.sendKeys( "City", "Delhi");
		CommonMethod.testlog( "Pass", "Entering City");*/
		CommonMethod.sendKeys( "BillPartyName", partyName);
		CommonMethod.testlog( "Pass", "Entering Bill Party name");
		CommonMethod.sendKeys( "BillPartyEmail", partyEmail);
		CommonMethod.testlog( "Pass", "Entering Bill Party Email");
		CommonMethod.sendKeys( "BillAddress1", address);
		CommonMethod.testlog( "Pass", "Entering Billing Address");
		// CommonMethod.sendKeys( "BillAddress2", "sample Address");
		CommonMethod.sendKeys( "BillCity", city);
		CommonMethod.testlog( "Pass", "Entering City");
		CommonMethod.selectdropdown( "BillCountry", country);
		CommonMethod.testlog( "Pass", "Entering Entering Country");
		
		CommonMethod.selectdropdown( "BillState", state);
		CommonMethod.testlog( "Pass", "Entering State");
		CommonMethod.sendKeys( "BillZipCode", zip);
		CommonMethod.testlog( "Pass", "Entering Zipcode");
		CommonMethod.click( "NextButtonPayment");
		CommonMethod.testlog( "Pass", "Clicking on Next Button");
		Thread.sleep(20000);
		CommonMethod.assertEqualsmessage( Objectlocator, successMessage,
				"timeout");
		CommonMethod.testlog( "Info", "Validating Payment Success Message");
        
	}
	
	
	
}
