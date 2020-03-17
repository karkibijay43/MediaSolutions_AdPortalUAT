Feature: AdPortal UAT Create Campaign feature
Scenario: Create a campaign using your Valid UAT logIn userID and Password

Given User is on AdPortal UAT SignUp page and clicks log in
When User enters Username and Password and clicks LogIn
Then User should land on Request Dashboard page
Then User should be able to Get started with the campaign
Then User enters the address on the address field and selects the distance and clicks Next
Then User should be able to schedule a campaign