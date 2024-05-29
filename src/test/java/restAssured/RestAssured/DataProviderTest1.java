package restAssured.RestAssured;
 
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class DataProviderTest1 {

	RequestSpecification req;
	Response res;
	JsonPath data;

	@DataProvider(name="createUser")

	public Object[][] getData(){
		Object[][] data=new Object[4][2];
		data[0][0]="Narasimhulu";
		data[0][1]="Capgemini";
		data[1][0]="Ajay";
		data[1][1]="Capgemini";
		data[2][0]="Rohan";
		data[2][1]="Capgemini";
		data[3][0]="Karthik";
		data[3][1]="Amazon";
		return data;
	}

	@BeforeTest

	public void init() {
		RestAssured.baseURI="https://reqres.in/";

	}

	@Test(dataProvider="createUser")

	public void addData(String name, String job) {
		req=RestAssured.given();
		JSONObject obj=new JSONObject();
		obj.put("name",name);
		obj.put("job", job);
		req.header("Content-Type","application/json");
		res=req.body(obj.toJSONString()).post("api/users");
		System.out.println(obj);
		req.body(obj.toJSONString());
		data=res.jsonPath();
		String jobdata=data.getString("job");
		System.out.println(jobdata);

		Assert.assertEquals(jobdata, job);

	}

	@AfterTest
	public void deallocateMem() {

		req=null;
		res=null;
	}
 
}
