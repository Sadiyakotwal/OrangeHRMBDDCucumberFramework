package com.StepDefinitions;


import com.PageFactory.LoginPage;
import com.generic.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition extends BaseTest
{
	private LoginPage objLoginPage;
	public StepDefinition() 
	{
		objLoginPage = new LoginPage(this);
	}
	@Given("user is already on Login Page and verifying header of orange HRM login page")
	public void user_is_already_on_login_page_and_verifying_header_of_orange_hrm_login_page() {
	  // objLoginPage.verifyHeaderOfLoginPageIsDisplayed();
	}

	@When("User enters the url on browser")
	public void user_enters_the_url_on_browser() {
	   initializeWebEnvironment();
	}
	@And("User is verifying the input text fields of login page is empty")
	public void user_is_verifying_the_input_text_fields_of_login_page_is_empty() {
	   objLoginPage.verifyIfUserNameFieldIsEmpty();
	   objLoginPage.verifyIfUserNameFieldIsEmpty();
	}
	@And("user enters {string} and {string} as username and password")
	public void user_enters_and_as_username_and_password(String strUserName, String strPassword) {
	  objLoginPage.setUserNameField(strUserName);
	  objLoginPage.setPasswordField(strPassword);
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
	  objLoginPage.clickOnLoginButton();
	}

	@Then("user is on home page of Orange HRM")
	public void user_is_on_home_page_of_orange_hrm() {
	    
	}




}
