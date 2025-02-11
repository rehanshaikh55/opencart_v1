package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-email']") WebElement txtLoginEmail;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtLoginPass;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginBtn;
	
	
	public void setLoginEmail(String email) {
		txtLoginEmail.sendKeys(email);
	}
	public void setLoginPass(String pass) {
		txtLoginPass.sendKeys(pass);
	}
	public void clickLogin() {
		loginBtn.click();
	}
}
