package com.arc.testcases.MyBuildings.LEED;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsBasescore;
import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsReviewCertification;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class USBuildingLEEDv4Test extends BaseClass {
	
	@Test//(dependsOnMethods={"com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCase"})
	@Parameters({"rowNum" ,"loginSheet","buildingSheet","energySheet", "waterSheet", "wasteSheet", "paymentSheet", "teamSheet"})
	public void addNewProject(int rowNum, String loginSheet, String buildingSheet, String energySheet, String waterSheet, String wasteSheet, String paymentSheet, String teamSheet ) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("AddNewProjectUSTest-BLEED", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		ReusableMethodsBasescore reuseBS = new ReusableMethodsBasescore();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsReviewCertification reusePreCert= new ReusableMethodsReviewCertification();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		try {
			
			reuse.LoginWithBuildings(rowNum, "My Buildings", loginSheet);
			reuseAddProject.AddProjectLEEDUS(buildingSheet, rowNum);
			reuseAddProject.PaymentbyCC("paymentsuccessvalidation","Congratulations!",paymentSheet, rowNum );
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseBS.BasePointFileUplaod();
			reusePrereq.PrereqAttempt("sitemanagement",9);
			reuseDI.CreateMeter("Energy", "AddEnergyMeterTest","AddMeterEnergy", energySheet,  rowNum);
			reuseDI.CreateWaterWMeter("Water", "Test Water Meter","AddMeterWater",waterSheet, rowNum);
			reuseDI.CreateWasteMeter("Waste", wasteSheet, rowNum);
			reuseDI.EnergyUploadxls("Energy");
			reuseDI.CreateMeterInternationalLanguage("Energy", "Energy Meter Test","AddMeterEnergy");
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePreCert.verifyPreCertReviewSelection("Review");
			reusePreCert.R_PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);
			reusePreCert.ClickProceedPrecertification();
			reusePreCert.verifySuccessfullySubmittedPayment();
			reuseManage.editProjectDetails( buildingSheet, rowNum);
			reuseManage.VerifyProjectDetails(buildingSheet, rowNum);
			reuseManage.AddTeamMember( teamSheet, rowNum);
			reuseManage.EditTeamMemberRole( "Team Manager");
			reuseManage.VerifyFileDownload( "Agreement.pdf");
			reuseManage.InstallApps();
			reuseManage.verifyBillingDate();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError("<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectUSTest-BLEEd");
			throw e1;
		}
	}

	

}
