Feature: My new sample feature

Scenario: My new Scenario

Given url 'https://reqres.in/api/users?page=2'
And method GET
When status 200
Then def result = response
  * def responseValue = response
  * print 'Response:', responseValue

