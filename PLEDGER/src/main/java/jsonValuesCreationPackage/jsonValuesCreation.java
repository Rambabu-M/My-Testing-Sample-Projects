package jsonValuesCreationPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.json.JSONObject;
import org.testng.annotations.Test;

import signatureCreationPackage.basicAuthUtils;
import signatureCreationPackage.credentialReader;

public class jsonValuesCreation {
// Class will execute first and update the Business Customer Onboard Api with new Values for the Keys[buinessNameLegal,SSN number,phone number & EMail]
// I mentiond this class to execute first in the testNg.xml file
	basicAuthUtils authUtils = basicAuthUtils.getInstance();
    credentialReader propertyReader = credentialReader.getInstance();
    
	@Test
	 public void createBusinessCustomerRandomValues() throws IOException {
        
		String myJsonFilePath = "src/test/resources/api/createBusinessCustomerUpdateValues.json";
       // String myJsonFilePath = propertyReader.getBusinessCustomerRequestPath();
        String jsonContent = authUtils.readJsonFile(myJsonFilePath);
        JSONObject reqBody = new JSONObject(jsonContent);
        String businessName = "Corporate" + generateRandomString(5);
        reqBody.getJSONObject("params").getJSONObject("payload").put("businessNameLegal", businessName);
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONArray("identification").getJSONObject(0).put("value", generateTimestampBasedValue(9));
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONObject("contact").put("phonenumber", generateTimestampBasedValue(10));        
        reqBody.getJSONObject("params").getJSONObject("payload").getJSONObject("contact").put("email", businessName + "@netxd.com");
        System.out.println("updated json file is "+ reqBody);
   
        
            // Write the JSON object to the file
            FileWriter fileWriter = new FileWriter(myJsonFilePath);
            fileWriter.write(reqBody.toString(4)); // Use 4 for pretty printing
            fileWriter.close();
	 }


    // Generate a random string with the specified length
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    // Generate a random numeric string with the specified length
    private static String generateTimestampBasedValue(int length) {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSSS");
        String timestamp = dateFormat.format(new Date(currentTimeMillis));
        
        // Ensure the length is not greater than the timestamp length
        length = Math.min(length, timestamp.length());
        
        // Generate a random substring of the timestamp
        return timestamp.substring(0, length);
    }
}
