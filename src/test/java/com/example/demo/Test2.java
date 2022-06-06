package com.example.demo;

import static io.restassured.RestAssured.*;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Test2 {	
	@Test
	public void testHello2() {
		String responseString = given().get("http://localhost:8989/hello2?name=Habib")
				  .then()
				  .assertThat()
				  .statusCode(HttpStatus.OK.value())
				  .extract()
				  .asString();
		
		Assert.assertEquals(responseString,"Say Hello Habib"); 
	}	
	
	@Test
	public void testHello3() {
		given().get("http://localhost:8989/hello2?name=Habib")
				  .then().log().body();
				  
		
		//Assert.assertEquals(responseString,"Say Hello Habib"); 
	}	
}
