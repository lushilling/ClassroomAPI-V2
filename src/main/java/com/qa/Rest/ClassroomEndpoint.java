package com.qa.Rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.Business.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	ClassroomService classroomService;

	@POST
	@Path("/addClassroom")
	@Produces({"application/json"})
	public String addClassroom(String classroom) {
		return classroomService.addClassroom(classroom);
	}
	
	@GET
	@Path("/retrieveClassroom/{id}")
	@Produces({"application/json"})
	public String retrieveClassroom(@PathParam("id") int id) {
		return classroomService.retrieveClassroom(id);
	}
	
	@GET
	@Path("/retrieveAllClassroom")
	@Produces({"application/json"})
	public String retrieveAllClassroom() {
		return classroomService.retrieveAllClassroom();
	}
	
}
