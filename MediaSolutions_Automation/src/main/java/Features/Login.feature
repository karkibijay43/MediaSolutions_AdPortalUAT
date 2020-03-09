Feature: AdPortal UAT login  Feature
Scenario: Log in with Default Username and Password

Given User is on AdPortal Login Page
When User enters Username and Password
Then User should land on Request Dashboard page
Then User should be able to Get started with the campaign