package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {
	
	public static WebDriver launchChromeBrowser() {
		System.out.println("launch browser");
		 System.setProperty("webdriver.chrome.driver", "G:\\chrome\\chromedriver_win32 (1)\\chromedriver.exe");
	  		
		 //G:\\automation\\chromedriver_win32\\chromedriver.exe
		 WebDriver driver = new ChromeDriver();
		 return driver;
	}
	
	public static WebDriver launchEdgeBrowser() {
		System.out.println("edge browser");
		 System.setProperty("webdriver.edge.driver", "G:\\automation\\edgedriver_win64\\msedgedriver.exe");
	  		
		 WebDriver driver = new EdgeDriver();
		 return driver;
	}
	
	public static WebDriver launchOperaDriver() {
		System.out.println("opera browser");
		 System.setProperty("webdriver.opera.driver", "G:\\automation\\opera 64 a\\operadriver_win64\\operadriver_win64\\operadriver.exe");
	  		
		WebDriver  driver = new OperaDriver();
		  return driver;
	}
	
	

}
