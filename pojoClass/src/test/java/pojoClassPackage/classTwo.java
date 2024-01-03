package pojoClassPackage;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class classTwo {

	public static void main(String[] args) throws JsonProcessingException {
		
		classOne obj = new classOne();
		obj.setFirst_name("Ranjith");
		obj.setLast_name("Kadavuldoss");
		obj.setEmial_id("r.kadavuldoss@netxd.com");
		obj.setSkills(Arrays.asList("design tool","front end design"));
		
		System.out.println(obj.getFirst_name());
		System.out.println(obj.getLast_name());
		System.out.println(obj.getEmial_id());
		System.out.println(obj.getSkills());
		
		//above is the string to convert that string into json body we needd "object mapper"
		ObjectMapper mapper = new ObjectMapper();
	    String jsonBody =   mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	
	    System.out.println(jsonBody);
	}
}
