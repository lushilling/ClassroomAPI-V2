package com.qa.Rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
