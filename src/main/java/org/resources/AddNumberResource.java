package org.resources;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/addition")
@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

public class AddNumberResource  implements Serializable {

	public AddNumberResource() {
		// TODO Auto-generated constructor stub
	}

	@GET
	public String hello() throws Exception {

	   
	    System.out.println("hello jersey");
		
	    return "hello";
	
	}
	@POST
	@Path("/number")
	public Addition addNumbers(Addition a) {
			System.out.println("a"+a.getN1());
			Addition A2=new Addition( a.getN1() , a.getN2());
			
	        return  A2;
		}	
@GET
@Path("/number/{input_val1}/{input_val2}")
public Addition addNumbers(@PathParam("input_val1") long  input_val1,@PathParam("input_val2") long input_val2) {
System.out.println("in addition");		
		       
     //   float f=a1 + b1;
       //Float A1=Float.valueOf(f);
	//String A2=String.valueOf(f); 
		Addition A2=new Addition( input_val1 , input_val2);
		
        return  A2;
	}
/*@POST
public String addNumber(Addition A) {
System.out.println("in addition");		
		 float a1 = (Float.valueOf(A.getA())).floatValue(); 
        float b1 = (Float.valueOf(A.getB())).floatValue();

        // do some arithmetic
        System.out.println("a1 + b1 = " +
                           (a1 + b1));
        float f=a1 + b1;
       Float A1=Float.valueOf(f);
	String A2=String.valueOf(f);
		//Addition a2=new Addition(A.getA(),A.getB());
		
        return  A2;
	}*/
/*	@POST
	@Produces("application/xml")
	@Consumes("application/xml")
	public Addition hello(Addition inputJsonObj) throws Exception {

	    String input = (String) inputJsonObj.getA();
	    String output = "The input you sent is :" + input;
	    Addition outputJsonObj = new Addition();
	    outputJsonObj.setA( output);
	    System.out.println("hello jersey");
		
	    return outputJsonObj;
	
	}*/
}
