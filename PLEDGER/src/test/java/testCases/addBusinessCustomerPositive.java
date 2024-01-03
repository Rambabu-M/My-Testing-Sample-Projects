package testCases;


import java.io.IOException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import signatureCreationPackage.basicAuthUtils;
import signatureCreationPackage.credentialReader;

public class addBusinessCustomerPositive {

	private String customerId;
	// getting the object of credential Reader class so you can read any cred or url or json file path or privatekey
	credentialReader propertyReader = credentialReader.getInstance();
	
	// getting the object of basicAuthUtils class so you can convert your json file content into a string
    basicAuthUtils authUtils = basicAuthUtils.getInstance();
    
    // reads the AddBusinessCustomer api file path and store it into a string data type
    
     String myJsonFilePath = "src/test/resources/api/createBusinessCustomerUpdateValues.json";
    
  // reads the AddLegalRep api file path and store it into a string data type
   // String myLegalRepJsonFilePath = propertyReader.getBusinessCustomerApiPath();
    
	
	
	@Test(priority=1)  
	public void onboardBusinessCustomer() throws IOException {
		
		  String jsonContent = authUtils.readJsonFile(myJsonFilePath);
	      JSONObject reqBody = new JSONObject(jsonContent);
          //reqBody.put("method", methodValues);
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
     .statusCode(200);
      
      customerId = response.jsonPath().getString("result.Id");
      //System.out.println("My Customer id is "+ customerId);
     }
	
	@Test(enabled=false,priority=2)  
	public void onboardLegalRep() throws IOException {
		
		  String jsonContent = authUtils.readJsonFile(myJsonFilePath);
	      JSONObject reqBody = new JSONObject(jsonContent);
          //reqBody.put("method", methodValues);
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
     .statusCode(200);
     }
	
}
