import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Library_Parameters {

	
		@Test
		public void addbook()
		{
			RestAssured.baseURI="http://216.10.245.166";
			String resp=given().log().all().header("Content-Type","application/json")
			.body(Payload.addBook("adfff","55666")).when()
			.post("/Library/Addbook.php").then().log().all().statusCode(200)
			.extract().asString();
			
			JsonPath js=ReusableMethods.reToJson(resp);
			String id=js.get("ID");
			System.out.println(id);
		}

	

}
