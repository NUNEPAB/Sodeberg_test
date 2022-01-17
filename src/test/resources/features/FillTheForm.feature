Feature: Fill the form

  Scenario Outline: positive scenario

    Given user <userid> is in the form page
    When form is filled and submited
    Then result match input data

    Examples:
      |userid|
      | 1    |
      | 2    |

  Scenario Outline: negative  scenario
    Given user <userid> is in the form page
    When form is filled and submited
    Then error is displayed

    Examples:
      |userid|
      | 3    |