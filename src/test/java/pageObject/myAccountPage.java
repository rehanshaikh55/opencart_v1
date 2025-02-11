package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends basePage {

	public myAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement headingMsg;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutBtn;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement continueBtn;
	public boolean ifMyAccountPageExist() {
		try {
			return(headingMsg.isDisplayed());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	
	}
	public void clickLogout() {
		logoutBtn.click();
	}
}
