package signaturePackage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

 public class basicAuthUtils {
	
	private static basicAuthUtils instance;
	
	// constructor of this class
	 private basicAuthUtils() {
	    }
	 
	 // getInstance is the method creates an object
	 public static basicAuthUtils getInstance() {
	        if (instance == null) {
	            instance = new basicAuthUtils();
	        }
	        return instance;
	    }

	// creating this class as a Singleton Class so that we can create object at one place and consume it in the overall project
	
	/*public static String createBasicAuthHeader(String username, String password) {
        String credentials = username + ":" + password;
        String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        return "Basic " + base64Credentials;
    }*/
	

	public String createBasicAuthHeader(String username, String password) {
		String credentials = username + ":" + password;
		return "Basic " + java.util.Base64.getEncoder().encodeToString(credentials.getBytes());
	}
	
	public String sign(String payload, String pk) {
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
	
	public String readJsonFile(String filePath) throws IOException {
		File jsonFile = new File(filePath);
		 byte[] jsonBytes = Files.readAllBytes(jsonFile.toPath());
         return new String(jsonBytes, StandardCharsets.UTF_8);
	}
}
