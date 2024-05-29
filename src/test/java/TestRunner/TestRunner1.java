package TestRunner;

//import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;
 
//import io.cucumber.junit.Cucumber;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Feature\\AddUser.feature",
glue="Step",
tags="",
//dryRun=true,
monochrome=false,
plugin= {"pretty","html:target/Karthik.html", 
		"json: target/Kar.json", 
		"junit: target/karthikeyan.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
)
public class TestRunner1 extends AbstractTestNGCucumberTests{
}
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src\\test\\resource\\Feature\\AddUser.feature",glue="Steps")
//public class TestRunner1 extends AbstractTestNGCucumberTests {
 
//}
