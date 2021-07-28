import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import files.payLoad;

//we are gng to learn, how to store the response from server and pick specific data from the json,
//with the help of JsonPath class
//now i hve extracted the place_id and in next program i will use it to update the address
public class Section5Video20 {
public static void main(String[] args) {
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	

String responseData = 	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(payLoad.getMessageBody())
	.when().post("maps/api/place/add/json")
	.then().extract().response().asString();
	
	System.out.println("------=====*******=======--------");
	System.out.println(responseData);
	JsonPath jP = new JsonPath(responseData);
	String placeId =jP.getString("place_id");
	System.out.println("------=====*******=======--------");
	System.out.println(placeId);
	
	
}
}
