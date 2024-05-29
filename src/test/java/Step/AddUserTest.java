package Step;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddUserTest {
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj;
	String expJ, expN;
@Given("User is on reqres URL")
public void user_is_on_reqres_url() {
	RestAssured.baseURI="https://reqres.in/";
    req=RestAssured.given();
    System.out.println("Given step");
}
 
@When("^User enters the (.*) and (.*)$")
public void user_enters_the_and(String name, String job) {
	obj=new JSONObject();
	obj.put("name",name);
	obj.put("job", job);
	expJ=job;
	expN=name;
	req.header("Content-Type","application/json");
	System.out.println(obj);
	System.out.println("When step");
}
 
@And("users hit the users API")
public void users_hit_the_users_api() {
  res=req.body(obj.toJSONString()).post("api/users");
  System.out.println("And step");
}
 
@Then("Users are added to list")
public void users_are_added_to_list() {
	System.out.println(res.asPrettyString());
	path=res.jsonPath();
	String jobdata=path.getString("job");
	System.out.println(jobdata);
	Assert.assertEquals(jobdata, expJ);
}
}
