package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ApplicationHeaderPage {
	
	
	@FindBy (xpath = "//a[@class='content tt']") 
	private WebElement timeTrack;
	
	@FindBy (xpath = "//a[@class='content tasks']")
	private WebElement tasks;
	
	@FindBy (xpath = "//a[@class='content reports']")
	private WebElement reports;
	
	@FindBy (xpath = "//a[@class='content users']")
	private WebElement users;
	
	@FindBy (xpath = "//a[@class='content calendar']")
	private WebElement workSchedule;
	
	@FindBy (xpath ="//a[@class='logout']")
	private WebElement logout;
	
	
	public ApplicationHeaderPage(WebDriver driver) {
		 
		PageFactory.initElements(driver, this);
	}
	
	public void openTasksPage() {
		tasks.click();
	}
	
	public void openUserListPage() {
		users.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}

}
