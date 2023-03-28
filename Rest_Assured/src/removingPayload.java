import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import Files.Payload;
import io.restassured.RestAssured;

public class removingPayload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("/maps/api/place/add/json")
		.then().assertThat().log().all().statusCode(200).body("scope",equalTo("APP"))
		.header("Server","Apache/2.4.41 (Ubuntu)");
	}

}
