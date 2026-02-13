Feature: End-to-End Hiring Process
  As an HR administrator
  I want to create a job vacancy, process a candidate, and hire them
  So that the organization can onboard new employees correctly

  Background:
    Given the admin user is logged into the system

  @e2e @hiring @happy-path
  Scenario: Successfully hire a candidate through the recruitment workflow
    When the admin creates a job title
    And the admin creates a vacancy
    And the admin adds a candidate
    Then the candidate application status should be "Application Initiated"

    When the candidate is shortlisted
    Then the candidate application status should be "Shortlisted"

    When the interview is scheduled for the candidate
    Then the candidate application status should be "Interview Scheduled"

    When the interview is marked as passed
    Then the candidate application status should be "Interview Passed"

    When the job is offered to the candidate
    Then the candidate application status should be "Job Offered"

    When the candidate is hired
    Then the candidate application status should be "Hired"

    And the user logs out