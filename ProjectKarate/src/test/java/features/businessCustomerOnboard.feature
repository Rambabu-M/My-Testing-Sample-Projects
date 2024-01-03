Feature: Onboard Business Customer

Scenario: print the request body
* def req = read('CustomerOnboard.json')
* print req