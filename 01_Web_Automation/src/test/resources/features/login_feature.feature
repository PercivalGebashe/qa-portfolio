Feature: Login functionality for OrangeHRM
  As a valid or invalid system user
  I want to login to the OrangeHRM web application
  So that I can access authorised modules or see appropriate error messages

  @Smoke @Positive
  Scenario: Successful login with valid credentials
    Given the user is on the OrangeHRM login page
    When the user enters the username "Admin" and password "admin123"
    And clicks on the login button
    Then the user should be directed to the Dashboard page
    And the title of the page should be OrangeHRM
