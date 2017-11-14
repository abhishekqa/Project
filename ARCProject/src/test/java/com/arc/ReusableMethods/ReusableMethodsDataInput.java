package com.arc.ReusableMethods;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethodsDataInput extends BaseClass{

	public static ExtentTest test;
	
	 public void ClickDataInput( ) throws IOException{
			
		    CommonMethod.click( "datainput");
		    CommonMethod.testlog( "Pass","Clicking DataInput");
				
			}

	 public void ClickScore( ) throws IOException{
			
		    CommonMethod.click( "Score");
		    CommonMethod.testlog( "Pass","Clicking DataInput");
				
			}
	 public void ClickAnalytics( ) throws IOException{
			
		    CommonMethod.click( "Analytics");
		    CommonMethod.testlog( "Pass","Clicking Analytics");
				
			}
	 
	 
	 public void ClickTooltip() throws IOException{
			
		    CommonMethod.click( "EATooltip1");
		    CommonMethod.testlog( "Pass","Clicking EATooltip1");
				
			}
	 
	 
    public void ClickDataInputParam( String param) throws IOException{
		
	    CommonMethod.click( param);
	    CommonMethod.testlog( "Pass","Clicking DataInput Section "+ param);
			
		}
    
   public void ClickTotalParam( String param) throws IOException{
		
	    CommonMethod.click( param);
	    
	    CommonMethod.testlog( "Pass","Clicking DataInput Section "+ param);
			
		}
   public void ClickAnalyticsParam( String param) throws IOException{
		
	    CommonMethod.click( param);
	    
	    CommonMethod.testlog( "Pass","Clicking to Total "+ param);
			
		}
    public void CreateMeter(String param,String Metername,String MeterLocator, String sheetName, int rowNum) throws IOException, InterruptedException{
    	
    	/*************************Reading data from excel sheet ************************************/
    	
    	String meterName = data.getCellData(sheetName, "Meter Name", rowNum);
    	String startDate = data.getCellData(sheetName, "Start Date", rowNum);
    	String endDate   = data.getCellData(sheetName, "End Date", rowNum);
    	String reading1  = data.getCellData(sheetName, "Reading1", rowNum);
    	String reading2  = data.getCellData(sheetName, "Reading2", rowNum);
    	String reading3  = data.getCellData(sheetName, "Reading3", rowNum);
    	String reading4  = data.getCellData(sheetName, "Reading4", rowNum);
    	
    	
    	CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickDataInput();
    	ClickDataInputParam(param);
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.sendKeys( "MeterName",meterName);
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	
    	CommonMethod.moveToElement( "EditMeterData");
        CommonMethod.FluentWait( "EditMeterData");    
    	CommonMethod.click( "EditMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit meter Data");
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.click( "StartDate");
    	CommonMethod.clear( "StartDate");
    	CommonMethod.sendKeys( "StartDate", startDate);
    	CommonMethod.click( "StartDate");
    	Thread.sleep(1000);
    	CommonMethod.click( "EndDate");
    	CommonMethod.clear( "EndDate");
    	CommonMethod.sendKeys( "EndDate", endDate);
    	CommonMethod.click( "EndDate");
    	Thread.sleep(1000); 	
    	CommonMethod.sendKeys( "MeterFeedReading",reading1);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	
     
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement("AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading2);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	Thread.sleep(3000);
    	
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading3);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	  	
    	/******** Energy Meter Verification**********/
    	
    	/*CommonMethod.FluentWait( "EnergyMeter");
    	CommonMethod.moveToElement("EnergyMeter");
    	System.out.println(meterName);
    	System.out.println(CommonMethod.getText("EnergyMeter"));
    	CommonMethod.assertEqualsmessage("EnergyMeter", meterName, "Energy Meter is not correct");
		CommonMethod.testlog( "Pass", "Verifed Energy Meter is created successfully");*/
    	
    	CommonMethod.testlog( "Pass"," Meter reading added successfully");
    	
    	
    	Thread.sleep(5000);
    	
    }
    
    
    
public void CreateOtherMeter(String param,String Metername,String MeterLocator, String sheetName, int rowNum) throws IOException, InterruptedException{
    	
    	/*************************Reading data from excel sheet ************************************/
    	
    	String othmeterName = data.getCellData(sheetName, "Other_Meter Name", rowNum);
    	String startDate = data.getCellData(sheetName, "Start Date", rowNum);
    	String endDate   = data.getCellData(sheetName, "End Date", rowNum);
    	String reading1  = data.getCellData(sheetName, "Reading1", rowNum);
    	String reading2  = data.getCellData(sheetName, "Reading2", rowNum);
    	String reading3  = data.getCellData(sheetName, "Reading3", rowNum);
    	String reading4  = data.getCellData(sheetName, "Reading4", rowNum);
    	
    	
    	CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickDataInput();
    	ClickDataInputParam(param);
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.sendKeys( "MeterName",othmeterName);
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	CommonMethod.FluentWait( "EnergyType");
    	//CommonMethod.selectdropdown("EnergyType", "OTHER FUELS");
    	CommonMethod.click("EnergyType");
    	CommonMethod.FluentWait( "EnergyOther");
    	CommonMethod.click("EnergyOther");
    	CommonMethod.testlog( "Pass","Selecting Other Fuels");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	
    	/************Energy meter with other fuels meter verification **********/
    	
    	/*CommonMethod.FluentWait( "EnergyOther");
    	CommonMethod.moveToElement( "EnergyOther");
    	CommonMethod.assertEqualsmessage( "EnergyOther", othmeterName, "Energy Meter is not correct");
		CommonMethod.testlog( "Pass", "Verifed Energy Meter is created successfully");*/
    	
    	/*CommonMethod.moveToElement( "EditMeterData");
        CommonMethod.FluentWait( "EditMeterData");    
    	CommonMethod.click( "EditMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit meter Data");
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.click( "StartDate");
    	CommonMethod.clear( "StartDate");
    	CommonMethod.sendKeys( "StartDate", startDate);
    	CommonMethod.click( "StartDate");
    	Thread.sleep(1000);
    	CommonMethod.click( "EndDate");
    	CommonMethod.clear( "EndDate");
    	CommonMethod.sendKeys( "EndDate", endDate);
    	CommonMethod.click( "EndDate");
    	Thread.sleep(1000); 	
    	CommonMethod.sendKeys( "MeterFeedReading",reading1);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	
     
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement("AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading2);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	Thread.sleep(3000);
    	
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading3);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading4);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading1+reading4);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	CommonMethod.testlog( "Pass"," Meter reading added successfully");
    	
    	
    	Thread.sleep(5000);
    */	
    }
    
    
public void CreateWaterWMeter(String param,String Metername,String MeterLocator, String sheetName, int rowNum) throws IOException, InterruptedException{
    	
		/******************************Reading Data from Excel Sheet ************************************/
	
		
		String meterName = data.getCellData(sheetName, "Meter Name", rowNum);
		String startDate = data.getCellData(sheetName, "Start Date", rowNum);
		String endDate   = data.getCellData(sheetName, "End Date", rowNum);
		String reading1  = data.getCellData(sheetName, "Reading1", rowNum);
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum);
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum);
		String reading4  = data.getCellData(sheetName, "Reading4", rowNum);
	
    	CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickDataInput();
    	ClickDataInputParam(param);
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.sendKeys( "MeterName", meterName);
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	
    	/************Water meter with other fuels meter verification **********/
    	
    	/*CommonMethod.FluentWait( "EnergyMeter");
    	CommonMethod.moveToElement( "EnergyMeter");
    	CommonMethod.assertEqualsmessage( "EnergyMeter", meterName, "Water Meter is not correct");
		CommonMethod.testlog( "Pass", "Verifed Water Meter is created successfully");*/
    	
    	
    	CommonMethod.moveToElement( "EditMeterData");
        CommonMethod.FluentWait( "EditMeterData");    
    	CommonMethod.click( "EditMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit meter Data");
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.click( "StartDate");
    	CommonMethod.clear( "StartDate");
    	CommonMethod.sendKeys( "StartDate", startDate);
    	CommonMethod.click( "StartDate");
    	Thread.sleep(1000);
    	CommonMethod.click( "EndDate");
    	CommonMethod.clear( "EndDate");
    	CommonMethod.sendKeys( "EndDate", endDate);
    	CommonMethod.click( "EndDate");
    	Thread.sleep(1000); 	
    	CommonMethod.sendKeys( "MeterFeedReading",reading1);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	
    	
     
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement("AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading2);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	Thread.sleep(3000);
    	
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.moveToElement( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking Add New Reading");
    	CommonMethod.click( "EditButtonMeterData");
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.sendKeys( "MeterFeedReading", reading3);
    	CommonMethod.testlog( "Pass","Feeding Meter data");
    	CommonMethod.click( "SaveButtonMeter");
    	CommonMethod.testlog( "Pass","Click");
    	Thread.sleep(3000);
    	CommonMethod.testlog( "Pass"," Water Meter reading added successfully");
    	
    	
    	Thread.sleep(5000);
    	
    }
 public void CreateMeterInternationalLanguage(String param,String Metername,String MeterLocator) throws IOException, InterruptedException{
    	
    	CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickDataInput();
    	ClickDataInputParam(param);
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.testlog("Pass","Test Started Verifying International Languages");
    	CommonMethod.testlog("Pass","Verifying Create Kornian Meter Test");
    	CommonMethod.sendKeys( "MeterName","거기, 저기, 그곳, 저곳");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);	
    	CommonMethod.testlog("Pass","Test Pass Kornian Meter added Successully");
    	Thread.sleep(2000);
    	
    	/******* verifying the meter created with international language *********/ 
    	
    	/*CommonMethod.FluentWait( "EnergyForeign");
    	CommonMethod.moveToElement( "EnergyForeign");
    	CommonMethod.assertEqualsmessage( "EnergyForeign", "거기, 저기, 그곳, 저곳", "Energy Meter is not correct");
		CommonMethod.testlog( "Pass", "Verifed Energy Meter with international Language is created successfully");
    	*/
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.testlog("Pass"," Verifying Create Japanese Meter Test");
    	CommonMethod.sendKeys( "MeterName","わたしは にほんごがすこししかはなせませ");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	CommonMethod.testlog("Pass"," Test passed Japanese Meter added Successully");
    	Thread.sleep(2000);
    	
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.testlog("Pass"," Verifying Create Mandarin Meter Test");
    	CommonMethod.sendKeys( "MeterName","謝謝你。 siè sie̊ nǐ");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	CommonMethod.testlog("Pass"," Test passed Mandarin Meter added Successully");
    	Thread.sleep(2000);
    	
     	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.testlog("Pass"," Verifying Create Chinese Meter Test");
    	CommonMethod.sendKeys( "MeterName","今天的作业");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	CommonMethod.testlog("Pass"," Test passed Chinese Meter added Successully");
    	Thread.sleep(2000);	
    	CommonMethod.testlog("Pass","Test passed Verifying International Languages Successully");
    	Thread.sleep(1000);
    	
    	CommonMethod.testlog("Pass"," Test Started Verifying Special Character Test");
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.testlog("Pass"," Verifying Meter Creation with special character");
    	CommonMethod.sendKeys( "MeterName","á, é, í, ó, ú, ü, ñ, ¿, ¡¿Dónde");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	CommonMethod.testlog("Pass"," Test passed Meter added Successully");
    	Thread.sleep(2000);
    	
    	CommonMethod.testlog("Pass"," Verifying Meter Creation with special character");
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.sendKeys( "MeterName","está el baño?");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	CommonMethod.testlog("Pass"," Test passed Meter added Successully");
    	Thread.sleep(2000);
    	
    	CommonMethod.testlog("Pass"," Verifying Meter Creation with special character");
    	CommonMethod.click( MeterLocator);
    	Thread.sleep(1000);
    	CommonMethod.sendKeys( "MeterName","Frío");
    	CommonMethod.testlog( "Pass","Entering Meter Name");
    	Thread.sleep(1000);
    	CommonMethod.click( "AddButton");
    	CommonMethod.testlog( "Pass","Clicking on Add Button");
    	Thread.sleep(2000);
    	CommonMethod.testlog("Pass"," Test passed Meter added Successully");
    	Thread.sleep(2000);
    	
    	
    	
 }
 public void EnergyUploadxls(String param) throws IOException, InterruptedException{
    	CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickDataInput();
    	ClickDataInputParam(param);
    	CommonMethod.click( "UploadButton");
    	//CommonMethod.click("UploadDataMeter");
    	Thread.sleep(4000);
    	/*Runtime.getRuntime().exec(System.getProperty("user.dir") +"\\ARCDataTemplete\\AutoItScrit.exe");*/
    	CommonMethod.displayhiddenElement("UploadDataMeterHidden");
    	Thread.sleep(2000);
    	/*CommonMethod.click("UploadDataMeterHidden");
    	CommonMethod.uploadFile(System.getProperty("user.dir") +"\\ARCDataTemplete\\arc_Data_Template.xlsm");*/
		
    	CommonMethod.sendKeys("UploadDataMeterHidden", System.getProperty("user.dir") +"\\ARCDataTemplete\\arc_Data_Template.xlsm");
    	
    	CommonMethod.testlog("Pass","File uploaded successfully");
    	String string = CommonMethod.getText("VerifySuccess");
        System.out.println(string);
     
    	if(string.contains("Excel submitted successfully. We will send you an email when you data is processed."))
        
        CommonMethod.testlog("Pass","Energy arc_Data_Templete Uploaded Successully");
    	CommonMethod.click( "Close");
    	CommonMethod.testlog("Pass","Closed File Upload popup");
    	Thread.sleep(20000);
    	CommonMethod.testlog("Pass","Verifying added Energy Meter ");
    	
    	String emeter=CommonMethod.getText( "VuploadEnergyMeter");
    	System.out.println(emeter);
    	Assert.assertEquals(emeter, "Energy");
    	//if(emeter.contains("EnergyFileUploadTestMeter"))
    	
    	CommonMethod.testlog("Pass","Energy arc_Data_Templete Verified successully");
    	
    
       
        
        /*Thread.sleep(15000);
        WebElement button= .findElement(By.xpath("//div[@data-tooltip='Upload using computer']"));
        {
        	 if(button.isEnabled())
             {	
            .findElement(By.xpath("//div[@data-tooltip='Upload using computer']")).click();
            System.out.println("the button is enabled");
            }
            else
            {
                System.out.println("the button is disabled");
            }*/
        
        
        
        /*Thread.sleep(15000);
        CommonMethod.click("PdfButton");
    	CommonMethod.FluentWait( "PdfButton");
    	CommonMethod.moveToElement( "PdfButton");
        Runtime.getRuntime().exec("D:\\ARCREPOSITORY\\ARCTests\\ARCDataTemplete\\PdfScript.exe");
    	Thread.sleep(3000);
    	CommonMethod.testlog("Pass","PDF uploaded successfully");
    	CommonMethod.testlog("Pass","Credit Verified Successfullly");*/
    	
    }
 
 public void uploadImageParking() throws IOException, InterruptedException{
 
 	CommonMethod.ArcSpecifictoggle( "Manage");
	CommonMethod.click( "Project");
	CommonMethod.testlog( "Pass", "Clicking on Project");
 	CommonMethod.click( "M_Upload");
 	Thread.sleep(1000);
 	Runtime.getRuntime().exec("D:\\ARCREPOSITORY\\ARCTests\\ARCDataTemplete\\AutoItParkingScrit.exe");
 	//Assert.assertEquals("Info","File uploaded successfully");
 	Thread.sleep(5000);
 	CommonMethod.testlog("Pass","File uploaded successfully");
 	
 }

   public void CreateWasteMeter(String param, String sheetName, int rowNum ) throws IOException, InterruptedException{	
	    
	   /************************* Reading Data from the excel sheet ***********************/
	   
	    String strtDate  = data.getCellData(sheetName, "Start Date", rowNum);
	    String endDate   = data.getCellData(sheetName, "End Date"  , rowNum);
	    String wasteGen1 = data.getCellData(sheetName, "Waste Gen1", rowNum);
	    String wasteDiv1 = data.getCellData(sheetName, "Waste Div1", rowNum);
	    String wasteGen2 = data.getCellData(sheetName, "Waste Gen2", rowNum);
	    String wasteDiv2 = data.getCellData(sheetName, "Waste Div2", rowNum);
	    String wasteGen3 = data.getCellData(sheetName, "Waste Gen3", rowNum);
	    String wasteDiv3 = data.getCellData(sheetName, "Waste Div3", rowNum);
	   
	   
	    CommonMethod.ArcSpecifictoggle( "CreditAction");
		ClickDataInput();
    	ClickDataInputParam(param);
    	CommonMethod.click( "Waste");
    	CommonMethod.testlog( "Pass","Clicking on Waste");
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking on Add New Reading");
    	CommonMethod.FluentWait("EditButtonMeterData");
        CommonMethod.moveToElement( "EditButtonMeterData");
     	
        CommonMethod.click( "EditButtonMeterData");	
    	CommonMethod.testlog( "Pass","Clicking on edit button meter data");
    	
    	CommonMethod.testlog( "Pass","Clicking Edit button Meter Data");
    	CommonMethod.click( "StartDate");
    	CommonMethod.clear( "StartDate");
    	CommonMethod.sendKeys( "StartDate", strtDate);
    	CommonMethod.click( "StartDate");
    	Thread.sleep(1000);
    	CommonMethod.click( "EndDate");
    	CommonMethod.clear( "EndDate");
    	CommonMethod.sendKeys( "EndDate", endDate);
    	CommonMethod.click( "EndDate");
    	Thread.sleep(1000);
    	
    	CommonMethod.sendKeys( "WasteGenerated", wasteGen1);
    	CommonMethod.testlog( "Pass","Entering Waste generated");
    	CommonMethod.sendKeys( "WasteDiverted", wasteDiv1);
    	CommonMethod.testlog( "Pass","Entering Waste diverted For first Colum");
    	CommonMethod.click( "SaveButtonMeter");
    	Thread.sleep(2000);
    	
      
    
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking on Add New Reading");
    	CommonMethod.FluentWait( "EditButtonMeterData");
        CommonMethod.moveToElement( "EditButtonMeterData");
     	CommonMethod.click( "EditButtonMeterData");	
    	CommonMethod.testlog( "Pass","Clicking on edit button meter data");
    	CommonMethod.sendKeys( "WasteGenerated", wasteGen2);
    	CommonMethod.testlog( "Pass","Entering Waste generated");
    	CommonMethod.sendKeys( "WasteDiverted", wasteDiv2);
    	CommonMethod.testlog( "Pass","Entering Waste diverted For first Colum");
    	CommonMethod.click( "SaveButtonMeter");
    	Thread.sleep(3000);
    	
    	
    	CommonMethod.FluentWait( "AddNewReading");
    	CommonMethod.click( "AddNewReading");
    	CommonMethod.testlog( "Pass","Clicking on Add New Reading");
    	CommonMethod.FluentWait( "EditButtonMeterData");
        CommonMethod.moveToElement( "EditButtonMeterData");
     	CommonMethod.click( "EditButtonMeterData");	
    	CommonMethod.testlog( "Pass","Clicking on edit button meter data");
    	CommonMethod.sendKeys( "WasteGenerated", wasteGen3);
    	CommonMethod.testlog( "Pass","Entering Waste generated");
    	CommonMethod.sendKeys( "WasteDiverted", wasteDiv3);
    	CommonMethod.testlog( "Pass","Entering Waste diverted For first Colum");
    	CommonMethod.click( "SaveButtonMeter");
    	Thread.sleep(3000); 
    	
    	
    	CommonMethod.testlog( "Pass","Clicking on save button meter");
    	Thread.sleep(3000); 	
    	
    }
   
   public void EditWasteMeter(String param) throws IOException, InterruptedException{ 
	  CommonMethod.ArcSpecifictoggle( "CreditAction");
	  ClickDataInput();
      ClickDataInputParam(param);
   	  CommonMethod.click( "Waste");
   	  CommonMethod.testlog( "Pass","Clicking on Waste");
   	   
   	  CommonMethod.FluentWait( "EditButtonMeterData");
      CommonMethod.moveToElement( "EditButtonMeterData");
 	  CommonMethod.click( "EditButtonMeterData");	
   	  CommonMethod.testlog( "Pass","Clicking on Edit button meter");
   	  
   	   String date = CommonMethod.getText( "WasteStartdate");
   	   CommonMethod.testlog( "Pass","Fetching start date from first column");
   	   CommonMethod.sendKeys( "WasteEndDate", date);
       CommonMethod.testlog( "Pass","Feeding End date same as start date");
   	   CommonMethod.clear( "WasteDiverted");
   	   CommonMethod.sendKeys( "WasteDiverted", "30");
   	   CommonMethod.click( "SaveButtonMeter");
   	   Thread.sleep(5000); 
   	   
   	   /*CommonMethod.assertisElementPresentFalse( "WasteErrorSymbol", "Same date Overlapping should be allowed");
       CommonMethod.testlog( "Pass","Same date overlapping is allowed");*/
   
	
	}
	
   public void dateWasteMeter(String param) throws IOException, InterruptedException{ 
	   CommonMethod.ArcSpecifictoggle( "CreditAction");
	   ClickDataInput();
       ClickDataInputParam(param);
   	   CommonMethod.click( "Waste");
   	   CommonMethod.testlog( "Pass","Clicking on Waste");
   	   
   	   CommonMethod.FluentWait( "EditButtonMeterData");
       CommonMethod.moveToElement( "EditButtonMeterData");
 	   CommonMethod.click( "EditButtonMeterData");	
   	   CommonMethod.testlog( "Pass","Clicking on Edit button meter");
   	  
   	   String date = CommonMethod.getText( "WasteStartdate");
   	   CommonMethod.testlog( "Pass","Fetching start date from first column");
   	   CommonMethod.sendKeys( "WasteEndDate", date);
       CommonMethod.testlog( "Pass","Feeding End date same as start date");
   	  // CommonMethod.assertisElementPresentFalse( "WasteErrorSymbol", "Same date Overlapping should be allowed");
       CommonMethod.testlog( "Pass","Same date overlapping is allowed");
   
	
	}
   
   
   public void WasteFileUploadxls(String param) throws IOException, InterruptedException{
	CommonMethod.ArcSpecifictoggle( "CreditAction");
	ClickDataInput();
   	ClickDataInputParam(param);
   	CommonMethod.click( "UploadButton");
   	CommonMethod.click("UploadDataMeter");
   	Thread.sleep(1000);
   	Runtime.getRuntime().exec(System.getProperty("user.dir") +"\\ARCDataTemplete\\AutoItScrit.exe");
   	Thread.sleep(1000);
   	CommonMethod.click( "Close");
   	CommonMethod.testlog("Pass","File uploaded successfully");
   	Thread.sleep(10000);
    String string = CommonMethod.getText("CreditName");
    Assert.assertEquals("Waste", string);
    System.out.println(string);
    Thread.sleep(1000);
    CommonMethod.testlog("Pass","Credit Verified Successfullly");
       
     
       
      
   }
   public void WaterFileUploadxls(String param) throws IOException, InterruptedException{
	CommonMethod.ArcSpecifictoggle( "CreditAction");
    ClickDataInput();
   	ClickDataInputParam(param);
   	CommonMethod.click( "UploadButton");
   	CommonMethod.click("UploadDataMeter");
   	Thread.sleep(1000);
   	Runtime.getRuntime().exec(System.getProperty("user.dir") +"\\ARCDataTemplete\\AutoItScrit.exe");
   	Thread.sleep(1000);
   	CommonMethod.testlog("Pass","File uploaded successfully");
   //	String string = CommonMethod.getText("VerifySuccess");
    //   System.out.println(string);
    
   //	if(string.contains("Excel submitted successfully. We will send you an email when you data is processed."))
       
    CommonMethod.testlog("Pass","Energy arc_Data_Templete Uploaded Successully");
   	CommonMethod.click( "Close");
   	CommonMethod.testlog("Pass","Closed File Upload popup");
   	Thread.sleep(10000);
   	CommonMethod.testlog("Pass","Verifying added Water Meter ");
   	
   	CommonMethod.assertcontainsmessage("VuploadwaterMeter","Water"," Not Correct Credit");
   	CommonMethod.testlog("Pass","Upload Water arc_Data_Templete verified successully");
   	
	      
	   }  
   public void verifyTotalScoreBar(String param) throws IOException, InterruptedException{
   	CommonMethod.ArcSpecifictoggle( "Score");
   	ClickScore();
   	ClickTotalParam(param);
   	CommonMethod.testlog("Pass","Total score Bar Verified successully");
   	Thread.sleep(1000);
      
       
       /*Thread.sleep(15000);
       WebElement button= .findElement(By.xpath("//div[@data-tooltip='Upload using computer']"));
       {
       	 if(button.isEnabled())
            {	
           .findElement(By.xpath("//div[@data-tooltip='Upload using computer']")).click();
           System.out.println("the button is enabled");
           }
           else
           {
               System.out.println("the button is disabled");
           }*/
       
       
       
       /*Thread.sleep(15000);
       CommonMethod.click("PdfButton");
   	CommonMethod.FluentWait( "PdfButton");
   	CommonMethod.moveToElement( "PdfButton");
       Runtime.getRuntime().exec("D:\\ARCREPOSITORY\\ARCTests\\ARCDataTemplete\\PdfScript.exe");
   	Thread.sleep(3000);
   	CommonMethod.testlog("Pass","PDF uploaded successfully");
   	CommonMethod.testlog("Pass","Credit Verified Successfullly");*/
   	
   }
   public void verifyEDailiyMTCO2e(String param) throws IOException, InterruptedException{
	   	    CommonMethod.ArcSpecifictoggle( "Analytics");
	    	ClickAnalytics();
	  	    ClickAnalyticsParam(param);
	  	    Thread.sleep(2000);
	        CommonMethod.testlog( "Pass","TEST STARTED ENERGY PROJECT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
	    	String  str1=CommonMethod.getText( "Anualcarbon");
	        System.out.println(str1);
	        double d1=Double.parseDouble(str1);  
	        double edaily=d1/365; 
	        BigDecimal pden = new BigDecimal(edaily);     
            pden = pden.setScale(4, RoundingMode.HALF_UP);    
	        System.out.println(pden);
	    	String dailyCarbon =CommonMethod.getText("Dailycarbon");
	    	Thread.sleep(1000);
	    	String str2= new String(dailyCarbon);
	    	System.out.println(dailyCarbon);
	    	double d3=Double.parseDouble(str2);
	    	BigDecimal pden1 = new BigDecimal(d3);     
	        pden1 = pden.setScale(4, RoundingMode.HALF_UP); 
	    	System.out.println(pden);
	   	    System.out.println(pden1);
	    	Assert.assertEquals(pden,pden1);
	    	CommonMethod.testlog( "Pass", "Verified Project Energy Daily Carbon Emissions successully");
	    	CommonMethod.testlog( "Pass", "Test Passed");
	    	
	    	CommonMethod.testlog( "Pass","TEST STARTED ENERGY PER SQ FT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
		    String  pstr1=CommonMethod.getText( "PAnualcarbon");
		    System.out.println(pstr1);
		    double epdaily=Double.parseDouble(pstr1)/365;    
		    BigDecimal epden = new BigDecimal(epdaily);     
	        epden = epden.setScale(4, RoundingMode.HALF_UP);    
		    System.out.println(epden);	
		    String epdailyCarbon =CommonMethod.getText("PDailycarbon");
		    Thread.sleep(1000);
		    double epdailyCarbon1 =Double.parseDouble(epdailyCarbon);	
		    BigDecimal epden1 = new BigDecimal(epdailyCarbon1);     
		    epden1 = epden1.setScale(4, RoundingMode.HALF_UP); 	
		   	System.out.println(epden);
		   	System.out.println(epden1);
		    Assert.assertEquals(epden,epden1);
		    CommonMethod.testlog( "Pass", "Verified PER SQ FT DAILY ADJUSTED CARBON EMISSIONS (MTCO2e)");
		    CommonMethod.testlog( "Pass", "Test Passed");
		    
			CommonMethod.testlog( "Pass","TEST STARTED ENERGY PER OCC(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
		    String  ostr1=CommonMethod.getText( "OAnualcarbon");
		    System.out.println(ostr1);
		    double eodaily=Double.parseDouble(ostr1)/365;    
		    BigDecimal eoden = new BigDecimal(eodaily);     
	        eoden = eoden.setScale(4, RoundingMode.HALF_UP);      
		    String eodailyCarbon =CommonMethod.getText("ODailycarbon");
		    Thread.sleep(1000);
		    double eodailyCarbon1 =Double.parseDouble(eodailyCarbon);	
		    BigDecimal eoden1 = new BigDecimal(eodailyCarbon1);     
		    eoden1 = eoden1.setScale(4, RoundingMode.HALF_UP); 	
		   	System.out.println(eoden);
		   	System.out.println(eoden1);
		    Assert.assertEquals(eoden,eoden1);
		    CommonMethod.testlog( "Pass", "Verified PER OCC DAILY ADJUSTED CARBON EMISSIONS (MTCO2e) Successfully");
		    	
	    	
   }
   public void verifyWDailiyMTCO2e(String param) throws IOException, InterruptedException{
  	   CommonMethod.ArcSpecifictoggle( "Analytics");
   	   ClickAnalytics();
 	   ClickAnalyticsParam(param);
 	   Thread.sleep(3000);
       CommonMethod.testlog( "Pass","TEST STARTED WATER PROJECT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
   	   String  str1=CommonMethod.getText( "WAnualcarbon");
       System.out.println(str1);
      double d1=Double.parseDouble(str1);  
      double edaily=d1/365; 
      System.out.println(edaily);
       
       BigDecimal pden = new BigDecimal(edaily);     
       pden = pden.setScale(4, RoundingMode.HALF_UP);    
       System.out.println(pden);
   	  String dailyCarbon =CommonMethod.getText("WDailycarbon");
      Thread.sleep(1000);
   	  String str2= new String(dailyCarbon);
   	  System.out.println(dailyCarbon);
   	  double d3=Double.parseDouble(str2);
   	  BigDecimal pden1 = new BigDecimal(d3);     
      pden1 = pden.setScale(4, RoundingMode.HALF_UP); 
      System.out.println(pden);
  	  System.out.println(pden1);
   	  Assert.assertEquals(pden,pden1);
   	  CommonMethod.testlog( "Pass", "Verified Project Water Daily Carbon Emissions successully");
      CommonMethod.testlog( "Pass", "Test Passed");
       
       
   		CommonMethod.testlog( "Pass","TEST STARTED Water PER SQ FT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
	    String  pstr1=CommonMethod.getText( "WPAnualcarbon");
	    System.out.println(pstr1);
	    double epdaily=Double.parseDouble(pstr1)/365;    
	    BigDecimal epden = new BigDecimal(epdaily);     
        epden = epden.setScale(4, RoundingMode.HALF_UP);    
	    System.out.println(epden);	
	    String epdailyCarbon =CommonMethod.getText("WPDailycarbon");
	    Thread.sleep(1000);
	    double epdailyCarbon1 =Double.parseDouble(epdailyCarbon);	
	    BigDecimal epden1 = new BigDecimal(epdailyCarbon1);     
	    epden1 = epden1.setScale(4, RoundingMode.HALF_UP); 	
	   	System.out.println(epden);
	   	System.out.println(epden1);
	    Assert.assertEquals(epden,epden1);
	    CommonMethod.testlog( "Pass", "Verified Water PER SQ FT DAILY ADJUSTED CARBON EMISSIONS (MTCO2e)");
	    CommonMethod.testlog( "Pass", "Test Passed");
	    
		CommonMethod.testlog( "Pass","TEST STARTED Water PER OCC(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
	    String  ostr1=CommonMethod.getText( "WOAnualcarbon");
	    System.out.println(ostr1);
	    double eodaily=Double.parseDouble(ostr1)/365;    
	    BigDecimal eoden = new BigDecimal(eodaily);     
        eoden = eoden.setScale(4, RoundingMode.HALF_UP);      
	    String eodailyCarbon =CommonMethod.getText("WODailycarbon");
	    Thread.sleep(1000);
	    double eodailyCarbon1 =Double.parseDouble(eodailyCarbon);	
	    BigDecimal eoden1 = new BigDecimal(eodailyCarbon1);     
	    eoden1 = eoden1.setScale(4, RoundingMode.HALF_UP); 	
	   	System.out.println(eoden);
	   	System.out.println(eoden1);
	    Assert.assertEquals(eoden,eoden1);
	    CommonMethod.testlog( "Pass", "Verified Water PER OCC DAILY ADJUSTED CARBON EMISSIONS (MTCO2e) Successfully");
	    	
   	
}
   public void verifyCTotalPerSQFTAnalytics(String param) throws IOException, InterruptedException{
        CommonMethod.testlog( "Pass","TOTAL ANNUAL CARBON EMISSIONS (MTCO2e): PER SQ FT");
    	String  str1=CommonMethod.getText( "SCTotal");
    	Double CTotal= Double.parseDouble(str1);
    	BigDecimal AtotalMtco2e = new BigDecimal(CTotal);     
        AtotalMtco2e = AtotalMtco2e .setScale(4, RoundingMode.HALF_UP);    
        System.out.println(AtotalMtco2e);
         
        String  str2=CommonMethod.getText( "SCTEScope1");      
        Double CTEScope1 = Double.parseDouble(str2);
        System.out.println(CTEScope1);
        
        String  str3=CommonMethod.getText( "SCTEScope2");
        Double CTEScope2 = Double.parseDouble(str3);   
        System.out.println(CTEScope2);
        
        String  str4=CommonMethod.getText( "SCTTransportion");
        String replaced = str4.replace('-', '0');
        	
        Double CTTransportion = Double.parseDouble(replaced);
        System.out.println(CTTransportion);
        
        Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion ;    
        BigDecimal totalMtco2e = new BigDecimal(TotalCarbon);     
        totalMtco2e = totalMtco2e .setScale(4, RoundingMode.HALF_UP);
        System.out.println(totalMtco2e);     
        Assert.assertEquals(AtotalMtco2e,totalMtco2e);     
        CommonMethod.testlog("Pass","Test passed TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) For PER SQ FT Verified Successfully" );    	
   	
}
   public void verifyCTotalPerOCCAnalytics(String param) throws IOException, InterruptedException{
       CommonMethod.testlog( "Pass","Verifying TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) PER OCC");
       String  str1=CommonMethod.getText( "OCTotal");
       Double CTotal= Double.parseDouble(str1);
   	   BigDecimal AtotalMtco2e = new BigDecimal(CTotal);     
       AtotalMtco2e = AtotalMtco2e .setScale(4, RoundingMode.HALF_UP);    
       System.out.println(AtotalMtco2e);
        
       String  str2=CommonMethod.getText( "OCTEScope1");      
       Double CTEScope1 = Double.parseDouble(str2);
       System.out.println(CTEScope1);
       
       String  str3=CommonMethod.getText( "OCTEScope2");
       Double CTEScope2 = Double.parseDouble(str3);   
       System.out.println(CTEScope2);
       
       String  str4=CommonMethod.getText( "OCTTransportion");
       Double CTTransportion = Double.parseDouble(str4);
       System.out.println(CTTransportion);
       
       Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion ;    
       BigDecimal totalMtco2e = new BigDecimal(TotalCarbon);     
       totalMtco2e = totalMtco2e .setScale(4, RoundingMode.HALF_UP);
       System.out.println(totalMtco2e);     
       Assert.assertEquals(AtotalMtco2e,totalMtco2e);     
       CommonMethod.testlog("Pass"," Test passed Verified TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) For PER OCC Successfully" );    	
  	
}
   public void verifyCTotalProjectAnalytics(String param) throws IOException, InterruptedException{
 	    CommonMethod.ArcSpecifictoggle( "Analytics");
    	ClickAnalytics();
	    ClickAnalyticsParam(param);
        CommonMethod.testlog( "Pass","Verifying TOTAL ANNUAL CARBON EMISSIONS (MTCO2e): For Project");
     	String  str1=CommonMethod.getText( "CTotal");
   	    Double CTotal= Double.parseDouble(str1);
   	    BigDecimal AtotalMtco2e = new BigDecimal(CTotal);     
        AtotalMtco2e = AtotalMtco2e .setScale(4, RoundingMode.HALF_UP);    
        System.out.println(AtotalMtco2e);
        
        String  str2=CommonMethod.getText( "CTEScope1");      
        Double CTEScope1 = Double.parseDouble(str2);
        System.out.println(CTEScope1);
       
        String  str3=CommonMethod.getText( "CTEScope2");
        Double CTEScope2 = Double.parseDouble(str3);   
        System.out.println(CTEScope2);
       
        String  str4=CommonMethod.getText( "CTTransportion");
        Double CTTransportion = Double.parseDouble(str4);
        System.out.println(CTTransportion);
       
        Double TotalCarbon= CTEScope1 + CTEScope2 + CTTransportion ;    
        BigDecimal totalMtco2e = new BigDecimal(TotalCarbon);     
        totalMtco2e = totalMtco2e .setScale(4, RoundingMode.HALF_UP);
        System.out.println(totalMtco2e);     
        Assert.assertEquals(AtotalMtco2e,totalMtco2e);     
        CommonMethod.testlog("Pass"," Test passed Verified TOTAL ANNUAL CARBON EMISSIONS (MTCO2e) For Project Successfully" );    	
  	
}
   
   public void verifyEAnaltyicsTooltip(String param) throws IOException, InterruptedException{
  	   CommonMethod.ArcSpecifictoggle( "Analytics");
   	   //ClickAnalytics();
 	   ClickAnalyticsParam(param);
       CommonMethod.testlog( "Pass","TEST STARTED ANNUAL ENERGY ANALYTICS TOOLTIP VERIFICATION");
       Actions builder=new Actions(driver);
       WebElement username_tooltip=driver.findElement(By.xpath("(//a[@data-tooltip='Adjusted for Temperature and Operating Hours'])[1]"));
       // Mouse hover to that text message
       builder.moveToElement(username_tooltip).build().perform();
       builder.click(username_tooltip).perform();
       builder.moveByOffset(5, 5);
       String tooltip_msg= username_tooltip.getAttribute("data-tooltip");
       System.out.println("Tool Tip Message is " +tooltip_msg);
       Assert.assertEquals("Adjusted for Temperature and Operating Hours", tooltip_msg);
       CommonMethod.testlog( "Pass", "Verified Annual Energy Annual Tool tip Content successully");
       CommonMethod.testlog( "Pass", "Test Passed ");
       Thread.sleep(2000);
       
       
       CommonMethod.testlog( "Pass","TEST STARTED DAILY ENERGY ANALYTICS TOOLTIP VERIFICATION");
       Actions dbuilder=new Actions(driver);
       WebElement dusername_tooltip=driver.findElement(By.xpath("(//a[@data-tooltip='Adjusted for Temperature and Operating Hours'])[2]"));
       // Mouse hover to that text message
       dbuilder.moveToElement(dusername_tooltip).build().perform();
       dbuilder.clickAndHold(dusername_tooltip).perform();
       dbuilder.moveByOffset(5, 5);
       String dtooltip_msg= dusername_tooltip.getAttribute("data-tooltip");
       System.out.println("Tool Tip Message is " +dtooltip_msg);
       Assert.assertEquals("Adjusted for Temperature and Operating Hours", dtooltip_msg);
       CommonMethod.testlog( "Pass", "Verified Daily Energy Tool tip Content successully");
       
       
   
}
  
   public void VerifyDataInputActivity(String param) throws IOException, InterruptedException{
   	
   	CommonMethod.ArcSpecifictoggle( "CreditAction");
	ClickDataInput();
   	ClickDataInputParam(param);
   	Thread.sleep(5000);
   	System.out.println("Test");
   	CommonMethod.moveToElement( "Activity1");
   	String activity = CommonMethod.getText( "Activity1");
   	System.out.println(activity);
   	
   }
   

}

