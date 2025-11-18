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

  @Negative
  Scenario: Unsuccessful login with invalid details
    Given the user is on the OrangeHRM login page
    When the user enters the username "Admin" and password "wrongpassword"
    And clicks on the login button
    Then an error message "invalid credentials" should be displayed


  @Smoke
  Scenario: Verify logout functionality
    Given the user is Logged in successfully
    When the user clicks on the profile dropdown
    And selects the Logout option
    Then the user should be redirected to the login page
    And the login form should be visible
