package Section8Jira;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class Video47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://localhost:8080/";
		
		SessionFilter sessionFilter = new SessionFilter();
		
		String connectionToken = given().log().all().header("Content-Type","application/json")
				.body("{ \"username\": \"smotke93\", \"password\": \"sankalp1001\" }")
		.filter(sessionFilter)
				.when().post("rest/auth/1/session").then()
		.extract().response().asString();
		
		//look below we are using path parameters
		String addCommentSuccessfull = given().header("Content-Type","application/json")
		.pathParam("id", "10000")
		.body("{\n" + 
				"    \"body\": \"This is my firs comment through RESTAssured using session filter\",\n" + 
				"    \"visibility\": {\n" + 
				"        \"type\": \"role\",\n" + 
				"        \"value\": \"Administrators\"\n" + 
				"    }\n" + 
				"}")
		.filter(sessionFilter)
		.when().post("rest/api/2/issue/{id}/comment")
		.then().extract().response().asString();
		
		System.out.println(addCommentSuccessfull);
	}

}
