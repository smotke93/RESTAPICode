import files.payLoad;
import io.restassured.path.json.JsonPath;

//now we will learn how to traverse complex JSON files.

public class Section6Video25 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payLoad.coursePrice());
		
		//1. Print No of courses returned by API
		int courseSize = js.getInt("courses.size()");
		System.out.println("The no of courses in JSON are = "+courseSize);
		
		//2. Print Purchase Amount
		System.out.println("\nThe purchased amount is = "+js.getInt("dashboard.purchaseAmount"));

		//3. Print Title of the first course
		System.out.println("\nFirst course title = "+js.get("courses[0].title"));

		//4. Print All course titles and their respective Prices
		for(int i=0; i<courseSize; i++) {
			System.out.println("\nTitle "+js.get("courses["+i+"].title")+"\n Price "+ js.get("courses["+i+"].price"));
		}

		//5. Print no of copies sold by RPA Course
		for(int i=0; i<courseSize; i++) {
			String titleName = js.get("courses["+i+"].title");
			if(titleName.equalsIgnoreCase("RPA")) {
				System.out.println("\nThe no of copies sold by RPA are :"+js.get("courses["+i+"].copies"));
				break;
			}
		}
		int sumOfPrices = 0;
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		for(int i=0; i<courseSize; i++) {
			int j =js.getInt("courses["+i+"].price");
			int k =js.getInt("courses["+i+"].copies");
			int total =k*j;
			sumOfPrices = sumOfPrices+ total ;
				
		}
		System.out.println(sumOfPrices);
		if(sumOfPrices==js.getInt("purchaseAmount")) {
			System.out.println("\nThe sum is matches i.e "+sumOfPrices+"\t"+js.getInt("purchaseAmount"));
		}
	}

}
