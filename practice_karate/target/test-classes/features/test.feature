Feature: welcome the user with greeting message

Scenario: Saying Hi to the user

 * print 'Hello new user'
 * print 'Karate API testing welcomes you'
 
Scenario: Declare variables and print it

 * def num1 = 10
 * def num2 = 20
 * print 'total = '+(num1+num2)
 
 Scenario: print the jsonObject
 
  * def jsonBody =
  """
          {"method":"ledger.ach.transfer","id":"1","params":{"payload":{"channel":"ACH","transactionType":"ACH_OUT","product":"PL","program":"100000000145003","transactionDateTime":"2022-08-29 06:20:30","reference":"REFACHOUT021","reason":"Settlement","transactionAmount":{"amount":"16666","currency":"USD"},"debtor":{"userType":"INDIVIDUAL","identification":"89900200002","identificationType":"SSN","firstName":"Craig","middleName":"Brathwaite","lastName":"Nick"},"debtorPostalAddress":{"addressType":"HOUSE","addressLine1":"3745SWWanamakerRD","addressLine2":"SuiteC","city":"Topeka","state":"KS","zipCode":"66610","countryCode":"840"},"debtorContact":{"primaryEmail":"craig@netxd.com","primaryPhone":"7850010001"},"debtorAccount":{"identification":"200533318420383","identificationType":"ACCOUNT_NUMBER","institution":{"name":"CBWBANK","identification":"101110802","identificationType":"ABA"}},"creditor":{"userType":"INDIVIDUAL","identification":"89900200002","identificationType":"SSN","firstName":"Andy","_middleName":"Lee","lastName":"Prescott"},"creditorPostalAddress":{"addressType":"HOUSE","addressLine1":"3745SWWanamakerRD","addressLine2":"SuiteC","city":"Topeka","state":"KS","zipCode":"66610","countryCode":"840"},"creditorContact":{"primaryEmail":"aprescott@demobank.com","primaryPhone":"7850010001"},"creditorAccount":{"identification":"20003355930","identificationType":"ACCOUNT_NUMBER","identificationType2":"SAVINGS","institution":{"name":"SALISBURY BANK & TRUST CO","identification":"011102612","identificationType":"ABA"}}}},"api":{"credential":"Basic bmlja2VsQG5ldHhkLmNvbTo4YjEyNmEwOTI4NGM0MmNkODdlYmNmNmZmYTU5Yjk3MQ==","signature":"{{signature}}","apiKey":"8b126a09284c42cd87ebcf6ffa59b971"}}
  """
  * print jsonBody
  * print jsonBody.params.payload.transactionAmount.amount

 