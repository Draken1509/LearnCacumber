Feature: Add Category

  Background: Login as Admin role
    Given user logged in as an admin

  Scenario: Successful add a new category
    Given user on the category page
    When User enter a series of product information using Excel files
    And user click on the Save button
    Then user should see a error message

