Feature: get api request from seperate folder

Background: 
* url baseUrl
* def req_payload = read('classpath:src/test/resources/payloads/user.json') 


Scenario: read api request payload from seperate folder
Given path 'public/v2/users/'
And request req_payload
And header Authorization = bearerToken
When method POST
Then status 201
* print response

