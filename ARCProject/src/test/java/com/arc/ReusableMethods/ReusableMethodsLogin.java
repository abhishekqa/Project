package com.arc.ReusableMethods;

import java.io.IOException;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsLogin extends BaseClass {

	public static ExtentTest test;
	public String cemail;
	public String cpass;

	// click on contact link of Home page
	public void clickSignin() throws IOException,
			InterruptedException {

		CommonMethod.click("Login_dropdown");
		Thread.sleep(1000);

	}

	// getting contact data from Excel
	public void getDataForLogin(String sheetName, int col) {

		cemail = data.getCellData(sheetName, "UserName", col);
		cpass = data.getCellData(sheetName, "Password", col);

	}

	// filling contact form
	public void fillLoginDetails() throws IOException {

		CommonMethod.clear( "EmailID");
		CommonMethod.sendKeys("EmailID", cemail);
		CommonMethod.clear("Password");
		CommonMethod.sendKeys("Password", cpass);

	}

	// click on submit button
	public void clickOnSubmit() throws IOException {
		CommonMethod.click( "LoginSubmit");
		
	}

	public void assertPostLoginText(String Exp_PostLoginText) throws IOException {

		
		CommonMethod.assertEqualsmessage("WelcomeText", Exp_PostLoginText, "Welcome Text is not correct");
		

	}
	
	/*public void LoginModule(String ModuleARC) throws IOException, InterruptedException{
		  
		
		   if(ModuleARC.equalsIgnoreCase("Buildings")){
				
				LoginWithBuildings(2, "My Buildings");
			}
		   
		   if(ModuleARC.equalsIgnoreCase("Communities")){
				
				LoginWithCommunities(2, "My Communities");
			}
		   
		   if(ModuleARC.equalsIgnoreCase("Cities")){
				
				LoginWithCities(2, "My Cities");
			}
		   
	   }*/
	
	public void LoginWithBuildings(int col, String Postlogintext, String sheetName) throws IOException, InterruptedException{
		clickSignin();
		CommonMethod.testlog("Pass", "Clicking on Login Button");
		getDataForLogin(sheetName,col);
		CommonMethod.testlog( "Info", "Getting Login data from Excel");
		fillLoginDetails();
		CommonMethod.testlog( "Pass", "Filling Login Details");
		clickOnSubmit();
		CommonMethod.testlog("Info", "Clicking on submit button");
		Thread.sleep(5000);
		/*CommonMethod.click(, "ClickProject");
		Thread.sleep(1000);
		CommonMethod.click(, "siderBarProjects");
		CommonMethod.testlog(, "Pass", "Clicking on  Sider bar My projects ");
		Thread.sleep(1000);*/
		CommonMethod.click( "siderBarBuilding");
		CommonMethod.testlog("Pass", "Clicking on My Buildings SiderBarBuilding");
		Thread.sleep(1000);
		CommonMethod.click("ClickBulidings");
        CommonMethod.testlog("Pass", "Clicking on My Buildings Button");
        Thread.sleep(1000);
		assertPostLoginText(Postlogintext);
		CommonMethod.testlog("Pass", "Login verified to My Building Successfully");
	}
	
       public void LoginToArc(int col, String Postlogintext, String sheetName)throws IOException,InterruptedException{
		clickSignin();
		CommonMethod.testlog("Pass", "Clicking on Login Button");
		getDataForLogin(sheetName,col);
		CommonMethod.testlog("Info", "Getting Login data from Excel");
		fillLoginDetails();
		CommonMethod.testlog( "Pass", "Filling Login Details");
		clickOnSubmit();
		CommonMethod.testlog("Info", "Clicking on submit button");
		Thread.sleep(5000);
	    assertPostLoginText(Postlogintext);
		CommonMethod.testlog("Pass", "Login Validation thorugh Post Login Welcome Text");
	}
       
      public void LoginWithCities(int col, String Postlogintext, String sheetName) throws IOException, InterruptedException{	
    	clickSignin();
  		CommonMethod.testlog("Pass", "Clicking on Login Button");
  		getDataForLogin(sheetName,col);
  		CommonMethod.testlog("Info", "Getting Login data from Excel");
  		fillLoginDetails();
  		CommonMethod.testlog("Pass", "Filling Login Details");
  		clickOnSubmit();
  		CommonMethod.testlog("Info", "Clicking on submit button");
  		Thread.sleep(4000);
  		CommonMethod.click("CitiesSideBar");
  		Thread.sleep(2000);
  		assertPostLoginText(Postlogintext);
  		CommonMethod.testlog("Pass", "Login Validation thorugh Post Login Welcome Text");
   	}
       
       public void LoginWithCommunities(int col, String Postlogintext) throws IOException, InterruptedException{
    	  
    			clickSignin();
    			CommonMethod.testlog("Pass", "Clicking on Login Button");
    			getDataForLogin("ContactForm",col);
    			CommonMethod.testlog("Info", "Getting Login data from Excel");
    			fillLoginDetails();
    			CommonMethod.testlog("Pass", "Filling Login Details");
    			clickOnSubmit();
    			CommonMethod.testlog("Info", "Clicking on submit button");
    			Thread.sleep(5000);
    			CommonMethod.click("ClickProject");
    			Thread.sleep(1000);
    			CommonMethod.click("siderBarProjects");
    			CommonMethod.testlog("Pass", "Clicking on  Sider bar My projects ");
    			Thread.sleep(1000);
    			CommonMethod.click("siderBarBuilding");
    			CommonMethod.testlog("Pass", "Clicking on My Buildings SiderBarBuilding");
    			Thread.sleep(1000);
    			CommonMethod.click("CommunitiesClick");
    	        CommonMethod.testlog("Pass", "Clicking on My Communities Buttion");
    	        Thread.sleep(2000);
    			assertPostLoginText(Postlogintext);
    			CommonMethod.testlog("Pass", "Login verified to My Communities Successfully");
    	   
      	}
       
       public void LoginWithtransit(int col, String Postlogintext, String sheetName) throws IOException, InterruptedException{
    	    clickSignin();
    		CommonMethod.testlog("Pass", "Clicking on Login Button");
    		getDataForLogin(sheetName,col);
    		CommonMethod.testlog("Info", "Getting Login data from Excel");
    		fillLoginDetails();
    		CommonMethod.testlog("Pass", "Filling Login Details");
    		clickOnSubmit();
    		CommonMethod.testlog("Info", "Clicking on submit button");
    		Thread.sleep(5000);
    		CommonMethod.click("siderBarBuilding");
    		Thread.sleep(1000);
    		CommonMethod.testlog("Pass", "Clicking on My Buildings SiderBarBuilding");
    		CommonMethod.click("TransitClick");
            CommonMethod.testlog("Pass", "Clicking on My Transit Button");
    		Thread.sleep(2000);
    		assertPostLoginText(Postlogintext);
    		CommonMethod.testlog("Pass", "Login Validation thorugh Post Login Welcome Text");
     	}
       
       public void LoginWithparking(int col, String Postlogintext) throws IOException, InterruptedException{
    		
    	clickSignin();
   		CommonMethod.testlog("Pass", "Clicking on Login Button");
   		getDataForLogin("ContactForm",col);
   		CommonMethod.testlog("Info", "Getting Login data from Excel");
   		fillLoginDetails();
   		CommonMethod.testlog("Pass", "Filling Login Details");
   		clickOnSubmit();
   		CommonMethod.testlog("Info", "Clicking on submit button");
   		Thread.sleep(2000);
   		CommonMethod.click("siderBarBuilding");
   		Thread.sleep(1000);
   		CommonMethod.testlog("Pass", "Clicking on My Buildings SiderBarBuilding");
   		CommonMethod.click("ParkingClick");
        CommonMethod.testlog("Pass", "Clicking on My Parking Button");
   		Thread.sleep(2000);
   		assertPostLoginText(Postlogintext);
   		CommonMethod.testlog("Pass", "Login Validation thorugh Post Login Welcome Text");
    	}
	
    public void LoginIncorrectData(int col, String error, String sheetName) throws IOException, InterruptedException{
		//String error = "Email field is required.";
		clickSignin();
		CommonMethod.testlog("Pass", "Clicking on Login Button");
		getDataForLogin(sheetName,col);
		CommonMethod.testlog("Info", "Getting Login data from Excel");
		fillLoginDetails();
		CommonMethod.testlog("Pass", "Filling Login Details");
		clickOnSubmit();
		CommonMethod.testlog("Info", "Clicking on submit button");
		CommonMethod.assertcontainsmessage("ErrorMessage", error , "Error message is not displayed/correct");
		CommonMethod.testlog("Pass", "Validating error message on entering incorrect login details");
		
	}
    
   
    
    
   

}
