Feature: AdPortal UAT Create Campaign feature
Scenario: Create a campaign using your Valid UAT logIn userID and Password

Given User is on AdPortal Login Page
When User enters Username and Password and clicks LogIn
Then User should land on Request Dashboard page
Then User should be able to Get started with the campaign