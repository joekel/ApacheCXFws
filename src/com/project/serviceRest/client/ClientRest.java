package com.project.serviceRest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ClientRest {

	public static void main(String[] args) {
		
		
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/FinalSpringProject2/services/patientservice/costomer/7");
		Response response = target.request().accept("application/xml; charset=utf-8")
                .acceptEncoding("gzip").get();
		System.out.println(response.getStatus());
		
		
		
		
		

	}

}
