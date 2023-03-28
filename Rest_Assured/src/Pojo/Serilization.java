package Pojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class Serilization {

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
		
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("http://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		RequestSpecification res=given().spec(req)
		.body(p);
		
		ResponseSpecification resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		Response response=res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
		
		String responseString=response.asString();
		System.out.println(responseString);

	}

}
