package pack123;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationCreateUserPage;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import utils.Utility;

public class Test123 extends Browser {
	
	   private WebDriver driver;
	   private LoginPage loginpage;
	   private ApplicationHeaderPage applicationHeaderPage ;
	   private SoftAssert soft;
	   String testID;
	   static ExtentTest test;
	   static ExtentHtmlReporter reporter;
	   
	   @BeforeTest
		@Parameters("browser")
		public void launchBrowser( String browserName ) {
		   reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"Extent.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			System.out.println("Before Test");
			
			if(browserName.equals("Chrome"))
			{
				driver = launchChromeBrowser();
			}
			
			if(browserName.equals("edge"))
			{
				driver = launchEdgeBrowser();
			}
			
			if(browserName.equals("opera"))
			{
				driver = launchOperaDriver();
		 		 driver.manage().window().maximize();
			}
			
			
			
			
	 		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	   
	   @BeforeClass
		public void createObjectOfPomClasses() {
			
		   loginpage = new LoginPage(driver);
		   applicationHeaderPage = new ApplicationHeaderPage(driver);
			 
		}
	    
	   
	     
	     @BeforeMethod
	     public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException {
	    	 
	    	 System.out.println("login to application");
	    	 driver.get("http://localhost/login.do");
	    	 
	    	 String user = Utility.getDataFromExcel("Ajesh", 0, 1);
	 		 
	 		 String password = Utility.getDataFromExcel("Ajesh", 1, 2);
	    	
	 		
	 		 loginpage.sendUserName(user);
	 		 loginpage.sendPasswordName(password);
	 		 loginpage.clickOnKeepMeLogin();
	 		 loginpage.clickOnLogin();
	 		
	 		 Thread.sleep(2000);
	     }
	     
	     @Test
	     public void verifyUserTab() {
	    	 testID="2022";
	    	 System.out.println("verify user page");
	    	 applicationHeaderPage.openUserListPage();
	 		
	 		String url = driver.getCurrentUrl();
	 		
	 		String title = driver.getTitle();
	 		
	 		soft = new SoftAssert();
	 		
	 		soft.assertEquals(url, "http://localhost/administration/userlist.do");
	 		
	 		soft.assertEquals(title, "actiTIME - User List");
	 		
	 		soft.assertAll();

//	 		if(url.equals("http://localhost/administration/userlist.do"))
//	 		{
//	 			System.out.println("test case pass");
//	 		}
//	 		else
//	 		{
//	 			System.out.println("test case fail");
//	 		}
//	 		
//	 		if(title.equals("actiTIME - User List"))
//	 		{
//	 			System.out.println("test case pass");
//	 		}
//	 		
//	 		else
//	 		{
//	 			System.out.println("test case fail");
//	 		}
//	 		System.out.println(title);
	 		
	     }
	     
	     @Test
	     public void verifyReportTab() throws InterruptedException {
	    	 
	    	 testID = "2021";
	    	 
	    	 System.out.println("verify task page");
	    	 applicationHeaderPage.openTasksPage();
	 		
	 		String url = driver.getCurrentUrl();
	 		
	 		String title = driver.getTitle();
	 		
	 		  soft = new SoftAssert();
	 		  soft.assertEquals(url,"http://localhost/tasks/otasklist.do");
	 		  soft.assertEquals(title, "actiTIME - Open Tasks");
	 		  soft.assertAll();
	 		
//	 		if(url.equals("http://localhost/tasks/otasklist.do"))
//	 		{
//	 			System.out.println("test case pass");
//	 		}
//	 		else
//	 		{
//	 			System.out.println("test case fail");
//	 		}
//	 		
//	 		if(title.equals("actiTIME - Open Tasks"))
//	 		{
//	 			System.out.println("test case pass");
//	 		}
//	 		
//	 		else
//	 		{
//	 			System.out.println("test case fail");
//	 		}
//	 		System.out.println(title);
	 		
	 		Thread.sleep(2000);
	     }
	     
	     @AfterMethod
	     public void logout(ITestResult result) throws IOException {
	    	 
	    	 Utility.screenshot(driver, testID);
	    	 System.out.println("logout");
	    	 applicationHeaderPage.clickOnLogout();
	     }
	     
	     @AfterClass
	 	public void clearPomObject() {
	 	 loginpage = null;
	 	 applicationHeaderPage = null;
	 	
	 	 
	 	 
	 	}
	     
	     @AfterTest
	 	public void closedBrowser() {
	 		System.out.println("Closed browser");
	 		driver.quit();
	 		
	 		driver = null;
	 		
	 		System.gc();
	 	}
	     
	     
	     
	    	 
	     

}
