package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationCreateUserPage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	private Actions actions;
	
	@FindBy (xpath="//span[text()='User']")
	private WebElement selectUser;
	
	@FindBy (xpath="//input[@id='userDataLightBox_firstNameField']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@id='userDataLightBox_middleNameField']")
	private WebElement middleName;
	
	@FindBy (xpath="//input[@id='userDataLightBox_lastNameField']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@id='userDataLightBox_emailField']")
	private WebElement email;
	
	@FindBy (xpath="//input[@id='userDataLightBox_usernameField']")
	private WebElement userNameOFCreate;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement passwordOfCreate;
	
	@FindBy (xpath="//input[@name='passwordCopy']")
	private WebElement retypePassword;
	
	@FindBy (xpath="//table[@id='userDataLightBox_hireDate']//td[2]//table")
	private WebElement hireDateOfCalendar;
	
	@FindBy (xpath="//button[text()='February 2022']")
	private WebElement innerSelectMonth;
	
	@FindBy (xpath="//a[text()='Aug']")
	private WebElement selectMonth;
	
	@FindBy (xpath="//a[text()='2018']")
	private WebElement selectYear;
	
	@FindBy (xpath="(//button[@type=\"button\"])[15]")
	private WebElement okButtonAfterMonth;
	
	@FindBy (xpath="//span[text()='16']")
	private WebElement selectDate;
	
	@FindBy (xpath="//div[@class='buttonIcon']")
	private WebElement createUser;
	
	@FindBy (xpath = "(//td [@class='userNameOnHoverElement'])[1]")
	private WebElement iconToDelete;
	
	@FindBy (xpath = "//button[@id='userDataLightBox_deleteBtn']")
	private WebElement deleteUser;
	
	
	
	
	
	 public ApplicationCreateUserPage(WebDriver driver){
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
		wait = new WebDriverWait(driver,20);
		actions = new Actions(driver);
	}
	
	public void clickOnUser() {
		selectUser.click();
	}
	
	public void sendFirstName() {
		firstName.sendKeys("Ajesh");
	}
	
    public void sendMiddleName() {
    	middleName.sendKeys("umesh");;
	}
    
    public void sendLastName() {
    	lastName.sendKeys("mali");
   	}
    
    public void sendEmail() {
    	email.sendKeys("ajeshmali7@gmail.com");
   	}
    
    public void sendUserName() {
    	userNameOFCreate.sendKeys("ajeshmali");
   	}
    
    public void sendAnotherUserName() {
    	userNameOFCreate.sendKeys("ajeshmali1");
   	}
    
    public void sendPassword() {
       
    	passwordOfCreate.sendKeys("Ayushmali");

   	}
    
    public void sendPasswordAgain() {
        
    	 retypePassword.sendKeys("Ayushmali");

   	}
    
    public void toSelectHiringDate() {
    	
    	hireDateOfCalendar.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(innerSelectMonth));
    	
    	actions.moveToElement(innerSelectMonth).click().build().perform();
    	
    	wait.until(ExpectedConditions.visibilityOf(selectMonth));
    	
    	actions.moveToElement(selectMonth).click().build().perform();
    	
    	wait.until(ExpectedConditions.visibilityOf(selectYear));
    	
    	actions.moveToElement(selectYear).click().build().perform();
    	
    	wait.until(ExpectedConditions.visibilityOf(okButtonAfterMonth));
    	
    	actions.moveToElement(okButtonAfterMonth).click().build().perform();
    	
    	wait.until(ExpectedConditions.visibilityOf(selectDate));
    	
    	actions.moveToElement(selectDate).click().build().perform();
    	
    }
    
    public void createUserOfActiTime() {
    	createUser.click();
    }
    
    public void deleteUserOfActitime() {
    	
    	actions.moveToElement(iconToDelete).click().build().perform();
    	
    	deleteUser.click();
    	
    	Alert alert = driver.switchTo().alert();
    	
    	alert.accept();
    }
    
  
    
    
    
    
	
	
	
	

}
