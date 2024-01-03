Feature: Ach Out

Scenario: positive flow
* url plus_Url
* path '/rpc/paymentv2'
* def user = legalrep
* def req = read('./plus_payloads/ACH_OUT.json')
* req.params.payload.reference = referenceNumber('ref')
* req.api.credential = user.credentials
* req.api.apiKey = user.apikey
* def ach_out_req = signs(req,user)
* print ach_out_req
* request ach_out_req
* method post
* status 200