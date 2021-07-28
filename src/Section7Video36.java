import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class Section7Video36 {

	//here we will read the JSON file and sent the details in the body()
	//steps:-
	//1. Read the file and convert to BYTES
	//2. Convert from BYTES to String
	
	@Test
	public void readBodyFromFile() throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given().log().all().queryParam("Key", "qaclick123").header("Context-Type","application/JSON")
		.body(new String(Files.readAllBytes(Paths.get("/Users/sankalpmotke/Documents/Eclipse Java Programs/Udemy REST API/src/ReadJSONFile.json"))))
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
	}
	
}