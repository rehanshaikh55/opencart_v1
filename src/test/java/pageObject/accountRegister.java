package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegister extends basePage {

	public accountRegister(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtConfirmPass;
	@FindBy(xpath = "//label[normalize-space()='Yes']") WebElement switchSubscribeYes;
	@FindBy(xpath = "//input[@name='agree']") WebElement switchPolicy;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmationMsg;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnRegister;
	
	
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPhone(String phone) {
		txtTelephone.sendKeys(phone);
	}
	
	public void setPass(String pass) {
		txtPassword.sendKeys(pass);
	}
	public void setConfirmpass(String pass) {
		txtConfirmPass.sendKeys(pass);
	}
	public void setSubSwitch() {
		switchSubscribeYes.click();
	}
	public void setPolicy() {
		switchPolicy.click();
	}
	public void clickRegister() {
		btnRegister.click();
	}
	public String getConfirmMsg() {
		try {
			return (confirmationMsg.getText());
		} catch (Exception e) {
			// TODO: handle exception
			return (e.getMessage());
		}
	}
	
}
