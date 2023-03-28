import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DatafromFile {

	

		@Test
		public void addbook() throws IOException
		{
			RestAssured.baseURI="http://216.10.245.166";
			String resp=given().log().all().header("Content-Type","application/json")
			.body(new String (Files.readAllBytes(Paths.get("C:\\Users\\Prachi Jadhav\\OneDrive\\Desktop\\REST_15FEb\\Addbook.json")))).when()
			.post("/Library/Addbook.php").then().log().all().statusCode(200)
			.extract().asString();
			
			System.out.println(resp);
			JsonPath js=new JsonPath(resp);
			String id=js.get("ID");
			System.out.println(id);
			
		}

	

	

}
