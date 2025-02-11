package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.accountRegister;
import testBase.BaseClass;

public class TC_0001_AccountRegister extends BaseClass {




	@Test(groups = {"Regression","Master"})
	public void verify_account_register() {
		
		logger.info("**** starting TC_0001_AccountRegister ****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicking on account link");
		hp.clickRegister();
		logger.info("clicking on register link");
		
		accountRegister regAcc=new accountRegister(driver);
		logger.info("Filling form");
		regAcc.setFirstName(randomString());
		regAcc.setLastName(randomString());
		regAcc.setEmail(randomString()+"@gmail.com");
		regAcc.setPhone(randomInteger());
		regAcc.setPass("test123");
		regAcc.setConfirmpass("test123");
		regAcc.setSubSwitch();
		regAcc.setPolicy();
		regAcc.clickRegister();
		logger.info("validating expected message");
		
		String confirmationMsg = regAcc.getConfirmMsg();
		
		Assert.assertEquals(confirmationMsg,"Your Account Has Been Created!");
	}catch(Exception e){
		logger.info("Test Failed");
		logger.debug("debug logs");
		Assert.fail();
	}
		logger.info("**** finished TC_0001_AccountRegister ****");
	}

	
		
	
	
}
