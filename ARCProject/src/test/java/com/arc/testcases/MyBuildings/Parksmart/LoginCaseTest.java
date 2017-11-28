package com.arc.testcases.MyBuildings.Parksmart;



import java.io.IOException;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;


public class LoginCaseTest extends BaseClass {

		@Test
		@Parameters({"rowNum" ,"loginSheet"})
		public void loginCaseTest(int rowNum, String loginSheet)throws IOException {
			
			CommonMethod.ExtentReportConfig();
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			CommonMethod.test = CommonMethod.extent.startTest("LoginTest-parking", "Verifies if parking login functionality is working fine").assignCategory("CheckLogin");
	    
			ReusableMethodsLogin reuse = new ReusableMethodsLogin();

			
			try {
				reuse.LoginWithparking(rowNum, "My Parking", loginSheet);

			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				CommonMethod.testlogError("<pre>" + e1.toString() + "</pre>");
				CommonMethod.takeScreenshot( "loginTest-parking");
				throw e1;
			}
		}
	}

