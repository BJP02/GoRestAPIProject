package com.api.gorest.test;

import org.testng.annotations.Test;

import com.api.gorest.pojo.UpdateUser;
import com.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class DeleteUsersTest {
	//1
	String baseURI="https://gorest.co.in";
	
//2
	int id = 71087;
	String basePath="/public-api/users/"+id;
	
//3
	String token="YKka4FAjVnrrdSPatYQzyh1MgXhhr_XkZMoN";
	
	
	
//4 passing data for payload
	@Test
public void DeleteUsersAPITest() {
	//UpdateUser upuser = new UpdateUser("Jignesh", "Parikh's","jigp77@gmail.com","active");
	
Response response=RestClient.deleteCalls("JSON", baseURI, basePath, token, null, true, null);	

	System.out.println("Status Code is :========="+response.getStatusCode());
	  System.out.println(response.prettyPrint());
	
	}	

}

