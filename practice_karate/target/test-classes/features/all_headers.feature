Feature: execute all kinds of headers

Scenario: Execute one by one header

Given header User-Agent = 'PostmanRuntime/7.29.2'
And header Accept = '*/*'
And header Accept-Encoding = 'gzip, deflate, br'
And header Connection = 'keep-alive'

Given url baseUrl
And path 'public/v2/users/2473'
When method GET
Then status 200
* print response


Scenario: passing headers in a variable

* def req_header = {User-Agent:'PostmanRuntime/7.29.2',Accept:'*/*',Accept-Encoding:'gzip, deflate, br',Connection:'keep-alive'}

Given headers req_header
When url baseUrl
Then path 'public/v2/users/2473'
And method GET
Then status 200
* print response


Scenario: passing headers as configure

* configure headers = {User-Agent:'PostmanRuntime/7.29.2',Accept:'*/*',Accept-Encoding:'gzip, deflate, br',Connection:'keep-alive'}
Given url baseUrl
And path 'public/v2/users/2473'
When method GET
Then status 200
* print response
