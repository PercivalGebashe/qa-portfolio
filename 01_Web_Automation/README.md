# Web Automation Testing

# Enterprise Hiring Process – Test Case Design (HRMS)

This document reflects the **actual OrangeHRM hiring workflow** based strictly on a manual walkthrough.

---

## 1. Scope

**End-to-End Hiring Workflow (Happy Path)**

* Job setup
* Vacancy creation
* Candidate lifecycle
* shortlist → Interview → Offer → Hire

Out of scope (for now):

* Rejections
* Offer decline
* Negative validations

---

## 2. Global Preconditions

* Application accessible
* Admin user exists and is active
* Browser launched

---

## 3. Test Case Design

### TC-HIRE-001 — Admin Login

**Objective:** Verify admin can log in successfully

**Preconditions:**

* Valid admin credentials

**Steps:**

1. Navigate to Login page
2. Enter username
3. Enter password
4. Click Login

**Expected Results:**

* User is authenticated
* Dashboard page is displayed

---

### TC-HIRE-002 — Create Job Category

**Objective:** Verify admin can create a job category

**Preconditions:**

* Admin logged in

**Steps:**

1. Navigate to Admin → Job → Job Categories
2. Click Add
3. Enter job category name
4. Click Save

**Expected Results:**

* User is returned to Job Categories page
* Newly created job category appears in the records table

---

### TC-HIRE-003 — Create Job Title

**Objective:** Verify admin can create a job title

**Preconditions:**

* Admin logged in

**Steps:**

1. Navigate to Admin → Job → Job Titles
2. Click Add
3. Enter job title
4. Click Save

**Expected Results:**

* User is returned to Job Titles page
* Job title appears in the job titles list

---

### TC-HIRE-004 — Create Vacancy

**Objective:** Verify admin can create a vacancy linked to a job title

**Preconditions:**

* Job title exists
* Admin logged in

**Steps:**

1. Navigate to Recruitment → Vacancies
2. Click Add
3. Enter vacancy name
4. Select existing job title
5. Select hiring manager
6. Enter number of positions
7. Click Save

**Expected Results:**

* Vacancy is saved successfully
* Vacancy details remain displayed on Add Vacancy page

**Notes:**

* Vacancy is visible only after navigating back to Vacancies list

---

### TC-HIRE-005 — Add Candidate

**Objective:** Verify admin can create a candidate linked to a vacancy

**Preconditions:**

* Vacancy exists
* Admin logged in

**Steps:**

1. Navigate to Recruitment → Candidates
2. Click Add
3. Enter candidate first name
4. Enter candidate last name
5. Select vacancy
6. Enter candidate email
7. Click Save

**Expected Results:**

* Candidate profile is created successfully
* Candidate application status updates to "Initiated"

---

### TC-HIRE-006 — Shortlist Candidate

**Objective:** Verify admin can shortlist a candidate for an interview

**Preconditions:**

* Candidate exists
* Admin logged in

**Steps:**

1. Search Candidate in the candidate list
2. Open candidate actions (View icon)
3. Click Shortlist
4. Click Save

**Expected Results:**

* Candidate application status updates to "Shortlisted"

---

### TC-HIRE-007 — Schedule Interview

**Objective:** Verify admin can schedule an interview for a candidate

**Preconditions:**

* Candidate exists
* Candidate Shortlisted
* Admin logged in

**Steps:**

1. Search candidate in Candidates list
2. Open candidate application (View icon)
3. Click Schedule Interview
4. Enter interview title
5. Select interviewer
6. Select interview date
7. Enter interview time (optional)
8. Click Save

**Expected Results:**

* Candidate application status updates to "Interview Scheduled"

---

### TC-HIRE-008 — Mark Interview Passed

**Objective:** Verify admin can mark interview as passed

**Preconditions:**

* Interview scheduled

**Steps:**

1. Open candidate application
2. Click Mark Interview Passed
3. Click Save

**Expected Results:**

* Application status updates to "Interview Passed"

---

### TC-HIRE-009 — Offer Job

**Objective:** Verify admin can offer job to candidate

**Preconditions:**

* Interview marked as passed

**Steps:**

1. Open candidate application
2. Click Offer Job
3. Click Save

**Expected Results:**

* Application status updates to "Job Offered"

---

### TC-HIRE-010 — Hire Candidate

**Objective:** Verify admin can hire candidate

**Preconditions:**

* Job offered

**Steps:**

1. Open candidate application
2. Click Hire
3. Click Save

**Expected Results:**

* Application status updates to "Hired"
* Candidate is converted to employee

---

### TC-HIRE-011 — Logout

**Objective:** Verify user can log out

**Preconditions:**

* User logged in

**Steps:**

1. Click user profile icon
2. Click Logout

**Expected Results:**

* User is logged out
* Login page is displayed

---

## 4. Extensions

* Offer decline path
* PIM employee record validation post-hire

---

## 5. Tools & Tech
- Java 17
- Selenium WebDriver
- TestNG / Cucumber
- ExtentReports / Allure
- Maven

## 6. Test Scenarios
- E2E hiring process happy path

## 7. Highlights
- Implemented Page Object Model (POM)
- Driver factory
- Test context for quick page initialisation
- Auto-generated HTML reports

## 8. Reports & Screenshots
See the [`Reports/`](./reports) and [`Screenshots/`](./screenshots) folders.

---
