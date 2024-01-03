Feature: My first feature file

  Scenario: Launch the reqres url get method
    Given url https://reqres.in
    When path /api/users?page=2
    And method GET
    Then status 200