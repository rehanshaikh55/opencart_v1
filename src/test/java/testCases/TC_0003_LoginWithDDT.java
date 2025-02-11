package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import pageObject.myAccountPage;
import testBase.BaseClass;
import utilities.dataProviders;

public class TC_0003_LoginWithDDT extends BaseClass {

	
	
	@Test(dataProvider = "LoginData",dataProviderClass = dataProviders.class,groups = "DataDrivern")
	public void verify_loginDDT(String email,String pass, String exp) {
		
		
		logger.info("**** Starting Login With valid cradantials ****");
		
		try {
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on my account");
		hp.clickMyAccount();
		logger.info("Clicking on Login");
		hp.clickLogin();
		
		loginPage lp= new loginPage(driver);
		logger.info("Entering valid cradantial");
		lp.setLoginEmail(email);
		lp.setLoginPass(pass);
		logger.info("Click login button");
		lp.clickLogin();
		
		logger.info("Validating My Account page");
		myAccountPage myAcc = new myAccountPage(driver);
		boolean targetPage = myAcc.ifMyAccountPageExist();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				myAcc.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				myAcc.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
			
		}}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished Login With valid cradantial ****");
	}
}
