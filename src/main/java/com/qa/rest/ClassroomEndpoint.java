package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;
	
	@Path("getAllClassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/addClassroom")
	@POST
	@Produces({"application/json"})
	public String addClassroom(String classroom) {
		return service.addClassroom(classroom);
	}
	
	
}
