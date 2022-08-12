package com.fb.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.CustomListener;
import com.fb.qa.util.TestUtil;


@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	public static Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test 
	public void LoginPageTitle() {
		String title = loginPage.validatLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	@Test(priority=1)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login"+ homePage);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}