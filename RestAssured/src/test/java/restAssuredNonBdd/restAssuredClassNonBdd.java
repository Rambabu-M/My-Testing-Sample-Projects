package restAssuredNonBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class restAssuredClassNonBdd {

	@Test(enabled=false)
	public void getEmp() {
		RestAssured.given()
		.baseUri("http://localhost:3000/")
		.when().get("employees")
		.prettyPrint();
	}
	
	@Test(enabled=false)
	public void postEmp() {
		RestAssured.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body("{\n"
				+ "    \"id\": 8,\n"
				+ "    \"first name\": \"Nithu\",\n"
				+ "    \"last name\": \"Velmurugan\",\n"
				+ "    \"email\": \"n.velmurugan@netxd.com\"\n"
				+ "  }")
		.when().post("employees")
		.prettyPrint();
	}
	
	@Test(enabled=false)
	public void putEmp() {
		RestAssured.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body("{\n"
				+ "    \"first name\": \"Gomathi\",\n"
				+ "    \"last name\": \"Gommubro\",\n"
				+ "    \"email\": \"g.gommu@netxd.com\"\n"
				+ "  }")
		.when().put("employees/5")
		.prettyPrint();
	}
	
	@Test
	public void deleteEmp() {
		RestAssured.
		given().baseUri("http://localhost:3000/")
		.when().delete("employees/7");
	}
}
