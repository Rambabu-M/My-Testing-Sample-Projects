package restAssuredPackage;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restAssuredClass {
	
	
	//GET request
	@Test(enabled=false)
	public void getEmployees() {
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification reqSpec1 = RestAssured.given();
		Response resp1 = reqSpec1.request(Method.GET,"employees");
		System.out.println(resp1.asPrettyString());
		System.out.println(resp1.getStatusLine());
		System.out.println(resp1.getStatusCode());
	}
	
	//POST request
	@Test(enabled=false)
	public void addEmployees() {
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification reqSpec2 = RestAssured.given()
				.header("Content-Type","application/json")
				.body("{\n"
						+ "    \"id\": 8,\n"
						+ "    \"first name\": \"Elango\",\n"
						+ "    \"last name\": \"Arivalagan\",\n"
						+ "    \"email\": \"e.arivalagan@netxd.com\"\n"
						+ "  }");
		Response resp2 = reqSpec2.request(Method.POST,"employees");
		System.out.println(resp2.asPrettyString());
		System.out.println(resp2.getStatusLine());
		System.out.println(resp2.getStatusCode());
	}
	
	//update single record PUT
	@Test(enabled=false)
	public void updteEmployee() {
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification reqSpec3 = RestAssured.given()
				.header("Content-Type","application/json")
				.body("{\n"
						+ "    \"id\": 8,\n"
						+ "    \"first name\": \"Raguram\",\n"
						+ "    \"last name\": \"Anbalagan\",\n"
						+ "    \"email\": \"r.moorthy@netxd.com\"\n"
						+ "  }");
		Response resp3 = reqSpec3.request(Method.PUT,"employees/8");
		System.out.println(resp3.asPrettyString());
		System.out.println(resp3.getStatusLine());
		System.out.println(resp3.getStatusCode());
	}
	
	@Test
	public void deleteEmployee() {
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification reqSpec4 = RestAssured.given();
		Response resp4 = reqSpec4.request(Method.DELETE,"employees/8");
		System.out.println(resp4.asPrettyString());
		System.out.println(resp4.getStatusLine());
		System.out.println(resp4.getStatusCode());
	}
	
}
