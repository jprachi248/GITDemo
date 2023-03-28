import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OptimisingCode_ReusableMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				RestAssured.baseURI="http://rahulshettyacademy.com";
				String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(Payload.AddPlace()).when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
				.header("Server","Apache/2.4.41 (Ubuntu)").extract().asString();
				
				System.out.println(response);
				JsonPath js=new JsonPath(response);
				String Place_id=js.getString("place_id");
				System.out.println("'Place id="+Place_id);
				
				//Update Place
				String newAdd="70 Summer walk, USA";
				given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+Place_id+"\",\r\n"
						+ "\"address\":\""+newAdd+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}").
				when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));
				
				//Get Place
				
				String getPlaceResponse=given().queryParam("key", "qaclick123").queryParam("place_id", Place_id)
				.when().get("/maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().asString();
				
				//JsonPath js1=new JsonPath(getPlaceResponse);
				JsonPath js1=ReusableMethods.reToJson(getPlaceResponse);
				String actualadd=js1.getString("address");
				System.out.println(actualadd);
				
				Assert.assertEquals(actualadd, newAdd);
	}

}
