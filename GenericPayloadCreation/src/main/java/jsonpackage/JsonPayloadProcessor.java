package jsonpackage;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonPayloadProcessor {

	 public static void main(String[] args) {
	        // Assuming your JSON files are in the "src/test/resources/payloads" folder
	        File payloadsFolder = new File("src/test/resources/payloads");

	        // Create a generic payload with all unique keys prioritizing non-null values
	        String genericPayload = createGenericPayloadFromFolder(payloadsFolder);

	        // Print the resulting payload
	        System.out.println("Generic Payload: " + genericPayload);
	    }

	    private static String createGenericPayloadFromFolder(File folder) {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Set<String> allKeys = new HashSet<>();

	        // Check if the folder exists
	        if (folder.exists() && folder.isDirectory()) {
	            // Iterate through files in the folder
	            File[] files = folder.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    try {
	                        JsonNode jsonNode = objectMapper.readTree(file);

	                        // Collect all unique keys from all payloads
	                        collectUniqueKeys(jsonNode, allKeys);

	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }

	        // Create a generic payload with all unique keys prioritizing non-null values
	        ObjectNode genericNode = objectMapper.createObjectNode();
	        for (String key : allKeys) {
	            // Set the value prioritizing non-null values
	            genericNode.set(key, getNonNullValue(key, folder, objectMapper));
	        }

	        // Convert the genericNode to a JSON string
	        try {
	            return objectMapper.writeValueAsString(genericNode);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "{}"; // Return an empty JSON object in case of an error
	        }
	    }

	    private static JsonNode getNonNullValue(String key, File folder, ObjectMapper objectMapper) {
	        // Check each file for the non-null value of the key
	        File[] files = folder.listFiles();
	        if (files != null) {
	            for (File file : files) {
	                try {
	                    JsonNode jsonNode = objectMapper.readTree(file);
	                    JsonNode valueNode = jsonNode.get(key);

	                    if (valueNode != null && !valueNode.isNull()) {
	                        // Return the non-null value
	                        return valueNode;
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        // Return null if the key doesn't exist or all values are null
	        return objectMapper.nullNode();
	    }

	    private static void collectUniqueKeys(JsonNode node, Set<String> allKeys) {
	        Iterator<String> fieldNames = node.fieldNames();

	        while (fieldNames.hasNext()) {
	            allKeys.add(fieldNames.next());
	        }
	    }
	}
