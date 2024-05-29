Feature: Get all List of users
 
Scenario: Get all user
Given user is on reqres URL
When user hits the User API
Then all the users is displayed
