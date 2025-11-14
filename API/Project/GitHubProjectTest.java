package project;

import java.util.HashMap;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectTest {
String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAINX7WJNFWrfF7eXh/112Hv1HExuPK+EBN8el0bmlL5sI";
int keyid;

RequestSpecification requestSpec;
ResponseSpecification responseSpec;

@BeforeClass

public void setUp() {
	//initialize the request spec
	requestSpec = new RequestSpecBuilder().
			setBaseUri("https://api.github.com/user/keys").
			addHeader("Content-Type","application/json").
			addHeader("Authorization","token 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"). //instead of the word token, you can use bearer
			addHeader("X-GitHub-Api-Version", "2022-11-28"). //default header to use Git
			
			build();
	//Initialize response spec
	responseSpec=new ResponseSpecBuilder().
			expectBody("title",Matchers.equalTo("TestKey")).
			expectBody("key",Matchers.equalTo(sshKey)).
			expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
			build();
}

@Test(priority=1)

public void postRequestTest() {
	//create request body
	HashMap<String,String> reqBody = new HashMap<String,String>();
	reqBody.put("title","TestKey");
	reqBody.put("key",sshKey);
	Response response = RestAssured.given().spec(requestSpec).body(reqBody).log().all()
			.when().post();
	keyid=response.then().extract().path("id");
	response.then().statusCode(201).spec(responseSpec).log().all();
	
	
	
}
}
