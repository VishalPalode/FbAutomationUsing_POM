package com.fb.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(HomePageTest.class);
    //NotificationsPage notificationPage;
	public HomePageTest() {
		super();
}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//notificationPage = new NotificationsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
	  String homePageTitle = homePage.verifyHomePageTitle();
	  Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	@Test(priority = 2)
	public void verifyUsernameTest() {
	Assert.assertTrue(homePage.verifyUsername());	
	log.info("verify username test: ");
}
}

