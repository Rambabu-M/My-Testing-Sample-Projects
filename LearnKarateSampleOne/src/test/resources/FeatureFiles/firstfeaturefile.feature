Feature: My First Feature

  Scenario: My First Scenario
    Given url 'https://reqres.in/api/users?page=2'
    And method GET
    And status 200
    Then print response