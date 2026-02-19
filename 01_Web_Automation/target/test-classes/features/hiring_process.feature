Feature: End-to-End Hiring Process
  As an HR administrator
  I want to create a job vacancy, process a candidate, and hire them
  So that the organization can onboard new employees correctly

  Background:
    Given the admin user is logged into the system
    Then the user should see the Dashboard

  @e2e @hiring @happy-path
  Scenario: Successfully hire a candidate through the recruitment workflow

    # --- Job Title Creation ---
    When the user navigates to Admin
    Then the user should see the Admin page

    When the user clicks Job
    And the user selects Job Titles
    Then the job title page should be displayed

    When the user clicks the Add button
    Then the user should see the Save Job Title page

    When the user enters job title details and saves
    Then a success alert should be displayed

    # --- Vacancy Creation ---
    When the admin navigates to Recruitment
    Then the admin should see the Recruitment page

    When the admin clicks Vacancies
    Then the vacancy page should be displayed

    When the admin adds vacancy
    Then the save vacancy page should be displayed

    When the admin enters vacancy details and saves
    Then a success alert should be displayed

    # --- Candidate Creation ---
    When the admin clicks Candidates
    Then the admin should see the candidate page

    When the admin adds candidate
    Then the admin should see the save candidate page

    When the admin enters candidate details and saves
    Then a success alert should be displayed
    Then the admin should see the candidate actions page

    # --- Recruitment Candidate Lifecycle ---
    Then the candidate application status should be "Application Initiated"

    When the admin shortlists the candidate
    Then the admin should see the change candidate status page

    When the admin saves the candidate details
    Then a success alert should be displayed
    And the candidate application status should be "Shortlisted"

    When the admin schedules an interview
    Then the admin should see the change candidate status page

    When the admin enters interview details and saves
    Then a success alert should be displayed
    And the candidate application status should be "Interview Scheduled"

    When the admin marks the interview as passed
    Then the admin should see the change candidate status page

    When the admin saves the candidate details
    Then a success alert should be displayed
    And the candidate application status should be "Interview Passed"

    When the admin offers the job to the candidate
    Then the admin should see the change candidate status page

    When the admin saves the candidate details
    Then a success alert should be displayed
    And the candidate application status should be "Job Offered"

    When the admin hires the candidate
    Then the admin should see the change candidate status page

    When the admin saves the candidate details
    Then a success alert should be displayed
    And the candidate application status should be "Hired"

    # --- Logout ---
    When the user logs out
    Then the user should see the login page
