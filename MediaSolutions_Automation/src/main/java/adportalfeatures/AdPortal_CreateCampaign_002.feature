Feature: AdPortal UAT Create Campaign feature
Scenario: Create a campaign using your Valid AdPortal UAT logIn Email and Password

Given User is on AdPortal UAT SignUp page and clicks Log in
When User enters Existing Email and Password and clicks LogIn
Then User should land on Request Dashboard page with Campaign drafts
Then User should be able to Get started or continue with the campaign
Then User enters the address on the address field and selects the distance in miles and clicks Next
Then User should be able to create a campaign ofor selected Dates