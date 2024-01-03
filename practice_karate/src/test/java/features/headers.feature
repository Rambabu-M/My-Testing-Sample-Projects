Feature: adding headers in sceanrio

Scenario: mention the headers in the feature file
Given header User-Agent = 'PostmanRuntime/7.29.2'
And header Accept = '*/*'
And header Accept-Encoding = 'gzip, deflate, br'
And header Connection =  'keep-alive'

Given url baseUrl
And path 'public/v2/users/2473'
When method GET
Then status 200
* print response

Scenario: headers part 2
* def header_params = {User-Agent:'PostmanRuntime/7.29.2',Accept:'/*',Accept-Encoding:'gzip, deflate, br',Connection:'keep-alive'}
Given headers header_params
When url baseUrl
And path 'public/v2/users/2473'
When method GET
Then status 200
* print response