package com.arc.ReusableMethods;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsManage extends BaseClass{

	public static ExtentTest test;
	
	public void calcuateWeightedOccupancy( String sheetName, int rowNum) throws IOException, InterruptedException {

		String annual_ridership  = data.getCellData(sheetName, "TMAnnualRidership", rowNum);
		String full_time_staff  = data.getCellData(sheetName, "TFulltimestaff", rowNum);
		String average_time = data.getCellData(sheetName, "TAveragetime", rowNum);
		String Weekly_Operating_hours = data.getCellData(sheetName, "TWeeklyOperatinghours", rowNum);
		
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		Thread.sleep(3000);
		
		
		CommonMethod.moveToElement("TMAnnualRidership");
		CommonMethod.clear( "TMAnnualRidership");
		CommonMethod.sendKeys("TMAnnualRidership", annual_ridership);
		CommonMethod.click( "TMFullTimeStaff");
		Thread.sleep(3000);
		CommonMethod.testlog("Pass", "Entering Annual Ridership Value");
		
		CommonMethod.clear( "TMFullTimeStaff");
		CommonMethod.sendKeys("TMFullTimeStaff", full_time_staff);
		CommonMethod.click( "TMFullTimeStaff");
		Thread.sleep(3000);
		CommonMethod.testlog("Pass", "Entering Full time Staff deatils");
		
		CommonMethod.clear( "TMAverageTime");
		CommonMethod.sendKeys("TMAverageTime", average_time);
		CommonMethod.click( "TMAverageTime");
		Thread.sleep(3000);
		CommonMethod.testlog("Pass", "Entering Average time spend by staff");
		
		CommonMethod.clear( "TMWOpeartinghour");
		CommonMethod.sendKeys("TMWOpeartinghour", Weekly_Operating_hours);
		CommonMethod.click( "TMWOpeartinghour");
		Thread.sleep(3000);
		CommonMethod.testlog("Pass", "Entering opearting hours");
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		System.out.println("Fetching value");
	    String ridership = CommonMethod.getattributeValue("TMAnnualRidership");
		System.out.println(ridership);
		
		String full_time = CommonMethod.getattributeValue( "TMFullTimeStaff");
		System.out.println(full_time);
		
		String avg_time= CommonMethod.getattributeValue( "TMAverageTime");
		System.out.println(avg_time);
		
		String opartinghours=CommonMethod.getattributeValue( "TMWOpeartinghour");
		System.out.println(opartinghours);
	
		
		//Verifying all fetched data form the formula .
		Double dridership=Double.parseDouble(ridership);
		Double dfull_time=Double.parseDouble(full_time);
		Double davg_time =Double.parseDouble(avg_time);
		Double dopartinghours =Double.parseDouble(opartinghours);
		Thread.sleep(1000);
		long CWeightedOccupancy = Math.round((dfull_time+ ( dridership/365 * davg_time/60 )/(dopartinghours/2)));
		
		//Converting long to string 
		String CalOccpancy = Long.toString(CWeightedOccupancy);	
		String AWeightedOccupancy = CommonMethod.getattributeValue("TMWeightedOccpancy");
		System.out.println(AWeightedOccupancy);	
		Assert.assertEquals(AWeightedOccupancy,CalOccpancy);   
		CommonMethod.testlog( "Pass", "Verified Weighted Daily Occupancy with all calcation");	
		Thread.sleep(2000);		

	}

	public void projectFieldDisplayed() throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		
		CommonMethod.Isdisplayed( "M_ProjectID", "Field Not visible");
		
	
		CommonMethod.Isdisplayed( "M_Address", "Field Not visible");
		CommonMethod.Isdisplayed( "M_City", "Field Not visible");
		CommonMethod.Isdisplayed( "M_State", "Field Not visible");
		CommonMethod.Isdisplayed( "M_Country", "Field Not visible");
		
	

		CommonMethod.Isdisplayed( "M_OwnerOrg", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OwnerEmail", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OwnerCountry", "Field Not visible");
		
	/*	CommonMethod.Isdisplayed( "M_PLC", "Field Not visible");
		CommonMethod.Isdisplayed( "M_CertifiedProg", "Field Not visible");
		CommonMethod.Isdisplayed( "M_ResidentialUnit", "Field Not visible");
		CommonMethod.Isdisplayed( "M_ProjectAffiliated", "Field Not visible");
		CommonMethod.Isdisplayed( "M_YearBuilt", "Field Not visible");
		CommonMethod.Isdisplayed( "M_FloorAboveGrounds", "Field Not visible");
		CommonMethod.Isdisplayed( "M_IntendPreCertify", "Field Not visible");
		CommonMethod.Isdisplayed( "M_GrossArea", "Field Not visible");
		CommonMethod.Isdisplayed( "M_TargetCertification", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OperatingHours", "Field Not visible");
		CommonMethod.Isdisplayed( "M_Occupancy", "Field Not visible");*/
		CommonMethod.testlog( "Pass", "Validating if all readable fields are visible in Project Manage page");

	}
	public void uploadImageParking() throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle("ParkMeasures");
		CommonMethod.click( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		CommonMethod.sendKeys("ParkPdfUpload", CommonMethod.parkImageUpload);
		//CommonMethod.WaitUntilInVisibility("ImageLoader");
		CommonMethod.Isdisplayed("FileUploadVerifyImage", "File Not Uploaded");
		Thread.sleep(5000);
		CommonMethod.testlog( "Pass","Parking image 1 file Uploaded successfully");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		CommonMethod.displayhiddenElement("ParkPdfUpload");
		CommonMethod.sendKeys("ParkPdfUpload", CommonMethod.parkImageUpload);
		CommonMethod.WaitUntilInVisibility("ImageLoader");
		Thread.sleep(5000);
		CommonMethod.testlog( "Pass","Parking image 2 file Uploaded successfully");
		
	}
	public void projectFieldDisplayedParking() throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle("ParkMeasures");
		CommonMethod.click( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		CommonMethod.Isdisplayed( "M_PName", "Field Not visible");
		CommonMethod.Isdisplayed( "M_ProjectID", "Field Not visible");
		CommonMethod.Isdisplayed( "M_RegistrationDate", "Field Not visible");
		CommonMethod.Isdisplayed( "M_Address", "Field Not visible");
		CommonMethod.Isdisplayed( "M_City", "Field Not visible");
		CommonMethod.Isdisplayed( "M_State", "Field Not visible");
		CommonMethod.Isdisplayed( "M_Country", "Field Not visible");
		
		CommonMethod.Isdisplayed( "M_Private", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OwnerType", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OwnerOrg", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OwnerEmail", "Field Not visible");
		CommonMethod.Isdisplayed( "M_OwnerCountry", "Field Not visible");
		CommonMethod.Isdisplayed( "M_DateCommisioned", "Field Not visible");
		CommonMethod.Isdisplayed( "M_NumberParkingspaces", "Field Not visible");
		CommonMethod.Isdisplayed( "M_NumberParkingLevels", "Field Not visible");
		CommonMethod.Isdisplayed( "M_PLC", "Field Not visible");
		CommonMethod.Isdisplayed( "M_ProjectWebsite", "Field Not visible");
		CommonMethod.Isdisplayed( "M_Feedback","Field Not visible");
		CommonMethod.Isdisplayed( "M_FileUpload","Field Not visible");
		CommonMethod.testlog( "Pass", "Validating if all fields are visible in Project page");

	}
	public void VerifyProjectDetailsCity( String sheetName, int rowNum) throws IOException, InterruptedException {

		
		String ProjectName     = data.getCellData(sheetName, "ProjectName", rowNum);
		String Address       = data.getCellData(sheetName, "Address", rowNum);
		String City       = data.getCellData(sheetName, "City", rowNum);
		String State       = data.getCellData(sheetName, "State", rowNum);
		String Country     = data.getCellData(sheetName, "Country", rowNum);
		String own_org     = data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String own_email   = data.getCellData(sheetName, "OwnerEmail", rowNum);
		String own_country    = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String gross_area  = data.getCellData(sheetName, "editArea", rowNum);
		String Population   = data.getCellData(sheetName, "Population", rowNum);
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		System.out.println(CommonMethod.getattributeValue( "M_ProjectID_value"));
		CommonMethod.assertEqualsmessageAttributevalue( "M_ProjectName_value", ProjectName,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Address_value", Address,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_City_value", City, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_State_value", State, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Country_value", Country,
				"Value is not correct");
		//CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerType_value", "T & W Corporation","Value is not correct");
		
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerOrg_value", own_org, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerEmail_value", own_email,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerCountry_value", own_country,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_GrossArea_value", gross_area, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Occupancy_value", Population, "Value is not correct");
		CommonMethod.testlog( "Pass", "Verifying project details field present on Project details page");

	}
	
public void VerifyProjectDetails( String sheetName, int rowNum) throws IOException, InterruptedException {

		
		String address     = data.getCellData(sheetName, "Address", rowNum);
		String city        = data.getCellData(sheetName, "City", rowNum);
		String state       = data.getCellData(sheetName, "State", rowNum);
		String country     = data.getCellData(sheetName, "Country", rowNum);
		String own_org     = data.getCellData(sheetName, "Owner Organization", rowNum);
		String own_email   = data.getCellData(sheetName, "Owner Email", rowNum);
		String own_con     = data.getCellData(sheetName, "Owner Country", rowNum);
		String gross_area  = data.getCellData(sheetName, "Area", rowNum);
		String opr_hrs     = data.getCellData(sheetName, "opr_hrs2", rowNum);
		String occupancy   = data.getCellData(sheetName, "occupancy", rowNum);
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		System.out.println(CommonMethod.getattributeValue( "M_ProjectID_value"));
		CommonMethod.assertEqualsmessageAttributevalue( "M_Address_value", address,"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_City_value", city, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_State_value", state, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Country_value", country,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerOrg_value", own_org, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerEmail_value", own_email,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerCountry_value", own_con,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_GrossArea_value", gross_area, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OperatingHours_value", opr_hrs, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Occupancy_value", occupancy, "Value is not correct");
		CommonMethod.testlog( "Pass", "Verifying project details field present on Project details page");

	}
	
public void VerifyProjectDetailsTransit( String sheetName, int rowNum) throws IOException, InterruptedException {

		
		String address     = data.getCellData(sheetName, "Address", rowNum);
		String city        = data.getCellData(sheetName, "City", rowNum);
		String state       = data.getCellData(sheetName, "State", rowNum);
		String country     = data.getCellData(sheetName, "Country", rowNum);
		String own_org     = data.getCellData(sheetName, "Owner Organization", rowNum);
		String own_email   = data.getCellData(sheetName, "Owner Email", rowNum);
		String own_con     = data.getCellData(sheetName, "Owner Country", rowNum);
		String gross_area  = data.getCellData(sheetName, "Area", rowNum);
		String opr_hrs     = data.getCellData(sheetName, "opr_hrs2", rowNum);
		String occupancy   = data.getCellData(sheetName, "occupancy", rowNum);
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		System.out.println(CommonMethod.getattributeValue( "M_ProjectID_value"));
		CommonMethod.assertEqualsmessageAttributevalue( "M_Address_value", address,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_City_value", city, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_State_value", state, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Country_value", country,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerOrg_value", own_org, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerEmail_value", own_email,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerCountry_value", own_con,
				"Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_GrossArea_value", gross_area, "Value is not correct");
		CommonMethod.testlog( "Pass", "Verifying project details field present on Project details page");

	}
	
public void VerifyProjectDetailsParking() throws IOException, InterruptedException {
	CommonMethod.ArcSpecifictoggle("ParkMeasures");
	CommonMethod.click( "Manage");
	CommonMethod.click( "Project");
	CommonMethod.testlog( "Pass", "Clicking on Project");
    CommonMethod.testlog("Pass","Verifying registered address , city ,country , owner details , data commissioned fields");
	
	CommonMethod.assertEqualsmessageAttributevalue( "M_Address_value", "2101 L St NW #500",
			"Value is not correct");
	
	CommonMethod.assertEqualsmessageAttributevalue( "M_City_value", "Washington", "Value is not correct");
	CommonMethod.assertEqualsmessageAttributevalue( "M_State_value", "Alabama", "Value is not correct");
	CommonMethod.assertEqualsmessageAttributevalue( "M_Country_value", "United States",
			"Value is not correct");
	CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerOrg_value", "T & H Engineering, Inc.", "Value is not correct");
	CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerEmail_value", "ssinha@usgbc.org","Value is not correct");
	CommonMethod.assertEqualsmessageAttributevalue( "M_OwnerCountry_value", "United States",
			"Value is not correct");
	CommonMethod.assertEqualsmessageAttributevalue( "M_DataCommisioned_value", "2015-02-04", "Value is not correct");
	CommonMethod.testlog("Pass","Verified entered address , city ,country , owner details , data commissioned successfully");
}

	public void editProjectDetails( String sheetName, int rowNum) throws IOException, InterruptedException {

		String opr_hrs1  = data.getCellData(sheetName, "opr_hrs1", rowNum);
		String opr_hrs2  = data.getCellData(sheetName, "opr_hrs2", rowNum);
		String occupancy = data.getCellData(sheetName, "occupancy", rowNum);
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		
		CommonMethod.clear( "M_OperatingHours_value");
		CommonMethod.clear( "M_Occupancy_value");
		
		CommonMethod.testlog("Pass", "Test case 1 verify Occupancy field should not save more than 3 digit ");	
		CommonMethod.sendKeys( "M_OperatingHours_value", opr_hrs1);
		CommonMethod.click( "M_Occupancy_value");
		Thread.sleep(2000);
		String opeatinghour = CommonMethod.getText("M_OperatingHours_value");
		Assert.assertEquals(opeatinghour,"");
		CommonMethod.testlog("Pass", "Test passed verified opeating hours not saveing more than 3 digit");
		
		CommonMethod.clear( "M_OperatingHours_value");
		CommonMethod.sendKeys( "M_OperatingHours_value", opr_hrs2);
		Thread.sleep(1000);
		CommonMethod.click( "M_Occupancy_value");
		Thread.sleep(2000);
		
	
		CommonMethod.sendKeys( "M_Occupancy_value", occupancy);
		CommonMethod.click( "M_Occupancy_value");
		Thread.sleep(2000);
		CommonMethod.testlog( "Pass", "Sended opeating hours correct value");
		Thread.sleep(1000);
		
		CommonMethod.click( "M_OperatingHours_value");
		CommonMethod.testlog( "Pass", "Saving Project details by clicking outside");
		Thread.sleep(3000);
		CommonMethod.assertEqualsmessageAttributevalue( "M_OperatingHours_value", opr_hrs2, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Occupancy_value", occupancy, "Value is not correct");
		CommonMethod.testlog( "Pass", "Verified Opeating hours & Occupancy project details");

	}
	
	public void editProjectDetailsCity( String sheetName, int rowNum) throws IOException, InterruptedException {

		String editArea  = data.getCellData(sheetName, "editArea", rowNum);
		String editPopulation  = data.getCellData(sheetName, "editPopulation", rowNum);
		
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		
		CommonMethod.clear( "M_GrossArea_value");
		CommonMethod.clear( "M_Occupancy_value");
		
		
		CommonMethod.sendKeys( "M_GrossArea_value", editArea);
		Thread.sleep(1000);
		CommonMethod.click( "M_GrossArea_value");
		Thread.sleep(2000);
		
	
		CommonMethod.sendKeys( "M_Occupancy_value", editPopulation);
		CommonMethod.click( "M_Occupancy_value");
		Thread.sleep(2000);
		CommonMethod.testlog( "Pass", "Area and Population field edited");
		Thread.sleep(1000);
		
		CommonMethod.assertEqualsmessageAttributevalue( "M_GrossArea_value", editArea, "Value is not correct");
		CommonMethod.assertEqualsmessageAttributevalue( "M_Occupancy_value", editPopulation, "Value is not correct");
		CommonMethod.testlog( "Pass", "Verified Area and population is saving after editing");

	}
	public void editProjectDetailsParking(String sheetName, int rowNum) throws IOException, InterruptedException {
		
		CommonMethod.ArcSpecifictoggle("ParkMeasures");
		CommonMethod.click( "Manage");
		CommonMethod.click( "Project");
		CommonMethod.testlog( "Pass", "Clicking on Project");
		Thread.sleep(2000);
		
	    CommonMethod.clear("NoOfParkingSpace");
		CommonMethod.sendKeys("NoOfParkingSpace","50");
		CommonMethod.click("NoOfParkingLevel");
		Thread.sleep(1000);
		
		CommonMethod.clear("NoOfParkingLevel"); 
		CommonMethod.sendKeys("NoOfParkingLevel","50");
		CommonMethod.click("NoOfParkingSpace");
		Thread.sleep(1000);
		
		CommonMethod.clear("M_InputWebSite");
		CommonMethod.sendKeys("M_InputWebSite","http://www.parking-net.com");
		CommonMethod.click("M_Inputdetails");
		Thread.sleep(1000);
		
		CommonMethod.clear("M_Inputdetails");
		CommonMethod.sendKeys("M_Inputdetails","When assigned parking is provided, designated accessible parking .");
	    CommonMethod.click("NoOfParkingLevel");
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		CommonMethod.testlog("Pass","Verifying edited functionlity for no of parking space , level , website , about parking fields after refresh");
		
		CommonMethod.assertcontainsattributevalue("NoOfParkingSpace","50"," Not Correct");
		CommonMethod.assertcontainsattributevalue("NoOfParkingLevel","50"," Not Correct");
		CommonMethod.assertcontainsattributevalue("M_InputWebSite","http://www.parking-net.com"," Not Correct");
		CommonMethod.assertcontainsattributevalue("M_Inputdetails","When assigned parking is provided, designated accessible parking ."," Not Correct");
		CommonMethod.testlog("Pass","Verifying edited functionlity for no of parking space , level , website , about parking fields after refresh");
		
		

	}


	public void AddTeamMember( String sheetName, int rowNum) throws IOException, InterruptedException {

		String team_mail = data.getCellData(sheetName, "Team_mail", rowNum);
		
		//CommonMethod.ArcSpecifictoggle( "CreditAction");
		CommonMethod.ArcSpecifictoggle( "Manage");
		//CommonMethod.click("Manage");
		//CommonMethod.scrolldowntoElement("Team");
		CommonMethod.click( "Team");
		CommonMethod.testlog( "Pass", "Clicking on Team");
		CommonMethod.sendKeys( "TeamMemberEmail", team_mail);
		CommonMethod.testlog( "Pass", "Adding team member pkamal@usgbc.org");
		CommonMethod.click( "AddMemberButton");
		CommonMethod.testlog( "Pass", "Clicking on Add button");
		Thread.sleep(3000);
		CommonMethod.assertEqualsmessage( "InfoMessage", "Team member added successfully.",
				"something went wrong");
		CommonMethod.testlog( "Pass", "Verifying if team member is added successfully");

	}

	public void EditTeamMemberRole( String role) throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.click("Manage");
		//CommonMethod.scrolldowntoElement("Team");
		CommonMethod.click( "Team");
		CommonMethod.testlog( "Pass", "Clicking on Team");
		CommonMethod.click( "EditButtonTeamMember");
		CommonMethod.testlog( "Pass", "Clicking on Edit role team member");
		
		Thread.sleep(1000);
	
		CommonMethod.selectdropdown( "AuthorizationLevel", role);
		
		CommonMethod.testlog( "Pass", "Selecting role");
		Thread.sleep(1000);
		CommonMethod.FluentWait( "SaveButtonTeamMember");
		CommonMethod.moveToElement("SaveButtonTeamMember");
		CommonMethod.click( "SaveButtonMeter");
		Thread.sleep(6000);
		CommonMethod.testlog( "Pass", "Clicking on save button");
		Assert.assertEquals(CommonMethod.getText("teamAuthLevel"), "Team Manager","Team Authourization Not Changed");
		CommonMethod.testlog( "Pass", "Verifying team member role is updated");
	}

	public void VerifyFileDownload( String filename) throws IOException, InterruptedException {
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Agreements");
		CommonMethod.click( "Agreements");
		Thread.sleep(1000);
		CommonMethod.click( "DownloadFilebutton");

		Thread.sleep(10000);
		CommonMethod.VerifyDownloadWithFileName(filename);
		CommonMethod.testlog("Pass","Downloaded Sign Argeement successfully");

	}
	public void verifyDownloadPRPdf() throws IOException, InterruptedException {

		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.click( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		Thread.sleep(1000);
		CommonMethod.click( "DownloadBilling");
		Thread.sleep(10000);
		CommonMethod.VerifyDownloadWithFileName(CommonMethod.getText("BillOrderId")+".pdf");
		Thread.sleep(5000);
		System.out.println("File Downloaded Successully");
		CommonMethod.testlog( "Pass", "Downloaded Billing Pdf Successfully");
		
		

	}
	public void ClickManage() throws IOException {

		CommonMethod.click( "Manage");
		CommonMethod.testlog( "Pass", "Clicking on Manage");

	}

	public void CertificationStatus() throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Certifications");
		CommonMethod.click( "Certifications");
		CommonMethod.testlog( "Pass", "Clicking on Certification");
		CommonMethod.assertEqualsmessage( "certStatus", "Pending", "Certification Status is not correct");
		CommonMethod.testlog( "Pass", "Verifying Certification status is correct");

	}

	public void InstallApps() throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Apps");
		CommonMethod.testlog( "Pass", "Clicking on Apps");
		CommonMethod.click( "Apps");
		Assert.assertEquals(CommonMethod.getText("EnergyInstallCheck"),"Installed", "App Not Installed");
		Thread.sleep(2000);
		CommonMethod.click( "DropBox");
		CommonMethod.testlog( "Pass", "Installing Dropbox");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("DropboxInstallCheck"),"Installed", "App Not Installed");
		CommonMethod.click( "OneDrive");
		CommonMethod.testlog( "Pass", "Installing OneDrive");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("OneDriveInstallCheck"),"Installed", "App Not Installed");
		CommonMethod.click( "GoogleDrive");
		CommonMethod.testlog( "Pass", "Installing GoogleDrive");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("GoogleInstallCheck"),"Installed", "App Not Installed");
		CommonMethod.testlog( "Pass", "Verifying if apps are installed successfully");
		Thread.sleep(5000);

	}

	public void InstallAppsCustom() throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Apps");
		CommonMethod.testlog( "Pass", "Clicking on Apps");
		CommonMethod.click( "Apps");
		CommonMethod.click( "DropBox");
		CommonMethod.testlog( "Pass", "Installing Dropbox");
		CommonMethod.click( "OneDrive");
		CommonMethod.testlog( "Pass", "Installing OneDrive");
		CommonMethod.click( "GoogleDrive");
		CommonMethod.testlog( "Pass", "Installing GoogleDrive");
		CommonMethod.testlog( "Pass", "Verifying if apps are installed successfully");
		Thread.sleep(5000);

	}

	public void verifyBillingDate() throws IOException, InterruptedException {

		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String Month = new SimpleDateFormat("MMM").format(cal.getTime());
		String Curdate = dateFormat.format(date);
		int Year = Calendar.getInstance().get(Calendar.YEAR);
		CommonMethod.ArcSpecifictoggle("ParkMeasures");
		CommonMethod.click( "Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		CommonMethod.click( "Billing");
		System.out.println(Month + " " + Curdate + ", " + Year);
		CommonMethod.assertEqualsmessage( "BillingDate", Month + " " + Curdate + ", " + Year,
				"Billing Date is not correct in Billing page");
		CommonMethod.testlog( "Pass", "Verifying Billing date is correct");
	}
	public void verifyParkingRegAmount( String sheetName, int rowNum) throws IOException, InterruptedException {

		/** Reading data from excel **/
		String parkingregamount = data.getCellData(sheetName, "Parking Registration Amount", rowNum);
		System.out.println(parkingregamount);
		CommonMethod.ArcSpecifictoggle("ParkMeasures");
		CommonMethod.click( "Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.click( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		CommonMethod.assertcontainsmessage( "TotalAmountReg", parkingregamount,
				"Registration Amount is not correct in Billing page");
		CommonMethod.testlog( "Pass", "Verifying Registration amount is correct");
		Thread.sleep(4000);
	}

	public void verifyRegAmount( String sheetName, int rowNum) throws IOException, InterruptedException {

		/** Reading data from excel **/
		String amount = data.getCellData(sheetName, "Amount", rowNum);
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.click( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		CommonMethod.assertEqualsmessage( "TotalAmountReg", amount,
				"Registration Amount is not correct in Billing page");
		CommonMethod.testlog( "Pass", "Verifying Registration amount is correct");
	}
	
	public void verifyRegAmountparking(int rowNum, String sheetName) throws IOException, InterruptedException {

		String amount = data.getCellData(sheetName, "Amount", rowNum);
		
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.click( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		CommonMethod.assertcontainsmessage( "TotalAmountRegParking", amount,
				"Registration Amount is not correct in Billing page");
		CommonMethod.testlog( "Pass", "Verifying Registration amount is correct");
	}

	public void verifyBillingStatus() throws IOException, InterruptedException {

		CommonMethod.ArcSpecifictoggle("ParkMeasures");
		CommonMethod.click( "Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.click( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		CommonMethod.assertEqualsmessage( "BillingStatus", "Completed",
				"Billing Status is not correct in Billing page");
		CommonMethod.testlog( "Pass", "Verifying billing status is correct");
	}
	public void UninstallApps() throws IOException, InterruptedException {
		CommonMethod.ArcSpecifictoggle( "Manage");
		CommonMethod.scrolldowntoElement( "Apps");
		CommonMethod.testlog( "Pass", "Clicking on Apps To Unistall");
		CommonMethod.click( "Apps");
		CommonMethod.click( "EnergyStar");
		CommonMethod.testlog( "Pass", "Uninstalling EnergyStar");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("EnergyUnInstallCheck"),"Install", "App Not Installed"); 
		CommonMethod.click( "DropBox");
		CommonMethod.testlog( "Pass", "Uninstalling Dropbox");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("DropboxUnInstallCheck"),"Install", "App Not Installed");
		CommonMethod.click( "OneDrive");
		CommonMethod.testlog( "Pass", "Unistalling OneDrive");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("OneDriveUnInstallCheck"),"Install", "App Not Installed");
		CommonMethod.click( "GoogleDrive");
		CommonMethod.testlog( "Pass", "Unistalling GoogleDrive");
		Thread.sleep(2000);
		Assert.assertEquals(CommonMethod.getText("GoogleUnInstallCheck"),"Install", "App Not Installed");
		CommonMethod.testlog( "Pass", "Verifying if apps are Uninstalled successfully");
		Thread.sleep(5000);

	}
}
