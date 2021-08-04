@login_cp02
Feature: Check farmland function
  Scenario:Login
    Given : login

  Scenario:Open the field information page
    Given : open a menu "农场管理"
    When : click a menu "区域管理"

    Scenario Outline: Check farmland information
      Given : Enter the field name "<name>"
      When : Selected field type "<type>"
      And :Click the query button
      Then :Check whether the query matches "<result>"
      Examples:
        | name | type | result |
        | 18-1 |      | 18-1   |
        | 18-2 | 水田   | 18-2   |
        |      | 水田   | 18-2    |

  Scenario: Open view page
    Given Check View button
    Then Closing details


  Scenario: Open the field Edit page
    Given Check Edit button
    When Modification of field name and remarks
    Then Validation results

  Scenario: out login
    Given loginout
