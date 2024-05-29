package restAssured.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExcelData {
	RequestSpecification req;
	Response res;
	JsonPath data;
	File file;
	FileInputStream fis;
	Workbook w;
	org.apache.poi.ss.usermodel.Sheet s;
	@BeforeTest

	public void init() {
		RestAssured.baseURI="https://reqres.in/";
	}
	@Test
	public void addData() throws IOException {
		file=new File("C:\\Users\\KKANCHUK\\Desktop\\RestAssured\\src\\test\\resource\\Data.xlsx");
	fis=new FileInputStream(file);
	w=new XSSFWorkbook(fis);
	s=w.getSheet("Data");
	
	String name=s.getRow(0).getCell(0).toString();
	String job=s.getRow(0).getCell(1).toString();
		
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
