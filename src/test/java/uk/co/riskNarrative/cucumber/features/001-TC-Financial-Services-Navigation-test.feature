@OO1TC
@all
Feature: Choose your Industry to Financial Services - Functionality
  As a user
  I want to be able to choose my Industry to Financial Services
  So that I can choose my Industry to Financial Services

  Scenario: common steps in scenarios
    Given I landed on a home page "https://risk.lexisnexis.co.uk/"
    And I should see the cookie banner
    And I tap on Accept all Cookies
    And I should not see the cookie banner
    When I tap on Choose Your Industry link
    And I can see page heading as "Industries" and 4 other links
    And Industries Sub links are present
    Then Industries Sub links are displayed as follows:
      | Financial Services           |
      | Insurance                    |
      | Life and Pensions            |
      | Corporations and Non-Profits |
    And I tap on "Financial Services" link
    And I can see "Select an Industry" and 7 red links are displayed
    And Financial Services Sub title links are present
    And I should see red links are displayed as follows:
      | Financial Crime Compliance       |
      | Fraud and Identity Management    |
      | Customer Data Management         |
      | Credit Risk Assessment           |
      | Collections and Recovery         |
      | Investigations and Due Diligence |
      | Risk Orchestration               |
    And I close browser

