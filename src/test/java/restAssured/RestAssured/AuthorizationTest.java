package restAssured.RestAssured;

import org.json.simple.JSONObject;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

public class AuthorizationTest {
public static void main(String[] args) {
	RestAssured.baseURI="https://bookstore.toolsqa.com/";
	JSONObject obj= new JSONObject();
	obj.put("userName","Deepali");
	obj.put("password", "Deepali@1");
	
	RequestSpecification req=RestAssured.given().auth().
			basic("Deepali", "Deepali@1").
			header("Content-Type","application/json").
			body(obj.toJSONString());
	
			Response res=req.post("Account/v1/Authorized");
            String data=res.asString();
            System.out.println(data);
            
            RequestSpecification req1=RestAssured.given().
            		header("Content-Type","application/json").
            		body(obj.toJSONString());
            Response res1= req1.post("Account/v1/GenerateToken");
            String data1=res1.asString();
            System.out.println(data1);
}
}
