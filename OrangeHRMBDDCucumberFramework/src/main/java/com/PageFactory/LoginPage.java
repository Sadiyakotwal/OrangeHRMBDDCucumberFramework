package com.PageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.BaseTest;

public class LoginPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;
	/**
	 * Description:Created constructor and passed BaseTest class reference so that we can access all 
	 * methods of basetest
	 * @param :baseTest
	 */
	public LoginPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	/**
	 * Description: Locators of Orange hrm Login page
	 */
	By loc_LoginPageHeader = By.xpath("//div[@id='divLogo']/img");
	By loc_UserName = By.xpath("//input[@id='txtUsername']");
	By loc_Password = By.xpath("//input[@id='txtPassword']");



	public void verifyHeaderOfLoginPageIsDisplayed() 
	{
		Assert.assertEquals((objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_LoginPageHeader)),true);
	}
	public void verifyIfUserNameFieldIsEmpty() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfFieldIsEmpty(loc_UserName));
	}
	public void setUserNameField(String strUserName) 
	{
		objBaseTest.getDriver().findElement(loc_UserName).sendKeys(strUserName);
		
	}
	public void verifyIfPasswordFieldIsEmpty() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfFieldIsEmpty(loc_Password));
	}
	public void setPasswordField(String strPassword) 
	{
		objBaseTest.getDriver().findElement(loc_Password).sendKeys(strPassword);
	}
	public void clickOnLoginButton() 
	{
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
}
