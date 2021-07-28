package files;

public class payLoad {

	public static String getMessageBody() {
		return "{\n" + 
				"    \"location\": {\n" + 
				"        \"latitude\": \"-38.383494\",\n" + 
				"        \"longitude\": \"33.427362\"\n" + 
				"    },\n" + 
				"    \"accuracy\": \"50\",\n" + 
				"    \"name\": \"Govindarai\",\n" + 
				"    \"phone_number\": \"(+91) 983 893 3937\",\n" + 
				"    \"address\": \"29, side layout, cohen 09\",\n" + 
				"    \"types\": \"shoe park,shop\",\n" + 
				"    \"website\": \"http://google.com\",\n" + 
				"    \"language\": \"French-IN\"\n" + 
				"}";
	}
	
	public static String coursePrice()
	{
		return "{\n" + 
				"\n" + 
				"\"dashboard\": {\n" + 
				"\n" + 
				"\"purchaseAmount\": 910,\n" + 
				"\n" + 
				"\"website\": \"rahulshettyacademy.com\"\n" + 
				"\n" + 
				"},\n" + 
				"\n" + 
				"\"courses\": [\n" + 
				"\n" + 
				"{\n" + 
				"\n" + 
				"\"title\": \"Selenium Python\",\n" + 
				"\n" + 
				"\"price\": 50,\n" + 
				"\n" + 
				"\"copies\": 6\n" + 
				"\n" + 
				"},\n" + 
				"\n" + 
				"{\n" + 
				"\n" + 
				"\"title\": \"Cypress\",\n" + 
				"\n" + 
				"\"price\": 40,\n" + 
				"\n" + 
				"\"copies\": 4\n" + 
				"\n" + 
				"},\n" + 
				"\n" + 
				"{\n" + 
				"\n" + 
				"\"title\": \"RPA\",\n" + 
				"\n" + 
				"\"price\": 45,\n" + 
				"\n" + 
				"\"copies\": 10\n" + 
				"\n" + 
				"}\n" + 
				"\n" + 
				"]\n" + 
				"\n" + 
				"}";
	}
	
	public static String Section7Body(String name, String isbn, String aisle, String AuthorName) {
		
return "{\n" + 
		"\n" + 
		"\"name\":"+name+",\n" + 
		"\"isbn\":"+isbn+",\n" + 
		"\"aisle\":"+aisle+",\n" + 
		"\"author\":"+AuthorName+"\n" + 
		"}\n" + 
		"";
			

	}
}
