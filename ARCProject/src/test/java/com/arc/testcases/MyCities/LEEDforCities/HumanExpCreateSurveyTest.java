package com.arc.testcases.MyCities.LEEDforCities;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class HumanExpCreateSurveyTest extends BaseClass {
	
	@Test //(dependsOnMethods = { "com.arc.testcases.MyCities.LEEDforCities.LoginCaseTest.loginCase","com.arc.testcases.MyCities.LEEDforCities.SearchProgramTest.searchProgram","com.arc.testcases.MyCities.LEEDforCities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCities.LEEDforCities.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet", "citySheet","cdataInputSheet"})
	public void humanExperienceMeterCreate(int rowNum, String loginSheet, String citySheet, String cdataInputSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("CreateHumanExpCreateSurveyTest-CLEED", "Verifies if Create Human Experience Survey functionality is working fine").assignCategory("CreateMeter");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseDI.CreateHumtMeterCities("HumanExperience", cdataInputSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("CreateHumanExpCreateSurveyTest-CLEED");
			throw e1;
		}
	}
}
