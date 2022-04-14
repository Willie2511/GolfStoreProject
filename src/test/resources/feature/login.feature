Feature: Test a staff login


  Scenario: staff navigates to the login page successfully
    When they enter correct username
    And they enter correct password
    Then they are navigated to the staff page

