package OAuth;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class Section10Video61 {

	public static void main(String[] args) {

		//send this link and collect the code
		//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
	
//https://rahulshettyacademy.com/getCourse.php?
//code=4%2F1AHvVivywJ1nfjaVqNY_HSNqMU_LNYtdgNra56V3nWVwgOBx6u5QNDv6ElPPAZ-JH6kqYSTKkwG0u-VZh9XVRjM
		//&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=consent#
	
		
		
		String code="4%2F1AE3re-v-mtq5DiewxnYSIjt5l8oD8F-eU8XkIaZ4M35B179VlPnqaQFvztvod40aRLqi-3TT1_sVBHY_IwOp8k";
		
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
		
		System.out.println(authentication);
		
		JsonPath jP = new JsonPath(authentication);
		String accessToken = jP.get("access_token");
		
		String courses = given().contentType("application/json")
		.queryParam("access_token", accessToken)
		.when()
        .get("https://rahulshettyacademy.com/getCourse.php")
        .asString();
		
		System.out.println(courses);
	}

}
