import org.junit.jupiter.api.Test;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Section7Video37 {

	@Test
	public void Test() {
		RestAssured.baseURI="http://216.10.245.166";
		
		//saving single book details 
		String responseBody = given().header("Content-Type","application/json").body(payLoad.Section7Body("A6","007012","070712","Sam"))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Response Received is "+responseBody);
		
		//JsonPath js = new JsonPath(responseBody);
		//int bookId = js.get("ID");
		//System.out.println("ID is "+bookId);
		
		//delete given book
//		String deleteResponse = given().header("Content-Type","application/json").body("{\n" + 
//				" \n" + 
//				"\"ID\" : "+bookId+"\n" + 
//				" \n" + 
//				"} \n" + 
//				"")
//		.when().put("Library/DeleteBook.php")
//		.then().assertThat().statusCode(200).extract().response().asString();
//		
//		System.out.println(deleteResponse);
	} 
}
