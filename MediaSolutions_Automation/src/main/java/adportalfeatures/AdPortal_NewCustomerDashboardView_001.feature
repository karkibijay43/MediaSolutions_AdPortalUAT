@cucumberHooks
Feature: New customer dashboard view feature

@DashBoardView
Scenario: Dashboard view from new customer

Given A new User is on AdPortal UAT SignUP page
When User enters all required fields
Then User accepts licesne agreement and clicks Next Step
Then User should be able to see blank dashboard page wtih no campaigns
