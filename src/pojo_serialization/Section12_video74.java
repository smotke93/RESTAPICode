package pojo_serialization;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section12_video74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(100);
		addPlace.setAddress("BNCOE pusad");
		addPlace.setLanguage("English");
		addPlace.setName("Sankalp");
		addPlace.setPhone_number("121212");
		addPlace.setWebsite("facebook.com");

		List<String> typeList = new ArrayList<String>();
		typeList.add("Tanishq");
		typeList.add("Motke");
		addPlace.setTypes(typeList);
		
		Locations l = new Locations();
		l.setLat(123445.99);
		l.setLng(-12.2324);
		addPlace.setLocation(l);
		
		String response = given().queryParam("key", "qaclick123")
		.body(addPlace)
		.when().post("/maps/api/place/add/json")
		.then().extract().response().asString();
		
		System.out.println(response);
		
	}

}
