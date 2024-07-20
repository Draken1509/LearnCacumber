Feature: Login with datatable
  @InvalidLogin
  Scenario: Invalid Login
    Given user on the login page
    When user enter valid credentials to login
      | email              | password |
      | user1@example.com  | 123      |
      | user2@example.com  | 123      |
      | user3@example.com  | 123      |
      | user4@example.com  | 1233     |
      | user5@example.com  | 123      |
    And click on the login button
    Then user should see an error message
    And stay on the login page




