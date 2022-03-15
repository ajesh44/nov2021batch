package pack123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationCreateUserPage;
import pom.ApplicationHeaderPage;
import pom.LoginPage;

public class Test2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "G:\\automation\\chromedriver_win32\\chromedriver.exe");
	  		
 		 WebDriver driver = new ChromeDriver();
 		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		  
 		 driver.get("http://localhost/login.do");
 		 
 		LoginPage loginpage = new LoginPage(driver);
	 		
 		// loginpage.sendUserName();
 		// loginpage.sendPasswordName();
 		 loginpage.clickOnKeepMeLogin();
 		 loginpage.clickOnLogin();
 		 
 		 Thread.sleep(2000);
 		 
 		ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
 		 
 		applicationHeaderPage.openUserListPage();
 		
 		Thread.sleep(2000);
 		
 		ApplicationCreateUserPage applicationCreateUserPage = new ApplicationCreateUserPage(driver);
 		
 		applicationCreateUserPage.clickOnUser();
 		
 		Thread.sleep(2000);
 		
 		applicationCreateUserPage.sendFirstName();
 		
 		applicationCreateUserPage.sendMiddleName();
 		
 		applicationCreateUserPage.sendLastName();
 		
 		applicationCreateUserPage.sendEmail();
 		
 		applicationCreateUserPage.sendUserName();
 		
 		applicationCreateUserPage.sendPassword();
 		
 		applicationCreateUserPage.sendPasswordAgain();
 		
 		applicationCreateUserPage.toSelectHiringDate();
 		
 		applicationCreateUserPage.createUserOfActiTime();
 		
 		applicationHeaderPage.clickOnLogout();
	}

}
