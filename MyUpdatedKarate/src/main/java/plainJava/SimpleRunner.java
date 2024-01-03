package plainJava;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;


public class SimpleRunner {
	
	static long ctr = 0;
	public static long seq() {
		if (ctr == 0)
		//	ctr = System.currentTimeMillis() / 1000l;
		ctr = System.currentTimeMillis();
		ctr++;
		return ctr;
	}

	public String createBasicAuthHeader(String username, String password) {
		String credentials = username + ":" + password;
		return "Basic " + java.util.Base64.getEncoder().encodeToString(credentials.getBytes());
	}

	
	/*public String sign(String payload, String pk) {
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
	}*/
	
	public String signGeneration(String payload, String pk) {
	    String cleanedKey = pk.replaceAll("-----BEGIN PRIVATE KEY-----|-----END PRIVATE KEY-----|\n", "");
	    byte[] keyBytes = Base64.decodeBase64(cleanedKey);
	    
	    String sg = "";
	    try {
	        PrivateKey privateKey = KeyFactory.getInstance("EC", "SunEC")
	                .generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
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
}
