Feature: Login to system (have handle)
  As a user, I want to be able to log into the Bookstore system
  So that I can see Dashboard page

  Scenario: Successful login
    Given I Am On The Login Page
    When I enter my username and password
    And I click the Login button
    Then I should be taken to the Dashboard page