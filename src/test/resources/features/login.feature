Feature: Login to Integration CTRL

Scenario: Successful login
Given I open the Integration CTRL login page
When I enter valid username and password
And I click the login button
Then I should be redirected to the dashboard