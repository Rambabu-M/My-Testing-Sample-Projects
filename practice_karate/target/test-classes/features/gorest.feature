Feature: get the gorest.in site

Scenario: successfull response

Given url baseUrl
And path 'public/v2/users'
When method GET
Then status 200
 * print response
 * def responseBody = response
 * print responseBody[1].name
 

Scenario: 404 response

Given url baseUrl
And path 'public/v2/users/1'
When method GET
Then status 404