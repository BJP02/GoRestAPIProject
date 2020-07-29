package com.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

//1 Creating a Payload by POJO Concept
	
	public static String getSerializedJSON(Object obj) {
		ObjectMapper mapper=new ObjectMapper();
		
		String jsonString=null;
		
		try {
			jsonString=mapper.writeValueAsString(obj);
		System.out.println("JSON BODY PAYLOAD=============="+jsonString);
		
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
			return jsonString;
	
	}
	
	
	
	
	
	
	
	
}
