@darksky-regression
Feature: Darksky Search Feature
#  Implement below Scenario in cucumber
#  Step1: Goto "https://darksky.net/"
#  Step2: Clear search text field
#  Step3: Enter address or zipcode into the search field
#  Step4: Click on search magnifying glass
#  Step5: Verify current temperature is between low and high value

  Background:
    Given I am on darksky website homepage

  @darksky-search-1
  Scenario: Verify current temperature is between low and high value
    When I clear search text field
    And I enter 11218 into the search field
    And I click on search magnifying glass
    Then I verify current temperature is between low and high value

  @darksky-sprint
  Scenario: Verify timeline is displayed in correct format
    Given I am on Darksky home page
    Then I verify timeline is displayed with two hours incremented

  @darsky-sprint-task-2
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly