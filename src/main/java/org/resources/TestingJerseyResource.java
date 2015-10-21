package org.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
@Path("jerseytest")
public class TestingJerseyResource {

	public TestingJerseyResource() {
		// TODO Auto-generated constructor stub
	}
		@GET
		public String getStudents() {
	System.out.println("testing GET Jersey");
	return "Hi Success is here in get";
		}
		@POST
		public String addStudents() {
	System.out.println("testing POST");
	return " Successful post";
		}
	

}
