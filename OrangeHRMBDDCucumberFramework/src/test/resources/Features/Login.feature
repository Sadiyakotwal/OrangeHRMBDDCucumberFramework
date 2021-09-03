@SmokeTest
Feature: Orange HRM Login Feature


#without Examples Keyword
Scenario:  Orange HRM Login Test Scenario
Given user is already on Login Page and verifying header of orange HRM login page
When User enters the url on browser
And  User is verifying the input text fields of login page is empty
And user enters "Admin" and "admin123" as username and password
Then user clicks on login button
Then user is on home page of Orange HRM
