package com.api.gorest.pojo;

public class UpdateUser {
//	1
	private String first_name;
    private String last_name;
    private String email;
    private String status;

 //2 creating Constructor  
    
    public UpdateUser(String first_name, String last_name, String email, String status) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.status = status;
	}

 //3 Generating Getters and Setters
 
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
