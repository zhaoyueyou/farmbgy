@login_cp01
Feature:Check login function
  Scenario: Open login page
    Given Open login page

  Scenario Outline:
    When Enter the account number "<Account>"
    And Enter password "<Password>"
    Then Account and password prompt "<result>"
    Examples:
      | Account        | Password | result      |
      | zhaoyueyou     | Aa123456@ | zhaoyueyou |

  Scenario: out login
    Given out login