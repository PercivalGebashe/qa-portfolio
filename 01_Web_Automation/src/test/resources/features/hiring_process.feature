Feature: End-to-End Hiring Process
  As an HR administrator
  I want to create a job vacancy, process a candidate, and hire them
  So that the organization can onboard new employees correctly

  Background:
    Given the admin user is logged into the system

  @e2e @hiring @happy-path
  Scenario: Successfully hire a candidate through the recruitment workflow
    When the admin creates a job category "Engineering"
    And the admin creates a job title "Senior QA Engineer"
    And the admin creates a vacancy
    And the admin adds a candidate
    And the candidate is shortlisted
    And the interview is scheduled for the candidate
    And the interview is marked as passed
    And the job is offered to the candidate
    And the candidate is hired
    Then the user logs out
