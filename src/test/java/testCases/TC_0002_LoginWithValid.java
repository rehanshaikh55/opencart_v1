package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.loginPage;
import pageObject.myAccountPage;
import testBase.BaseClass;

public class TC_0002_LoginWithValid extends BaseClass {

	
	
	@Test(groups = {"Sanity","Master"})
	public void varify_login() {
		logger.info("**** Starting Login With valid cradantials ****");
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on my account");
		hp.clickMyAccount();
		logger.info("Clicking on Login");
		hp.clickLogin();
		
		loginPage lp= new loginPage(driver);
		logger.info("Entering valid cradantial");
		lp.setLoginEmail(p.getProperty("email"));
		lp.setLoginPass(p.getProperty("pass"));
		logger.info("Click login button");
		lp.clickLogin();
		
		logger.info("Validating My Account page");
		myAccountPage myAcc = new myAccountPage(driver);
		if(myAcc.ifMyAccountPageExist()) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
		logger.info("**** Finished Login With valid cradantial ****");
	}
}
