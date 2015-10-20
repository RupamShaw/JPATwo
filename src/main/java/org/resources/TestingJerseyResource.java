package org.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
@Path("/jerseytest")
public class TestingJerseyResource {

	public TestingJerseyResource() {
		// TODO Auto-generated constructor stub
	}
		@GET
		public void getStudents() {
	System.out.println("testing GET Jersey");
		}
		@POST
		public void addStudents() {
	System.out.println("testing POST");
		}
	

}
