package testCases;


import java.io.IOException;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import signatureCreationPackage.basicAuthUtils;
import signatureCreationPackage.credentialReader;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.either;

public class addBusinessApiValidation {
	
	  credentialReader propertyReader = credentialReader.getInstance();
      basicAuthUtils authUtils = basicAuthUtils.getInstance();
      String myJsonFilePath = "src/test/resources/api/createBusinessCustomerUpdateValues.json";
	
	@Test(priority=1,dataProvider="invalidMethodNames",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void methodTestCases(String methodValues,String description) throws IOException {
		
		  String jsonContent = authUtils.readJsonFile(myJsonFilePath);
	      JSONObject reqBody = new JSONObject(jsonContent);
          reqBody.put("method", methodValues);
          String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
    
    // now we are ready with request body as a json object need to convert this into string and hit the api 
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 .log()
    		 .all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
      response.then()
     .log()
     .all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("UNAUTHORIZED"))
     .body("error.message", equalTo("Access Denied"));
     }
	
	@Test(enabled=false,priority=2,dataProvider="invalidCountryCode",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void countryCodeTestCases(String countryCodeValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONObject("address").put("country", countryCodeValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
     reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		// .log()
    		// .all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
      response.then()
    //  .log()
     // .all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("INVALID_COUNTRYCODE"))
     .body("error.message", equalTo("Invalid Country code"));
     }
	
	@Test(enabled=false,priority=3,dataProvider="invalidDateEstablished",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void dateEstablishedTestCases(String dateEstablishedValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").put("dateestablished", dateEstablishedValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
        
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message", equalTo("DateEstablished is invalid or missing"));
     }
	
	@Test(enabled=false,priority=4,dataProvider="invalidType",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void typeTestCases(String typeValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").put("type", typeValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message", equalTo("Type is invalid or missing"));
     }
	
	@Test(enabled=false,priority=5,dataProvider="invalidBusinessNameLegal",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void businessNameLegalTestCases(String businessNameLegalValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").put("businessNameLegal", businessNameLegalValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
     
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message", equalTo("BusinessNameLegal is invalid or missing"));
     }
	
	@Test(enabled=false,priority=6,dataProvider="invalidMonthlyprojectionCurrency",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void monthlyprojectionCurrencyTestCases(Object monthlyprojectionCurrencyValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONObject("monthlyprojection").put("currency", monthlyprojectionCurrencyValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message", equalTo("MonthlyProjection.Currency is invalid or missing"));
     }
	
	@Test(enabled=false,priority=7,dataProvider="invalidIdentificationType",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void identificationTypeTestCases(String identificationTypeValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONArray("identification").getJSONObject(0).put("type", identificationTypeValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
     
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message", either(equalTo("Identification[0].Type is invalid or missing")).or(equalTo("Identification Type is invalid or missing")));
     }
	
	@Test(enabled=false,priority=8,dataProvider="invalidIdentificationValue",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void identificationValueTestCases(String identificationValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONArray("identification").getJSONObject(0).put("value", identificationValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message", either(equalTo("Identification[0].Value is invalid or missing")).or(equalTo("SSN is invalid or missing")));
     }
	
	@Test(enabled=false,priority=9,dataProvider="invalidContactPhoneNumberValue",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void phoneNumberTestCases(String phoneNumberValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONObject("contact").put("phonenumber", phoneNumberValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message",either(equalTo("phoneNumber is invalid or missing")).or(equalTo("Contact.PhoneNumber is invalid or missing")));
     }
	
	@Test(enabled=false,priority=10,dataProvider="invalidContactEmailValue",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void invalidContactEmailTestCases(String emailValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONObject("contact").put("email", emailValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_INPUT"))
     .body("error.message",equalTo("Contact.Email is invalid or missing"));
     }
	
	@Test(enabled=false,priority=11,dataProvider="invalidApiCredential",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void invalidApiCredentialTestCases(String apiCredentialValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("api").put("credential", apiCredentialValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("BAD_CREDENTIAL"))
     .body("error.message",equalTo("Invalid Credential"));
     }
	
	
	@Test(enabled=false,priority=12,dataProvider="invalidApiSignature",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void invalidSignatureTestCases(String signatureValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValues);
       // String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
       // reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", equalTo("INVALID_SIGNATURE"))
     .body("error.message",equalTo("Invalid Signature"));
     }
	
	@Test(enabled=false,priority=13,dataProvider="invalidApiKeyId",dataProviderClass = testProviders.businessCustomerDataProvider.class)  
	public void invalidKeyIdTestCases(String keyIdValues,String description) throws IOException {
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        reqBody.getJSONObject("params").getJSONObject("api").put("keyId", keyIdValues);
        String signatureValue = authUtils.sign((reqBody.getJSONObject("params").getJSONObject("payload")).toString(),propertyReader.getPrivateKey());
     
     //passes the generated signature into the requestbody[json object]
        reqBody.getJSONObject("params").getJSONObject("api").put("signature", signatureValue);
     
    // now we are ready with request body as a json object need to convert this into string and hit the api
              Response response =  RestAssured
    		 .given()
    		 .baseUri("https://connectors.cbwpayments.com/PLMASTER")
    		 .header("Content-Type","application/json")
    		 .body(reqBody.toString())
    		 //.log()
    		 //.all()
    		 .when()
    		 .post("/jsonrpc");
     
     // below code is to print the response messgae to the console
    response.then()
     //.log()
     //.all()
     .statusCode(200) // Assuming you expect a 400 Bad Request
     .body("error.code", either(equalTo("NOT_FOUND_USER_DEVICE")).or(equalTo("BAD_CREDENTIAL")))
    .body("error.message",either(equalTo("User device not found")).or(equalTo("Invalid Credential")));
     }
}