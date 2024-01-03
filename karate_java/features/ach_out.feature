Feature: example feature

Background:
* url plus_Url
* path "rpc/paymentv2"
* def user = legalrep
* def req = read('./payloads/ach_out.json') 
* def sig = signs(req,user)

Scenario: hit ach_out
Given request sig
When method POST
Then status 200
* print sig
 