@cucumberHooks
Feature: AdPortal UAT login  feature
@AdPortalLogInUserInPut
Scenario: Log in with default username and password
Given User is on AdPortal UAT SignUp Page and clicks LogIn link
When User enters Existing Email and password and clicks Log in Button
Then User lands on Request Dashboard page
