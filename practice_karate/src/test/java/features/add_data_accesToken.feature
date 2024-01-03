Feature: posting data to the go rest using access bearer token

Background:
* url baseUrl
* def req_payload = 
"""
{
    "name":"rahulbhaii",
    "email":"rahulbhaii@gmail.com",
    "gender":"male",
    "status":"active"
}
"""

Scenario: post data using Bearer Token
Given path 'public/v2/users/'
When request req_payload
And header Authorization = bearerToken
When method POST
Then status 201
* print response
And match $.name == req_payload.name
And match $.email == req_payload.email