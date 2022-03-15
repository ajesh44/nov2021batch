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

public class Test456 extends Browser {
	private LoginPage loginpage;
	private  WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private ApplicationCreateUserPage applicationCreateUserPage;
	private SoftAssert soft;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	String testID;
	
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
		 
		 applicationCreateUserPage = new ApplicationCreateUserPage(driver);
		 
		 applicationCreateUserPage = new ApplicationCreateUserPage(driver);
		 
		 
		 
	}
	
	@BeforeMethod
	public void loginToapplication() throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println("loginToApplication");
		 driver.get("http://localhost/login.do");
		
 		 String user = Utility.getDataFromExcel("Ajesh", 0, 1);
 		 
 		 String password = Utility.getDataFromExcel("Ajesh", 1, 2);
 		 
		 loginpage.sendUserName(user);
		 loginpage.sendPasswordName(password);
		 loginpage.clickOnKeepMeLogin();
		 loginpage.clickOnLogin();
		 Thread.sleep(2000);
 		 
	    
	 		 
	     applicationHeaderPage.openUserListPage();
	 		
	 	 Thread.sleep(2000);
	}
	
	@Test
	public void verifyCreateUser() throws InterruptedException {
		
		testID = "1101";
		System.out.println("verify create user");
       
 		
 		applicationCreateUserPage.clickOnUser();
 		
 		Thread.sleep(2000);
 		
 		applicationCreateUserPage.sendFirstName();
 		
 		applicationCreateUserPage.sendMiddleName();
 		
 		applicationCreateUserPage.sendLastName();
 		
 		applicationCreateUserPage.sendEmail();
 		
 		applicationCreateUserPage.sendUserName();
 		
 		applicationCreateUserPage.sendPassword();
 		
 		applicationCreateUserPage.sendPasswordAgain();
 		
 		
 		
 		Thread.sleep(3000);
 		
 		
 		
 		applicationCreateUserPage.createUserOfActiTime();
 		
 		String first = driver.getCurrentUrl();
 		String title = driver.getTitle();
 		System.out.println("title");
 		soft = new SoftAssert();
 		
 		soft.assertEquals(first, "http://localhost/administration/userlist.do");
 		soft.assertEquals(title, "actiTIME - User List");
 		soft.assertAll();
 		
// 		if(first.equals("http://localhost/administration/userlist.do"))
// 		{
// 			System.out.println("test case pass");
// 		}
// 		else {
// 			System.out.println("test case fail");
// 		}
 		
 		
		
	}
	
	@Test
	public void verifyCreateAnotherUser() throws InterruptedException {
		testID = "1102";
		System.out.println("verify create another user ");
       
 		
 		applicationCreateUserPage.clickOnUser();
 		
 		Thread.sleep(2000);
 		
 		applicationCreateUserPage.sendFirstName();
 		
 		applicationCreateUserPage.sendMiddleName();
 		
 		applicationCreateUserPage.sendLastName();
 		
 		applicationCreateUserPage.sendEmail();
 		
 		applicationCreateUserPage.sendAnotherUserName();
 		
 		applicationCreateUserPage.sendPassword();
 		
 		applicationCreateUserPage.sendPasswordAgain();
 		
 		
 		
 		Thread.sleep(2000);
 		

 		applicationCreateUserPage.createUserOfActiTime();
 		
 		String second = driver.getCurrentUrl();
 		String secondTitle = driver.getTitle();
 		System.out.println(secondTitle);
 		soft = new SoftAssert();
 		soft.assertEquals(second, "http://localhost/administration/userlist.do");
 		soft.assertEquals(secondTitle, "actiTIME - User List");
 		soft.assertAll();
 		
 		
		
	}
	
	@AfterMethod
	public void logOut() throws InterruptedException, IOException {
		
		Utility.screenshot(driver, testID);
		Thread.sleep(2000);
		applicationCreateUserPage.deleteUserOfActitime();
		Thread.sleep(2000);
		System.out.println("logout");
 		applicationHeaderPage.clickOnLogout();
	}
	
	@AfterClass
	public void clearPomObject() {
	 loginpage = null;
	 applicationHeaderPage = null;
	 applicationCreateUserPage = null;
	 
	 
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("Closed browser");
		driver.quit();
		
		driver = null;
		
		System.gc();
	}

}
