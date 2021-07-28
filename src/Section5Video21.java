import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.equalTo;

public class Section5Video21 {

public static void main(String[] args) {
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	
//add data
String responseData = 	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\n" + 
			"  \"location\": {\n" + 
			"    \"lat\": -38.383494,\n" + 
			"    \"lng\": 33.427362\n" + 
			"  },\n" + 
			"  \"accuracy\": 50,\n" + 
			"  \"name\": \"Govindarai\",\n" + 
			"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
			"  \"address\": \"29, side layout, cohen 09\",\n" + 
			"  \"types\": [\n" + 
			"    \"shoe park\",\n" + 
			"    \"shop\"\n" + 
			"  ],\n" + 
			"  \"website\": \"http://google.com\",\n" + 
			"  \"language\": \"French-IN\"\n" + 
			"}")
	.when().post("maps/api/place/add/json")
	.then().extract().response().asString();
	
	System.out.println("------=====*******=======--------");
	System.out.println(responseData);
	JsonPath jP = new JsonPath(responseData);
	String placeId =jP.getString("place_id");
	System.out.println(placeId);
	System.out.println("------=====*******=======--------");
	
	
	//update data
	System.out.println("------=====*******=======--------");
	String afterUpdation = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\n" + 
			"\"place_id\":\""+placeId+"\",\n" + 
			"\"address\":\"70 winter walk, USA\",\n" + 
			"\"key\":\"qaclick123\"\n" + 
			"}\n" + 
			"")
	.when().put("maps/api/place/update/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println("afterUpdation------" +afterUpdation);
	System.out.println("------=====*******=======--------");
	
	//get updated data
	given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
	.when().get("maps/api/place/get/json")
	.then().log().all().statusCode(200);
	
}
}
