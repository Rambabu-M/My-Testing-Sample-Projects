package knowledgeTransferPackage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;

public class knowledgeTransferClass {
	
	public static String readJsonFile(String filePath) throws IOException {
		File jsonFile = new File(filePath);
		 byte[] jsonBytes = Files.readAllBytes(jsonFile.toPath());
         return new String(jsonBytes, StandardCharsets.UTF_8);
	}
	
public static String pk = "-----BEGIN PRIVATE KEY-----\n"
			+ "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgnpsE1/CUF+hPYF1f\n"
			+ "ii66QipvIU+23cx+NL8AETqwnlGhRANCAAS4tBHD4T2zF7pcANmMIgbaubCc5HwV\n"
			+ "B8/pHI9MbDT7QxXTu/3v7EmcKd9rz4/sqqMl4RNwP7WOqg49NelUT7A2\n"
			+ "-----END PRIVATE KEY-----";
	
	
	
	public String basicAuthentication(String username, String password) {
		String credentials = username + ":" + password;
		return "Basic " + java.util.Base64.getEncoder().encodeToString(credentials.getBytes());
	}
	
	public String signature(String payload, String pk) {
		String pkey = pk.replaceAll("BEGIN EC PRIVATE KEY|END EC PRIVATE KEY|BEGIN PRIVATE KEY|END PRIVATE KEY|\n| |-",
				"");

		byte[] fromPEM = Base64.decodeBase64(pkey);
		String sg = "";
		try {
			PrivateKey privateKey = KeyFactory.getInstance("EC", "SunEC")
					.generatePrivate(new PKCS8EncodedKeySpec(fromPEM));
			Signature signature = Signature.getInstance("SHA256withECDSA", "SunEC");
			signature.initSign(privateKey);
			signature.update(payload.getBytes("UTF-8"));
			byte[] bytes = signature.sign();
			sg = java.util.Base64.getEncoder().encodeToString(bytes);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sg;
	
	}

	public static void main(String[] args) throws IOException {
		
		knowledgeTransferClass obj  = new knowledgeTransferClass();
		
	//	Execution for Basic Authentication
		
		/*  Scanner scanner = new Scanner(System.in);
		
		  System.out.println("Enter the username: ");
		  String username = scanner.nextLine();
		  
		  System.out.println("Enter the password: ");
		  String password = scanner.nextLine();
		  
		  String  authorizationString =  obj.basicAuthentication(username,password);
		  System.out.println(authorizationString);*/
		
		// Execution for Signature Creation
		
		String myJsonFilePath = "CustomerOnboardApi.json";
		String jsonContent = readJsonFile(myJsonFilePath);
		
		//System.out.println(jsonContent);
		
		String Signature = obj.signature(myJsonFilePath, pk);
		
		System.out.println(Signature); 
		
	}
}
