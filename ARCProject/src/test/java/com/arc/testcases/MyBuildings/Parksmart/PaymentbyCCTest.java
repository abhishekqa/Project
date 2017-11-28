package com.arc.testcases.MyBuildings.Parksmart;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.LogStatus;

public class PaymentbyCCTest extends BaseClass {

	
	@Test //(dependsOnMethods = { "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.Parksmart.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.Parksmart.AddNewProjectTest.addNewProjectTest" })
	@Parameters({"rowNum" ,"parkingSheet","paymentSheet","loginSheet"})
		public void paymentbyCCTest(int rowNum, String parkingSheet, String paymentSheet, String loginSheet ) throws IOException {
			
			CommonMethod.ExtentReportConfig();
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			CommonMethod.test = CommonMethod.extent.startTest("PaymentByCreditcardTest-parking", "Verifies if Payment done through creditcard is successful").assignCategory("CheckPayment");
		    ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		    ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
			ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
			ReusableMethodsSearch reusePublicSearch = new ReusableMethodsSearch();
			try {
				reuse.LoginToArc(rowNum,"My Projects", loginSheet);
				reusePublicSearch.SearchProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
				reusePublicSearch.VerifySearchedProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
				reuseAddProject.PaymentbyCC("ParkingPaymentVerify","Congratulations on your Parksmart registration!",paymentSheet, rowNum );

			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				CommonMethod.takeScreenshot( "paymentByCreditcardTest-parking");
				throw e1;
			}
		}
	}
