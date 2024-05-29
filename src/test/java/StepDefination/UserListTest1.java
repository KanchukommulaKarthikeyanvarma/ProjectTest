package StepDefination;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UserListTest1 {
	RequestSpecification req;
	Response res;
	JsonPath path;
	@Given("user is on reqres URL")
	public void user_is_on_reqres_url() {
	    RestAssured.baseURI="https://reqres.in/";
	    req=RestAssured.given();
	    System.out.println("Given step");
	}
 
	@When("user hits the User API")
	public void user_hits_the_user_api() {
	    res=req.get("api/users?page=2");
	    System.out.println("When step");
	}
 
	@Then("all the users is displayed")
	public void all_the_users_is_displayed() {
		String data=res.asPrettyString();
		path=res.jsonPath();
		String id=path.getString("data[1].id");
		Assert.assertEquals(id,"8","id mismatch");
		System.out.println("Then step");
	}
 
}

