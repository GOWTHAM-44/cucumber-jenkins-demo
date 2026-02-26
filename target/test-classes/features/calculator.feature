Feature: Calculator functionality 
 
  @smoke 
  Scenario: Add two numbers 
    Given I have numbers 2 and 3 
    When I add the numbers 
    Then the result should be 5 
 
  @regression 
  Scenario: Subtract two numbers 
    Given I have numbers 10 and 4 
    When I subtract the numbers 
    Then the result should be 6