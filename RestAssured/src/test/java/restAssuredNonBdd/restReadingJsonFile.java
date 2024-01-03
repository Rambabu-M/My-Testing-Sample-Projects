package restAssuredNonBdd;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class restReadingJsonFile {

	
	//create a json file , i created in the anem of employeeJson.json in the Project
	@Test
	public void addEmpFromJsonFile() {
		File myJsonFile = new File("employeeJson.json");
		RestAssured
		.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body(myJsonFile)
		.log()
		.all()
		.when()
		.post("employees")
		.prettyPrint();
	}
}
