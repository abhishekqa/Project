package com.arc.pageLibrary.registrationPage.MyTransit;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.arc.testBase.TestBase;

public class UsProjectRegisterPage extends TestBase{
	public void projectRegistration() throws Exception
	{	
		Reporter.log("Clicking On Add project ");
		getWebElement("arc.click.addproject").click();
	
		Reporter.log("Entering project Name");
		WebElement projectName=getWebElement("arc.project.name");
		projectName.sendKeys(Repository.getProperty("ProjectNameCC"));
		
		Reporter.log("Select SI");
		getWebElement("arc.unitType.si").click();
		Reporter.log("Select Space Type");
		
		
		getWebElement("arc.ratings.building").click();
		getWebElement("arc.projecttype.transit").click();
		getWebElement("arc.SpaceType.select").click();
		Reporter.log("Fill Owner Type");
		
		WebElement ownerType=getWebElement("arc.OwnertType.textbox");
		ownerType.sendKeys(Repository.getProperty("OwnerType"));
		Reporter.log("Fill Owner Organaization");
		
		WebElement ownerOrg=getWebElement("arc.OwnerOrg.textbox");
		ownerOrg.sendKeys(Repository.getProperty("OwnerOrganization"));
	
		Reporter.log("Fill Owner Email");
		WebElement ownerEmail=getWebElement("arc.OwnerEmail.textbox");
		ownerEmail.sendKeys(Repository.getProperty("OwnerEmail"));
		
		Reporter.log("Click and Select owner country");
		getWebElement("arc.OwnerCountry.click").click();

		getWebElement("arc.country.Canada.select").click();
		Reporter.log("Fill Area");
		
		WebElement area=getWebElement("arc.area");
		area.sendKeys(Repository.getProperty("Area"));

		Reporter.log("Check Private Checkbox");
		getWebElement("arc.check.private").click();
	
		Reporter.log("Fill Address");
		WebElement address= getWebElement("arc.enter.address");
		address.sendKeys(Repository.getProperty("Address"));
	
		Reporter.log("Fill City Details");
		WebElement city=getWebElement("arc.city.textbox");
		city.sendKeys(Repository.getProperty("City"));
		getWebElement("arc.click.country").click();
		
		getWebElement("arc.select.country.usa").click();
		
		
		getWebElement("arc.click.state.usa").click();;
	
		getWebElement("arc.select.state").click();
		
		Reporter.log("Fill ZipCode");
		WebElement zipcode =getWebElement("arc.zipcode.textbox");
		zipcode.sendKeys(Repository.getProperty("ZipCode"));
		
		
		
		Reporter.log("Click on Check Aggeremet & Next Button");
		getWebElement("arc.agreement.checkbox").click();
		driverwait(2);
		getWebElement("arc.click.next").click();
		driverwait(5);
	}

	
}
