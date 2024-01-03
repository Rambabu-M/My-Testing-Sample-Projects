Feature: Festure file to create signature


Scenario: Consuming payload and privte key and creat a signature
Given def req = read('classpath:jsonPayloads/OnboardBusinessCustomer.json')
Then set req.params.api.credential = admin_credential
Then set req.params.api.keyId = admin_keyid
# Then print 'JSON Payload:', req
Then def payloadFromReq = req.params.payload
#Then print sig
#Then print admin_private
#Then def randomNumber = seq()
#Then print randomNumber
Then def signature = signs(payloadFromReq,admin_private)
#Then print signature
Then set req.params.api.signature = signature
#Then print req