import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class Dynamic_API {

	@Test(dataProvider="BookData")
	public void addbook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().log().all().header("Content-Type","application/json")
		.body(Payload.addBook(isbn,aisle)).when()
		.post("/Library/Addbook.php").then().log().all().statusCode(200)
		.extract().asString();
		
		JsonPath js=ReusableMethods.reToJson(resp);
		String id=js.get("ID");
		System.out.println(id);
	}
	//delete book
	@DataProvider(name="BookData")
	public Object[][] getdata()
	{
		//array collection of arrays
		return new Object[][]{{"sdssdsd","56667"},{"sdsdssw","56681"},{"sscvcvv","56669"}};
	}
}
