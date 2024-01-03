Feature: Onboard Business Customer

Scenario: print the request body
* url baseUrl
* path 'jsonrpc'
* def req = read('classpath:ApiRequests/CustomerOnboard.json')
* print req 
* def user = admin
* print user
* def reandomNumber = seqNumber()
* print reandomNumber
* req.params.api.credential = user.credential
* req.params.api.keyId = user.keyId
* print req
* def sig = signs(req,user)
* req.params.api.signature = sig
* print req
