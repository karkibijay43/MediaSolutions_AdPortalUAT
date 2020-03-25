@cucumberHooks
Feature: SSO LogIN SignUP AdportalUAT

@SSULogIn
Scenario: SignUP with UserEmail and password

Given User is on AdPortal UAT sign up page
When User enters First Namme,Last Name,Business Name, Zip Code,Phone NUmbmer,Email and Password
Then User Reads and agrees Terms and conditions and clicks Next Step
Then User should be able to create log in credentiasls for Adportal UAT