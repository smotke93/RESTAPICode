package Section8Jira;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Video52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI ="http://localhost:8080/";
		
		SessionFilter sF= new SessionFilter();

		//authentication
		given().log().all().header("Content-Type","application/json")
		.body("{ \"username\": \"smotke93\", \"password\": \"sankalp1001\" }")
.filter(sF)
		.when().post("rest/auth/1/session").then()
.extract().response().asString();
		
		//add comment 
		String message = "Full end to end testing scenario comment";
		
		String commentResponse = given().header("Content-Type","application/json")
		.pathParam("key", "10000")
		.body("{\n" + 
				"    \"body\": "+message+",\n" + 
				"    \"visibility\": {\n" + 
				"        \"type\": \"role\",\n" + 
				"        \"value\": \"Administrators\"\n" + 
				"    }\n" + 
				"}")
		.filter(sF)
		.when().post("rest/api/2/issue/{key}/comment")
		.then().extract().response().asString();
		
		JsonPath jP = new JsonPath(commentResponse);
		String commentId =	jP.get("id");
		
		//get Issue
		String issueDetails=given().filter(sF).pathParam("key", "10000")

				.queryParam("fields", "comment")

				.log().all().when().get("/rest/api/2/issue/{key}").then()

				.log().all().extract().response().asString();

				System.out.println(issueDetails);

				JsonPath js1 =new JsonPath(issueDetails);

				int commentsCount=js1.getInt("fields.comment.comments.size()");
		

				for(int i=0;i<commentsCount;i++)

				{

				String commentIdIssue =js1.get("fields.comment.comments["+i+"].id").toString();

				if (commentIdIssue.equalsIgnoreCase(commentId))

				{

				String message2= js1.get("fields.comment.comments["+i+"].body").toString();

				System.out.println(message2);

				

				}

				}
	}

}
