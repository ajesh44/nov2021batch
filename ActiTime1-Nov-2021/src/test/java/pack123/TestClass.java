package pack123;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginPage;

public class TestClass {
	
	public static void main(String[] args) throws InterruptedException   {
		
		
		
       System.setProperty("webdriver.chrome.driver", "G:\\automation\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost/login.do");
		
		LoginPage loginpage = new LoginPage(driver);
		
	//	loginpage.sendUserName();
	//	loginpage.sendPasswordName();
		loginpage.clickOnKeepMeLogin();
		loginpage.clickOnLogin();
		
		ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
		
		applicationHeaderPage.openTasksPage();
		
		String url = driver.getCurrentUrl();
		
		String title = driver.getTitle();
		
		if(url.equals("http://localhost/tasks/otasklist.do"))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case fail");
		}
		
		if(title.equals("actiTIME - Open Tasks"))
		{
			System.out.println("test case pass");
		}
		
		else
		{
			System.out.println("test case fail");
		}
		System.out.println(title);
		
		Thread.sleep(2000);
		
		applicationHeaderPage.openUserListPage();
		
		url = driver.getCurrentUrl();
		
		title = driver.getTitle();
		

		if(url.equals("http://localhost/administration/userlist.do"))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case fail");
		}
		
		if(title.equals("actiTIME - User List"))
		{
			System.out.println("test case pass");
		}
		
		else
		{
			System.out.println("test case fail");
		}
		System.out.println(title);
		
		
		
		
	}

}
