package restAssured.RestAssured;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AppTest 
{
    public static void main(String[] args) {
    	RestAssured.baseURI="https://reqres.in/";
    	RequestSpecification a=RestAssured.given();
    	Response b=a.get("api/users?page=2");
        System.out.println(b.asPrettyString());
        System.out.println(b.asString());
        System.out.println(b.statusCode());
        System.out.println(b.getStatusCode());
        System.out.println(b.equals(b));
    }
}
