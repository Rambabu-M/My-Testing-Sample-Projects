Feature: My First Feature

  Scenario: My First Scenario
    Given url baseUrl
    And method GET
    And status 200
    Then print response