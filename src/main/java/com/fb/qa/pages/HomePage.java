package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase {

@FindBy(xpath = "//span[contains(text(),'Vishal Palode')]")
WebElement usernamelabel;

@FindBy(xpath = "//span[text()='Find Friends']")
WebElement findFriendsLink;

@FindBy(xpath = "//a[contains(@href,'/notifications/')]")
WebElement NotificationsLink;

@FindBy(xpath = "//a[contains(@href,'/groups/')]")
WebElement groupsLink;

public HomePage() {
	
	PageFactory.initElements(driver, this);
}

public String verifyHomePageTitle() {
     return driver.getTitle();
    		 
}
public boolean verifyUsername() {
	return usernamelabel.isDisplayed();
}
public HomePage ClickOnFindFriendsLink() {
	findFriendsLink.click();
	return new HomePage();
}
public GroupsPage ClickOnGroupsLink() {
	groupsLink.click();
	return new GroupsPage();
}	

}
