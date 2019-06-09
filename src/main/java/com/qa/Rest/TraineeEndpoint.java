package com.qa.Rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.qa.Business.ClassroomService;
import com.qa.Business.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {

	@Inject
	ClassroomService classroomService;
	
	@Inject 
	TraineeService traineeService;
	
	@POST
	@Path("/addTrainee")
	@Produces({"application/json"})
	public String addTrainee(String trainee) {
		return traineeService.addTrainee(trainee);
	}
	
	
}
