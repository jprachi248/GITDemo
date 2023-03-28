package Pojo;
import static io.restassured.RestAssured.*;

import groovy.util.ConfigObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Deserization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://rahulshettyacademy.com";
		RequestSpecification req=RestAssured.given();
		JSONObject requestParams = new ConfigObject(); 
		requestParams.put("UserName", "test_rest"); 
		requestParams.put("Password", "rest@123"); 
		request.body(requestParams.toJSONString()); 

	}

}
