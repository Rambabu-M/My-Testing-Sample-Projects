Feature: query parameter understanding

Scenario: passing query parameters

* def query = {status:'active',gender:'female'}
Given url baseUrl2
And params query
When method GET
Then status 200
* print response


Scenario: get the count of active members

* def query = {status:'active',gender:'female'}

Given url baseUrl2
And params query
When method GET
Then status 200
* print response
* def activeCount = response.length
* print 'active members =  '+activeCount