package restAssured.RestAssured;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class getsingle
{
    public static void main(String[] args) {
    	RestAssured.baseURI="https://reqres.in/";
    	RequestSpecification a=RestAssured.given();
    	Response b=a.get("api/users?page=1");
        System.out.println(b.asPrettyString());
        System.out.println(b.time());
        System.out.println(b.getContentType());
    }
}