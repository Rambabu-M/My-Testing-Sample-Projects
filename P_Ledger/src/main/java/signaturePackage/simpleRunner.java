package signaturePackage;


import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import de.taimos.totp.TOTP;

public class simpleRunner {

	public static Map<String, String> map = new HashMap<String, String>();

	public static String put(String name, String value) {
		map.put(name, value);
		return value;
	}
	
		public static String get(String key) {
		       return map.get(key);
			}
		static long ctr = 0;
		
		public static String btoa(String inp) {
			return java.util.Base64.getEncoder().encodeToString(inp.getBytes());
		}

		public static long seq() {
			if (ctr == 0)
				ctr = System.currentTimeMillis() / 1000l;
			ctr++;
			return ctr;
		}
		
		public static String sign(String payload, String pk) {
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
		
		public static String[] genKP() throws Exception {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "SunEC");
			keyGen.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());
			KeyPair kp = keyGen.generateKeyPair();

			String prs = java.util.Base64.getEncoder().encodeToString(kp.getPrivate().getEncoded());
			String pbs = "-----BEGIN PUBLIC KEY-----\n" + Base64.encodeBase64String(kp.getPublic().getEncoded())
					+ "\n-----END PUBLIC KEY-----";
			return new String[] { prs, pbs };
		}
		
		public static String getTOTPCode(String secretKey) {
		    Base32 base32 = new Base32();
		    byte[] bytes = base32.decode(secretKey);
		    String hexKey = Hex.encodeHexString(bytes);
		    return TOTP.getOTP(hexKey);
		}
}
