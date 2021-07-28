package Section8Jira;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

//we will learn how to send an attachment

public class Video49 {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:8080/";
		
		SessionFilter sF = new SessionFilter();
		
		given().log().all().header("Content-Type","application/json")
		.body("{ \"username\": \"smotke93\", \"password\": \"sankalp1001\" }")
.filter(sF)
		.when().post("rest/auth/1/session").then()
.extract().response().asString();
		
		given().log().all().header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data")
		.pathParam("key", "10000").multiPart("file",new File("/Users/sankalpmotke/Documents/Eclipse Java Programs/Udemy REST API/src/Section8Jira/demo.txt")).filter(sF)
		.when().post("/rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);


	}

}
