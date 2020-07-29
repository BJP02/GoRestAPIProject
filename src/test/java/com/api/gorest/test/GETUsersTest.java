package com.api.gorest.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class GETUsersTest {

//1
	String baseURI="https://gorest.co.in";
	
//2
	String basePath="/public-api/users";
	
//3
	String token="YKka4FAjVnrrdSPatYQzyh1MgXhhr_XkZMoN";
	
//4 Calling
	@Test(priority=1)
	public void getAllUsersTest() {
   
//5		
	Response response = RestClient.getCalls("JSON",baseURI,basePath,token,null,true);
   
//6	Printing this
	 System.out.println("Status Code capture after sending request is :"+response.getStatusCode());		
     System.out.println("Content Type capture after sending request is :"+response.getContentType());
     System.out.println(response.prettyPrint());
	}
//7
     @Test(priority=2)
      public void  getUsersWithQuerryParam() {
    	 
//8
    	 Map<String,String>params=new HashMap<String,String>();
    	 params.put("first_name","Shayne");//got this Name2 from postman
    	 params.put("gender","male");
 
//9
    Response response = RestClient.getCalls("JSON",baseURI,basePath,token,params,true);
     
//10
    System.out.println("Status Code capture after sending request is :"+response.getStatusCode());		
    System.out.println("Content Type capture after sending request is :"+response.getContentType());
    System.out.println(response.prettyPrint());
    
     }
   	
   
}	
