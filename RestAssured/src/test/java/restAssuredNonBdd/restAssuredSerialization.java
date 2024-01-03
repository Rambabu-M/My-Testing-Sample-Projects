package restAssuredNonBdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class restAssuredSerialization {
	@Test
	public void serialization() {
		
		Map<String,Object> jsonData = new HashMap<String,Object>();
		
		List<String> skillsList = new ArrayList<String>();
		skillsList.add("python");
		skillsList.add("AI Tools");
		skillsList.add("selenium");
		
		jsonData.put("id", 15);
		jsonData.put("first name", "Rahul");
		jsonData.put("last name", "Bhaai");
		jsonData.put("email", "r.bhaai@netxd.com");
		jsonData.put("skills", skillsList);
		
	    System.out.println("my request body is  "+ jsonData);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.header("Content-Type","application/json")
		.body(jsonData)
		.log()
		.all()
		.when().post("employees")
		.then()
		.log()
		.all();	
	}
}
