package Pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class SpectBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setName("Rahul");
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setWebsite("http://rahulshettyacademy.com");
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		Location l=new Location();
		p.setLocation(l);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		RestAssured.baseURI="http://rahulshettyacademy.com";
		Response res=given().log().all().queryParam("key", "qaclick123")
		.body(p)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String responseString=res.asString();
		System.out.println("Response Body");
		System.out.println(responseString);

	}

}
