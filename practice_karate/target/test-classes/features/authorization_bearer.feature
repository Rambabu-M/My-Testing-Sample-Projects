Feature: Assume hit the api with bearer token

Scenario: bearer token added to header

Given header Authorization = bearerToken
When url baseUrl
And path 'public/v2/users'
And method GET
Then status 200
* print bearerToken
* print response