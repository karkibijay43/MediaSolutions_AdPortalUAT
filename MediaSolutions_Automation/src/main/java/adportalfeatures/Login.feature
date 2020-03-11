Feature: AdPortal UAT login  Feature
Scenario: Log in with Default Username and Password

Given User is on AdPortal UAT Login Page
When User enters Username and Password and clicks Log in
Then User lands on Request Dashboard page
