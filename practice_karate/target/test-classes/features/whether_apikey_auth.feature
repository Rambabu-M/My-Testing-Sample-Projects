Feature: hit whether api 

Scenario: using api key auth
* def query_params = {q:'chennai',appid:'db1c48be62bad249d72f5582e80f942e'}

Given url weather_url
And path 'data/2.5/weather'
And params query_params
When method GET
Then status 200
* print response