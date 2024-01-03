package JsonToJsonString;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonPayloadProcessor {

    public static void main(String[] args) {
        // Assuming your JSON files are in a folder named "payloads" within your project
        File folder = new File("src");

        // Process JSON payloads
        Map<String, String> uniqueKeysPayload = getUniqueKeysPayload(folder);

        // Print the resulting payload
        System.out.println("Unique Keys Payload: " + uniqueKeysPayload);
    }

    private static Map<String, String> getUniqueKeysPayload(File folder) {
        Map<String, String> uniqueKeysPayload = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        // Check if the folder exists
        if (folder.exists() && folder.isDirectory()) {
            // Iterate through files in the folder
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        JsonNode jsonNode = objectMapper.readTree(file);

                        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
                        while (fields.hasNext()) {
                            Map.Entry<String, JsonNode> entry = fields.next();
                            String key = entry.getKey();
                            String value = entry.getValue().asText();

                            // Add the key-value pair to the uniqueKeysPayload if the key is not already present
                            if (!uniqueKeysPayload.containsKey(key)) {
                                uniqueKeysPayload.put(key, value);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return uniqueKeysPayload;
    }
}