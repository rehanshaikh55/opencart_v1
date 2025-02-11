package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;


public class HomePage extends basePage {

	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myAccountlink;
	
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement registerlink;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement loginLink;

@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
WebElement txtSearchbox;

@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
WebElement btnSearch;
	public void clickMyAccount() {
		myAccountlink.click();
	}
	
	public void clickRegister() {
		registerlink.click();
	}
	public void clickLogin() {
		loginLink.click();
	}
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}

	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
}
