package com.generic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;
	public WebDriverWait wait;

	/**
	 * Description:Created constructor of current class and passed BaseTest class 
	 * so that we can access all methods of basetest class
	 * @param :baseTest
	 */
	public WrapperFunctions(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}

	/**
	 * Description: Created a wrapper function for checking if element is displayed or not 
	 * on the web page
	 * @param :locator
	 * 	Passed a locator i.e. xpath of the element
	 */
	public boolean checkIfElementIsDisplayed(By locator) 
	{
		try 
		{
			this.checkIfElemntVisible(locator);
			blnFlag = objBaseTest.getDriver().findElement(locator).isDisplayed();
			return blnFlag;
		} 
		catch (Exception exception) 
		{
			System.out.println("Exception Occured!!!!"+exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}
	}
	/**
	 * Description: Created a wrapper function for checking if element is selected or not 
	 * on the web page
	 * @param :locator
	 * 	Passed a locator i.e. xpath of the element
	 */
	public boolean checKIfCheckBoxIsChecked(By locator) 
	{
		try 
		{
			blnFlag  = objBaseTest.getDriver().findElement(locator).isSelected();
			return blnFlag;
		} 
		catch (Exception exception) 
		{
			System.out.println("Exception Occured!!!!"+exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}
	}
	public boolean checKIfButtonEnabled(By locator) 
	{
		try 
		{
			blnFlag  = objBaseTest.getDriver().findElement(locator).isEnabled();
			return blnFlag;
		} 
		catch (Exception exception) 
		{
			System.out.println("Exception Occured!!!!"+exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}
	}
	public boolean checkIfFieldIsEmpty(By locator) 
	{
		try 
		{
			WebElement inputField = objBaseTest.getDriver().findElement(locator);
		    String strValue =inputField.getAttribute("value");
		    System.out.println(strValue);
		    blnFlag = strValue.isEmpty();
		    System.out.println(blnFlag);
			return blnFlag;
		} 
		catch (Exception exception) 
		{
			System.out.println("Exception Occured!!!!"+exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}
		
	}
	/**
	 *Description: Explicit wait
	 * @param locator
	 */
	public void checkIfElemntVisible(By locator) 
	{
		wait = new WebDriverWait(objBaseTest.getDriver(), Integer.parseInt(objBaseTest.objConfigProperties.getProperty("ExpilicitWait")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 *Description: Implicit wait
	 * @param:intImplicitlyWait
	 * To pass wait time in int format 
	 */
	public void setImplicitlyWait(int intImplicitlyWait) 
	{
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(intImplicitlyWait, TimeUnit.SECONDS);
	}
	/**
	 * Description:Fluent Wait
	 * @param:By locator
	 */
	public void setFluentWait(final By locator)
    {
        Wait<WebDriver> wait =new FluentWait<WebDriver>(objBaseTest.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class,TimeoutException.class);
        
        WebElement webElement =wait.until(new Function<WebDriver, WebElement>() 
        {
        	public WebElement apply(WebDriver t) {
                // TODO Auto-generated method stub
                return objBaseTest.getDriver().findElement(locator);
            }
        });
    }

	public void navigateToHomePage() 
	{
		objBaseTest.getDriver().get(objBaseTest.objConfigProperties.getProperty("AUT_URL"));
	}

	public void toScrollDownPage(int intYaxis) 
	{
		 //to perform Scroll action using  Selenium
		 JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();
		 js.executeScript("window.scrollBy(0,"+intYaxis+")", "");
	}
	
	


}
