package ReqRespSpecBuilder;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo_serialization.AddPlace;
import pojo_serialization.Locations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section13_video78 {

	public static void main(String[] args) {
   
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(100);
		addPlace.setAddress("BNCOE pusad");
		addPlace.setLanguage("English");
		addPlace.setName("Sankalp");
		addPlace.setPhone_number("121212");
		addPlace.setWebsite("facebook.com");

		List<String> typeList = new ArrayList<String>();
		typeList.add("Tamishq");
		typeList.add("Motke");
		addPlace.setTypes(typeList);
		
		Locations l = new Locations();
		l.setLat(123445.99);
		l.setLng(-12.2324);
		addPlace.setLocation(l);
		

		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification response = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
		RequestSpecification requestQuery = given().spec(request).body(addPlace);		
		String res = requestQuery
		.when().post("/maps/api/place/add/json")
		.then().spec(response).extract().asString();
	
		System.out.println(res);
		
	}

}
