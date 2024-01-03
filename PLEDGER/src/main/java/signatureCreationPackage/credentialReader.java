package signatureCreationPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class credentialReader {
	private static credentialReader instance;
    private Properties properties = new Properties();

    private credentialReader() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/configFile.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static credentialReader getInstance() {
        if (instance == null) {
            instance = new credentialReader();
        }
        return instance;
    }

    public String getUsername() {
        return properties.getProperty("userName");
    }
    
    public String getInvalidUsername() {
        return properties.getProperty("invalidUserName");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getDeviceId() {
        return properties.getProperty("deviceId");
    }

    public String getGAuth() {
        return properties.getProperty("gAuth");
    }

    public String getPrivateKey() {
        return properties.getProperty("privateKey");
    }

    public String getPublicKey() {
        return properties.getProperty("publicKey");
    }
    
    public String getBusinessCustomerRequestPath() {
        return properties.getProperty("businessCustomerRequestPath");
    }

}
