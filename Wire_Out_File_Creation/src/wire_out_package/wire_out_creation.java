package wire_out_package;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class wire_out_creation {
	 public static void main(String[] args) {
	        try {
	            // Read the original wire_out file
	            String originalContent = readFile("wire_out.txt");

	            // Create a list to store batch entries
	            List<String> batchEntries = new ArrayList<>();

	            while (true) {
	                // Prompt the user for a name
	                System.out.print("Enter a name (or type 'exit' to finish): ");
	                String name = new Scanner(System.in).nextLine();

	                if ("exit".equalsIgnoreCase(name)) {
	                    break;
	                }

	                // Create a new content with "HTTPOOL LLC" replaced by the current name
	                String replacedContent = replaceNameInContent(originalContent, name);
	                batchEntries.add(replacedContent);
	            }

	            // Create the batch file content by joining entries with '$'
	            String batchFileContent = String.join("$", batchEntries);

	            // Write the batch file
	            writeFile("wire_out_batch.txt", batchFileContent);

	            System.out.println("Batch file created successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static String replaceNameInContent(String content, String name) {
	        // Use a regular expression to replace "HTTPOOL LLC" with the name
	        String regex = "(?i)HTTPOOL\\s+LLC";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(content);
	        return matcher.replaceAll(name);
	    }

	    private static String readFile(String filename) throws IOException {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        }
	        return content.toString();
	    }
	    private static void writeFile(String filename, String content) throws IOException {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
	            writer.write(content);
	        }
	    }
}
