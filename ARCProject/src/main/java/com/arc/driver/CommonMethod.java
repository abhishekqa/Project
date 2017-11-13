package com.arc.driver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethod extends BaseClass  {
	
	static Format formatter = new SimpleDateFormat("YYYY-MM-dd");
	static Date date = new Date();
	public static String Sheetname = "ContactForm";
	public static String fetchedID;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String ProgramID;
	public static String signupID;
	public static String screenshotfile = System.getProperty("user.dir") +"\\Screenshots\\";
    public static File extentconfigfile = new File(System.getProperty("user.dir") +"\\src\\main\\resources\\extent-config.xml");
    public static String Reportfile = System.getProperty("user.dir") +"\\Report\\ARC-AutomationReport" + "_" + formatter.format(date) + ".html";
	public static String downloadPath = System.getProperty("user.dir") +"\\Downloads\\";
	public static WebDriverWait wait = new WebDriverWait(driver, 60);
	static WebElement element;
	
	public static WebElement findElement(final String objectLocater) throws IOException{
		//System.out.println(downloadPath);
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectLocator.properties");
		OR.load(fp);
		
		FileInputStream fp1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\DashbordLocator.properties");
		OR.load(fp1);
		
		
		String objecttypeandvalues = OR.getProperty(objectLocater);
		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0]; 
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
			
		switch(objecttype){
		  
						case "id":
							return driver.findElement(By.id(objectvalue));
							
						case "xpath":
			  
							return driver.findElement(By.xpath(objectvalue));
			  			                
			            case "name":
			  
			            	return driver.findElement(By.name(objectvalue));
			  			               		  
			            case "class":
			  
			            	return driver.findElement(By.className(objectvalue));
			  
			            case "tagname":
			  
			        	    return driver.findElement(By.tagName(objectvalue));
			     
			            case "css":
			  			  
				        	return driver.findElement(By.cssSelector(objectvalue));
				        
			            case "linkText":
				  			  
				        	return driver.findElement(By.linkText(objectvalue));
			            default:
			            	
			            	return null;
		}
		
		}
	
	
	public static List<WebElement> findElements(String objectLocater) throws IOException{
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectLocator.properties");
		OR.load(fp);
		String objecttypeandvalues = OR.getProperty(objectLocater);
		System.out.println(objecttypeandvalues);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0]; 
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
			
		switch(objecttype){
		  
						case "id":
							return driver.findElements(By.id(objectvalue));
							
						case "xpath":
			  
							return driver.findElements(By.xpath(objectvalue));
			  			                
			            case "name":
			  
			            	return driver.findElements(By.name(objectvalue));
			  			               		  
			            case "class":
			  
			            	return driver.findElements(By.className(objectvalue));
			  
			            case "tagname":
			  
			        	    return driver.findElements(By.tagName(objectvalue));
			     
			            case "css":
			  			  
				        	return driver.findElements(By.cssSelector(objectvalue));
				        
			            case "linkText":
				  			  
				        	return driver.findElements(By.linkText(objectvalue));
			            default:
			            	
			            	return null;
		}
		
		}
	//user defined click Method
	public static void click(String objectLocater) throws IOException{
		
		
		findElement(objectLocater).click();
		
	}
	//user defined sendkeys Method
	public static void sendKeys(String objectLocater,String value) throws IOException{
		findElement(objectLocater).sendKeys(value);
	}
	//user defined gettext Method
	public static String getText( String objectLocater) throws IOException {
	
		return findElement( objectLocater).getText();
		
	}
	
	public static String getattributeValue(String objectLocater) throws IOException {
		
		return findElement(objectLocater).getAttribute("value");
		
	}
	//user defined clear Method
	public static void clear(String objectLocater) throws IOException{
		findElement( objectLocater).clear();
	}
	
	public static void assertTruegetAttributeComparision(String objectLocater,String name, String message) throws IOException{
		Assert.assertTrue(findElement( objectLocater).getAttribute("value").equalsIgnoreCase(name),message);
	}
	
	public static void moveToElement(String objectLocator) throws IOException{
		
		Actions action = new Actions(driver);
		action.moveToElement(findElement( objectLocator)).build().perform();
		
	}
	
	public static void pageloadwait(){
		
	
	wait.until( new Predicate<WebDriver>()
			{ public boolean apply(WebDriver driver) 
	{ return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	} } );}
	
	static Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {

        @Override
        public boolean apply(WebDriver input) {
            return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
        }

};


	
	public static void assertTruebooleanCondition(boolean boo,String message){
		
		Assert.assertTrue(boo, message);
	}
	
	public static void assertEqualsmessage(String objectLocator,String expected, String message) throws IOException{
		
		
		Assert.assertEquals(getText(objectLocator), expected, message);
	}
	
    public static void assertEqualsmessageAttributevalue(String objectLocator,String expected, String message) throws IOException{
		
		
		Assert.assertEquals(getattributeValue(objectLocator), expected, message);
	}
	
   public static void assertNotSame(String objectLocator,String expected, String message) throws IOException{
		System.out.println("hello");
	    System.out.println(CommonMethod.getText("ErrorMessage"));
		Assert.assertNotSame((findElement( objectLocator)).getText(), expected, message);
	}
	
    public static void assertcontainsmessage(String objectLocater,String expected, String message) throws IOException{
   
    	System.out.println(CommonMethod.getText( objectLocater));
		Assert.assertTrue(getText(objectLocater).contains(expected), message);
	}
    
    public static void assertcontainsattributevalue(String objectLocator,String expected, String message) throws IOException{
    	
    	System.out.println((findElement(objectLocator)).getAttribute("value"));
		Assert.assertTrue((findElement( objectLocator)).getAttribute("value").contains(expected), message);
	}
	
    public static void assertisElementPresentTrue(String objectLocator,String message) throws IOException{
	    
    	boolean boo =  findElements(objectLocator).size()>0;
    	System.out.println(boo);
    	Assert.assertTrue(boo, message);
    	
	}
    
    public static void assertisElementPresentFalse(String objectLocator,String message) throws IOException{
	    
    	boolean boo =  findElements( objectLocator).size()>0;
    	System.out.println(boo);
    	Assert.assertFalse(boo, message);
    	
	}
    
    public static void selectdropdownrandom(String objectLocator) throws IOException{
    	
    	Select se = new Select( findElement(objectLocator));
    	List<WebElement> ele = se.getOptions();
    	se.selectByIndex(new Random().nextInt(ele.size()));
    }
    
    public static void selectdropdown(String objectLocator,String value) throws IOException{
    	
    	Select se = new Select(findElement(objectLocator));
    	se.selectByVisibleText(value);
    	
    }
    
    //Is displayed Method (Assertion)
    public static void Isdisplayed(String objectLocater,String message) throws IOException{
    	
    	Assert.assertTrue(findElement(objectLocater).isDisplayed(),message);
    	
    }
    
    public static void IsEnabled( String objectLocater,String message) throws IOException{
    	
    	Assert.assertTrue(findElement( objectLocater).isEnabled(),message);
    	
    }
    
    public static void assertcontentPageSource( String expectedtext, String message){
    	
    	Assert.assertTrue(driver.getPageSource().contains(expectedtext),message);
    }
    
   public static void assertcurrentUrl( String expectedUrl,String message){
    	System.out.println(driver.getCurrentUrl());
    	System.out.println(expectedUrl);
    	Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl),message);
    }
  public static void assertcurrentUrlTest(String expectedUrl){
	   String current =driver.getCurrentUrl();
	   System.out.println(current);
	   System.out.println(expectedUrl);
	   Assert.assertEquals(current, expectedUrl);
    	//Assert.assertEquals(expectedUrl, expected, message);
    	//Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(expectedUrl));
    	//assertTrue(driver.getCurrentUrl().equals(expectedUrl));
   	
   }
   
    //---new Addition
    
    public static void scrolldowntoLast(){
    	
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    //
    
    public static void scrolldowntoElement( String objectLocater) throws IOException{
    	
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",findElement(objectLocater));
    }
    
    public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
    public static boolean isFileDownloadedExtension(String downloadPath, String fileName) {
  		boolean flag = false;
  	    File dir = new File(downloadPath);
  	    File[] dir_contents = dir.listFiles();
  	  	    
  	    for (int i = 0; i < dir_contents.length; i++) {
  	        if (dir_contents[i].getName().endsWith(fileName))
  	            return flag=true;
  	            }

  	    return flag;
  	}
    public static void VerifyDownloadWithFileName(String filename)  {
		
	    Assert.assertTrue(isFileDownloaded(downloadPath, filename), "Failed to download Expected document");
	}
    
    
 public static void  VerifyDownloadVerifyExtension(String filename)  {
		
	    Assert.assertTrue(isFileDownloadedExtension(downloadPath, filename), "Failed to download Expected document");
	} 
    
   
    
   public static void ArcSpecifictoggle(String objectLocator) throws IOException, InterruptedException{
	   
	   click("sidebarcollapse");
	   moveToElement(objectLocator);
	   Thread.sleep(2000);
	   click(objectLocator);
	   testlog("Pass", "Clicking "+ objectLocator );
   }
   
  
   
    
	
    public static void productcount(String objectLocator, int Pno, String message) throws IOException{
		
    	List<WebElement> list = (findElements(objectLocator));
    	System.out.println(list.size());
    	int act = list.size();
		for(WebElement opt : list){
	    System.out.println(opt.getText());
	    
		}
		Assert.assertEquals(act, Pno, message);
		}

	
	
	
    public static String takeScreenshot(String methodname) throws IOException{
		try {
			
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String Dest = screenshotfile + methodname + ".png";
		File Destination = new File(Dest);
		FileUtils.copyFile(Source, Destination);
		return Dest;
		}
		
		catch(Exception e){
			
			System.out.println("Exception Taking screenshot" + e.getMessage());
			return e.getMessage();
		}
			
		
    }
			
			
    public static void ExtentReportConfig() {
		extent = new ExtentReports(Reportfile, false);
		extent.loadConfig(extentconfigfile);
        Map<String, String> sysInfo = new HashMap<String, String>();
		sysInfo.put("Selenium Version", "2.53");
		sysInfo.put("Environment", "Staging");
        extent.addSystemInfo(sysInfo);
		
	}
    
    public static void testlog(String log, String message){
    	
    	switch(log){
    	
    	case "Pass":
    		test.log(LogStatus.PASS, message);
    		break;
    		
    	case "Info":
    		test.log(LogStatus.INFO, message);
    		break;
    		
    	 default:
         	
         	System.out.println("Not Valid Input");
    	}
    }
    
    public static void testlogError(String error){
    	
    
    		test.log(LogStatus.FAIL,"<pre>" + error.toString() + "</pre>");
    		
    	}
    
    
    
    public static String randomNumber() throws IOException, InterruptedException{
    	
    	 int random_num = 1;
		    Random t = new Random();
		    
		    // random integers in [1000, 800000]
		    random_num=	(t.nextInt(800000));
		    ProgramID = String.valueOf(random_num);
		    
		    System.out.println(ProgramID);
			Thread.sleep(1000);
			return ProgramID;
			
    }
    public static String randomnumberBNone(String Url) throws IOException, InterruptedException{
    	
      	 int random_num = 1;
   		    Random t = new Random();
   		    
   		    // random integers in [1000, 800000]
   		    random_num=	(t.nextInt(800000));
   		    ProgramID = String.valueOf(random_num);
   		    
   		    System.out.println(ProgramID);
   			Thread.sleep(1000);
   			

   			File file = new File(Url);

   			if (!file.exists()) {
   				file.createNewFile();
   			}
   			FileWriter fw = new FileWriter(file.getAbsoluteFile());
   			BufferedWriter bw = new BufferedWriter(fw);
   			bw.write("BuildingNone" + " " + ProgramID);
   			bw.close();
   			return ProgramID;
   			
      }
    public static String randomnumberBOther(String Url) throws IOException, InterruptedException{
    	
      	 int random_num = 1;
   		    Random t = new Random();
   		    
   		    // random integers in [1000, 800000]
   		    random_num=	(t.nextInt(800000));
   		    ProgramID = String.valueOf(random_num);
   		    
   		    System.out.println(ProgramID);
   			Thread.sleep(1000);
   			

   			File file = new File(Url);

   			if (!file.exists()) {
   				file.createNewFile();
   			}
   			FileWriter fw = new FileWriter(file.getAbsoluteFile());
   			BufferedWriter bw = new BufferedWriter(fw);
   			bw.write("BuildingOther" + " " + ProgramID);
   			bw.close();
   			return ProgramID;
   			
      }
    public static String randomnumberCLEED( String Url) throws IOException, InterruptedException{
    	
      	 int random_num = 1;
   		    Random t = new Random();
   		    
   		    // random integers in [1000, 800000]
   		    random_num=	(t.nextInt(800000));
   		    ProgramID = String.valueOf(random_num);
   		    
   		    System.out.println(ProgramID);
   			Thread.sleep(1000);
   			

   			File file = new File(Url);

   			if (!file.exists()) {
   				file.createNewFile();
   			}
   			FileWriter fw = new FileWriter(file.getAbsoluteFile());
   			BufferedWriter bw = new BufferedWriter(fw);
   			bw.write("LEED For Communites TestProject" + " " + ProgramID);
   			bw.close();
   			return ProgramID;
   			
      }
    public static String randomnumberCOther( String Url) throws IOException, InterruptedException{
    	
      	 int random_num = 1;
   		    Random t = new Random();
   		    
   		    // random integers in [1000, 800000]
   		    random_num=	(t.nextInt(800000));
   		    ProgramID = String.valueOf(random_num);
   		    
   		    System.out.println(ProgramID);
   			Thread.sleep(1000);
   			

   			File file = new File(Url);

   			if (!file.exists()) {
   				file.createNewFile();
   			}
   			FileWriter fw = new FileWriter(file.getAbsoluteFile());
   			BufferedWriter bw = new BufferedWriter(fw);
   			bw.write("Communities Other TestProject" + " " + ProgramID);
   			bw.close();
   			return ProgramID;
   			
      }
    public static String randomnumberCNone( String Url) throws IOException, InterruptedException{
    	
      	 int random_num = 1;
   		    Random t = new Random();
   		    
   		    // random integers in [1000, 800000]
   		    random_num=	(t.nextInt(800000));
   		    ProgramID = String.valueOf(random_num);
   		    
   		    System.out.println(ProgramID);
   			Thread.sleep(1000);
   			

   			File file = new File(Url);

   			if (!file.exists()) {
   				file.createNewFile();
   			}
   			FileWriter fw = new FileWriter(file.getAbsoluteFile());
   			BufferedWriter bw = new BufferedWriter(fw);
   			bw.write("Communities None TestProject" + " " + ProgramID);
   			bw.close();
   			return ProgramID;
   			
      }
    
    
    public static String randomnumber(String Url) throws IOException, InterruptedException{
    	
   	 int random_num = 1;
		    Random t = new Random();
		    
		    // random integers in [1000, 800000]
		    random_num=	(t.nextInt(800000));
		    ProgramID = String.valueOf(random_num);
		    
		    System.out.println(ProgramID);
			Thread.sleep(1000);
			

			File file = new File(Url);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("MachineTestProject" + " " + ProgramID);
			bw.close();
			return ProgramID;
			
   }
    public static String randomnumbersignup() throws IOException, InterruptedException{
    	
   	 int random_num = 1;
		    Random t = new Random();
		    // random integers in [1000, 800000]
		    random_num=	(t.nextInt(800000));
		    signupID = String.valueOf(random_num);
		    System.out.println(signupID);
			Thread.sleep(1000);
			return signupID;
			
   }
    
	
    public static String filereadID(String url) throws IOException {

		FileReader inputFile = new FileReader(url);

		// Instantiate the BufferedReader Class
		BufferedReader bufferReader = new BufferedReader(inputFile);

		// Variable to hold the one line data

		String text;
		// Read file line by line and print on the console
		while ((text = bufferReader.readLine()) != null) {

			fetchedID = text;
			// System.out.println(CommonMethod.ProgramID);

		}

		// Close the buffer reader
		bufferReader.close();
		return fetchedID;
	}
	
	
	
	
	public static void FluentWait(final String objectLocater){
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		
			wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement  apply(WebDriver t) {
				//return t.findElement(By.xpath(".//*[contains(text(),'+ Add')]"));
				try {
					System.out.println(objectLocater);
					element= findElement(objectLocater);
				 System.out.println(element);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return element;
			}
		});
		
	}
	
		
}