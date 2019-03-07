package com.test.automation.vrrLogistics.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_Page {
	@FindBy(id="username")
	WebElement Loginid;
	@FindBy(id="password")
	WebElement pwd;
	@FindBy(xpath="//*[contains(text(),'Not a valid login!Unauthorized user')]")
	WebElement errMessage;
	@FindBy(xpath="//*[contains(text(),'Username is required.')]")
	WebElement errMessage1;
	@FindBy(xpath="/html/body/div[2]/form[1]/div[6]/button")
	WebElement loginButton;
	
	
public Login_Page(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void loginToApplication(String str,String str1)
{
	Loginid.sendKeys(str);
	pwd.sendKeys(str1);
	loginButton.click();
	Loginid.clear();
	
}
 public void errMessage(String message)
 {
	 if (message=="Not a valid login!Unauthorized user")
	 {
	 String expected=errMessage.getText();
	 Assert.assertEquals("Not a valid login!Unauthorized user", expected);
	 }
	 
	 else if(message=="Username is required.")
	 {
		 String expected=errMessage1.getText();
		 Assert.assertEquals("Username is required.", expected);
	 }
 }

}
