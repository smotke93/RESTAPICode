package pojo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Sec11_Pojo_Deserialization {

	public static void main(String[] args) {

		//send this link and collect the code
		//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
		
		String code="4%2F1QFgMB-IBwhzNScNudUsvg4wEwJPFpHUahVAC5hwahXTHpg26ZFeTtC5bl69P55H6_jVbxE8tuD6voRw5d30ZB8";
		
		String authentication = given().log().all().urlEncodingEnabled(false)
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("grant_type", "authorization_code")
		.queryParams("state", "verifyfjdss")
		.queryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token")
		.asString();
		
		//System.out.println(authentication);
		
		JsonPath jP = new JsonPath(authentication);
		String accessToken = jP.get("access_token");
		
		GetCourse gc = given()
		.queryParam("access_token", accessToken)
		.expect().defaultParser(Parser.JSON)
		.when()
        .get("https://rahulshettyacademy.com/getCourse.php")
        .as(GetCourse.class);
		System.out.println("--------------**************--------------");
		System.out.println("Instructor name"+gc.getInstructor());
		
		List<Api> api =gc.getCourses().getApi();
		for(int i=0; i<api.size();i++) {
			if(api.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println("Price of course "+api.get(i).getPrice());
				
			}
		}
	}

}
