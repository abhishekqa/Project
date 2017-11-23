package com.arc.testcases.MyBuildings.Parksmart;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
public class  VerifyUploadImageTest extends BaseClass {
	@Test
	//(dependsOnMethods = { "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.Parksmart.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.Parksmart.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","buildingSheet", "paymentSheet"})
	public void UploadImage(int rowNum, String loginSheet, String buildingSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("VerifyUploadImage-Parking", "Verifies if Energy meter created and added successfully").assignCategory("CheckMeter");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();	
		try {
			reuse.LoginToArc(rowNum,"My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseDI.uploadImageParking();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("ParkingUploadImageTest-Parking");
			throw e1;
		}
	}
}
