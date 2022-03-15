package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy  (xpath = "//input[@id='username']")
	private WebElement userName;
	
	@FindBy  (xpath = "//input[@name='pwd']")
	private WebElement password;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	
	@FindBy  (xpath = "//input[@id='keepLoggedInCheckBox']")
	private WebElement keepMeLoginCheckbox;
	
	@FindBy (xpath = "//a[@id='loginButton']")
	private WebElement login;
	
	public LoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
		  wait = new WebDriverWait(driver,20);
		 actions = new Actions(driver);
	 }
	
	public void sendUserName(String user) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(user);
	}
	
	public void sendPasswordName(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	
	public void clickOnKeepMeLogin() {
		wait.until(ExpectedConditions.visibilityOf(keepMeLoginCheckbox));
		if(!keepMeLoginCheckbox.isSelected())
		{
			keepMeLoginCheckbox.click();
		}
		else
		{
			System.out.println("keep Me Login Checkbox already selected");
		}
	}
	
	public void clickOnLogin() {
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
	}
	
	public void loginToApplication() {
		userName.sendKeys("admin");
		password.sendKeys("manager");
		if(!keepMeLoginCheckbox.isSelected())
		{
			keepMeLoginCheckbox.click();
		}
		else
		{
			System.out.println("keep Me Login Checkbox already selected");
		}
		login.click();
		
		
		
	}
	

}
