Feature: Reach Intro Page Validation 

@ReachIntroPage
Scenario: User selects Next Button on Reach intro page

Given User is logged into Ad Portal
When User is on the Request DashBoard with drafts page
Then User starts or continues with campaign
Then USer should land on intro step of the Reach page
Then User clicks on Next button 
Then User should be taken to the Reach 1 of 3 page