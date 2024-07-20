Feature: Login to system (Only Gherkin)
  As a user, I want to be able to log into the Bookstore system
  So that I can see Dashboard page

  Scenario: Successful login1
    Given I Am On The Login Pages
    When I enter my username and passwords
    And I click the Login buttons
    Then I should be taken to the Dashboard pages



