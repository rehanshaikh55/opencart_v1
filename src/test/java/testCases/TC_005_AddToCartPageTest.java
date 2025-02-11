package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchPage;
import testBase.BaseClass;


public class TC_005_AddToCartPageTest extends BaseClass {
	
	@Test(groups= {"Master"})
	public void verify_addToCart() throws InterruptedException {
		logger.info(" Starting TC_005_AddToCartPageTest ");

		try {
			
			HomePage hp=new HomePage(driver);
			
			hp.enterProductName("iPhone");
			hp.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			
			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				sp.setQuantity("2");
				sp.addToCart();
				
			}
			Thread.sleep(1000);
			Assert.assertEquals(sp.checkConfMsg(),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}