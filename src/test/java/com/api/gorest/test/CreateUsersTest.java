package com.api.gorest.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.gorest.pojo.Users;
import com.api.gorest.restclient.RestClient;
import com.api.gorest.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUsersTest {

//1
		String baseURI="https://gorest.co.in";
		
//2
		String basePath="/public-api/users";
		
//3
		String token="YKka4FAjVnrrdSPatYQzyh1MgXhhr_XkZMoN";
		
/*//4 passing data for payload
		@Test
	public void createUsersAPIPOSTTest() {
		Users user = new Users("jignesh", "parikh","male","01-03-1977","jigb1234@gmail.com","1234567890",
				               "http://www.api.com","abc 143 circle blvd","active");
		
	Response response=RestClient.postCalls("JSON", baseURI, basePath, token, null, true, user);	
	
		System.out.println("Status Code is :========="+response.getStatusCode());
		  System.out.println(response.prettyPrint());
		
		}*/
		
//4 passing data from Excel sheet for payload
		
  @DataProvider
		public Object[][] getUserData() {
	  Object userData[][] = ExcelUtil.getPayloadData("UserData");
	  	return userData;
	
}
		
//5 Calling excel sheet data in test
  
  @Test(dataProvider="getUserData")
  	public void createUsersAPIPOSTTest(String firstname,String lastname,String gender,String dob,String	email,
  			String phonenumber,String website,String address,String	status) {
  		
  		Users user = new Users(firstname,lastname,gender,dob,email,phonenumber,website,address,status) ; 	
  	
  	Response response=RestClient.postCalls("JSON", baseURI, basePath, token, null, true, user);	
  		
	System.out.println("Status Code is :========="+response.getStatusCode());
	  System.out.println(response.prettyPrint());
	System.out.println("==============>>>>>>>>>>>>>>>>>>>>===============>>>>>>>>>>>>>>>>>>>==============");
	}
		
  				
}
