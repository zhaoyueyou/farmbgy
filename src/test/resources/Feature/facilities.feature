@facilities_cp03
Feature: Check farmland function
  Scenario:Login
    Given : login

Scenario:Open the field information page
  Given : open a menu "农场管理"
  When : click a menu "区域管理"

  Scenario:open the field facilities information
    Given : Click the secondary menu " 设施信息 "

  Scenario Outline: Check facilities information
    Given : Enter the field facilities name "<name>"
    When : Selected field facilitiestype "<type>"
    And :Click the query button
    Then :Check whether the query matches "<result>"
    Examples:
      | name  | type | result |
      | 农机仓库  | 农机库  | 农机仓库   |
      | 农机停放区 | 农机库  | 农机停放区  |
      |       | 农机库  | 农机停放区  |


  Scenario: Open view page
    Given Check View button1
    Then Closing details

  Scenario: Open the field Edit page
    Given Check Edit button
    When Modification of field name and remarks
    Then Validation results

  Scenario: out login
    Given loginout