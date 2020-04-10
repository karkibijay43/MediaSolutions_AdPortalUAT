@cucumberHooks
Feature: AdPortal UAT 

@UploadYourCommercial
Scenario: Upload your own commercial

Given User is on SignUp page and clicks log in
When User logs in using Email and Password 
Then User should land Request Dashboard page with draft campaign
Then User should be able to continue with the campaign
Then User selects the address and distance and clicks Next
Then User should be able to select the dates to schedule a campaign
Then User should be able to review the campaign details 
Then User should be able to upload their own commercial
