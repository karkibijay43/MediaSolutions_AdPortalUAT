@cucumberHooks
Feature: AdPortal UAT login  feature

@AdPortalLogInDefault
Scenario: Log in with default username and password

Given User is on AdPortal UAT SignUp Page and clicks Log in link
When User enters username and password and clicks log in
Then User lands on request dashboard page

