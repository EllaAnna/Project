@smoke @regression
Feature: Testing Login Functionality for OpenMrs

  Scenario: Positive Login Functionality(Happy Path)
    Given User provides the 'QA_username' and 'QA_password' with login
    Then User validates the 'Ecommerce App' and 'http://codefish-io-qa.s3-website-ap-northeast-1.amazonaws.com/home'

  Scenario Outline: Negative Login Functionality
    Given User provides '<username>' and '<password>'
    Then User validates 'Authentication failed'
    Examples:
      | username | password |
      | Ellen    | 12345    |
      | jkdgyuy  | 1313     |
      | 0        | 0        |
      | 1234     | Admin    |
      | $%$%$%   | %^%^%^   |
      | ELLEN    | 1313     |
      | ellen    | 1313     |

