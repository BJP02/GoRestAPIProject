package com.api.gorest.restclient;

import java.util.Map;

import com.api.gorest.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestClient {
//1 
	/**
	 * This class will be having all the http Methods that will call the API's and having generic method.
	 */
//2
	
	public static Response getCalls(String contentType,String baseURI, String basePath ,
			                    String token,Map<String, String>paramsMap,boolean log) {

//4 Calling setbaseURI method
		setBaseURI(baseURI);
//6 Calling create request(5Th point)	
	RequestSpecification request= createRequest(contentType, token, paramsMap, log);

//10 Getting return
	
		return getResponse("GET", request, basePath);
	}
	
//Encapsulation Hiding all the logic
//To set BaseURI of API.
//3
	private static void setBaseURI(String baseURI) {
        RestAssured.baseURI= baseURI;
	}
//5 Create request
	private static RequestSpecification createRequest(String contentType,String token,Map<String,String>paramsMap,
			                     boolean log) {
                 RequestSpecification request;
// Generating log
		        if (log) {
//for log if value is passed as true then it will generate log
			    request=RestAssured.given().log().all();	
		      } else {
//Not generating any logs
			    request=RestAssured.given();
	}
		        
//Passing token
		        if(token!=null) {
		        	request.header("Authorization","Bearer "+ token);
		        }
		        	
//Passing Params
		     if(paramsMap!=null) {
		    	 request.queryParams(paramsMap);
		     }
		        
//ContentTypes (Json,XML,Text)
		    if (contentType.equalsIgnoreCase("JSON")) {
				request.contentType(ContentType.JSON);
			} else if(contentType.equalsIgnoreCase("XML"))  {
				request.contentType(ContentType.XML);
			}	else if (contentType.equalsIgnoreCase("TEXT")) {
				request.contentType(ContentType.TEXT);	
			}
	return request;	    
		} 
		        
//7 Hit an API
	
	private static Response getResponse(String httpMethod,RequestSpecification request,String basePath) {

//9 calling 8th point		
	return	executeAPI(httpMethod, request, basePath);
	}

//8 Executing API
	private static Response executeAPI(String httpMethod,RequestSpecification request,String basePath) {
		Response response=null;
		
		switch (httpMethod) {
		case "GET":
		response = request.get(basePath);
			break;
		case "POST":
			response = request.post(basePath);
			break;
		case "PUT":
			response = request.put(basePath);
			break;
		case "DELETE":
			response = request.delete(basePath);
			break;			
		default:
			System.out.println("Please pass the valid httpMethod like(GET,POST,PUT,DELETE)");
			break;
		}
		 return response;
	}

//11 Creating PostCall
	public static Response postCalls(String contentType,String baseURI,String basePath,String token,
			                     Map<String,String>paramsMap,boolean log,Object obj) {

		
//12 calling baseURI method
		
		setBaseURI(baseURI);
		
//13  Calling create request	
		
		RequestSpecification request= createRequest(contentType, token, paramsMap, log);
		
//15 Creating payloadMetod is in TestUtil .java	and now calling that method here	
		
		String jsonpayload=TestUtil.getSerializedJSON(obj);
		
		request.body(jsonpayload);
		
//Creating payload structure in users.java 
		
		
//14  Getting return
		
		return getResponse("POST", request, basePath);
	
	}

//15 Creating PutCall
	public static Response putCalls(String contentType,String baseURI,String basePath,String token,
				                     Map<String,String>paramsMap,boolean log,Object obj) {

			
//16 calling baseURI method
			
			setBaseURI(baseURI);
			
//17  Calling create request	
			
			RequestSpecification request= createRequest(contentType, token, paramsMap, log);
			
//18 Creating payloadMetod is in TestUtil .java	and now calling that method here	
			
			String jsonpayload=TestUtil.getSerializedJSON(obj);
			
			request.body(jsonpayload);
			
//Creating payload structure in Updateuser.java 
			
			
	//19  Getting return
			
			return getResponse("PUT", request, basePath);
		
		}

//20 Creating PutCall
	public static Response deleteCalls(String contentType,String baseURI,String basePath,String token,
				                     Map<String,String>paramsMap,boolean log,Object obj) {

			
//21 calling baseURI method
			
			setBaseURI(baseURI);
			
//22  Calling create request	
			
			RequestSpecification request= createRequest(contentType, token, paramsMap, log);
			
//23 Creating payloadMetod is in TestUtil .java	and now calling that method here	
			
			String jsonpayload=TestUtil.getSerializedJSON(obj);
			
			request.body(jsonpayload);
			
	//Creating payload structure in Updateuser.java 
			
			
//24  Getting return
	
			return getResponse("DELETE", request, basePath);
		
		}
}
	
	
	
	

