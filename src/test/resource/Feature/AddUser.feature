@add
Feature: Adding the users to the List.
 
Scenario Outline: Add user
Given User is on reqres URL
When User enters the "<name>" and "<job>"
And users hit the users API
Then Users are added to list
 
Examples:
|name|job|
|Karthik|Software Eng|
|Rohan|Analyst|