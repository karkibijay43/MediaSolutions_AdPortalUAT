Feature: SSO LogIN SignUP AdportalUAT
Scenario: SignUP with UserEmail and password

Given User is on AdPortalUAT signUP Page
When User enters First Namme,Last Name,Business Name, Zip Code,Phone NUmbmer,Email and Password
Then User Accepts Licesne Agreement and clicks Next Step
Then User should be able to create log in credentiasls for AdportalUAT