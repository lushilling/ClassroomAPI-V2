package com.qa.Rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.Business.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject 
	TraineeService traineeService;
	
	@POST
	@Path("/addTrainee")
	@Produces({"application/json"})
	public String addTrainee(String trainee) {
		return traineeService.addTrainee(trainee);
	}
	
	@GET
	@Path("/retrieveTrainee/{id}")
	@Produces("{application/json}")
	public String retrieveTrainee(@PathParam("id") int id) {
		return traineeService.retrieveTrainee(id);
	}
	
	@GET
	@Path("/retrieveAllTrainees")
	@Produces({"application/json"})
	public String retrieveAllTrainees() {
		return traineeService.retrieveAllTrainees();
	}
	
	@DELETE
	@Path("/deleteTrainee/{id}")
	@Produces({"application/json"})
	public String deleteTrainee(@PathParam("id") int id) {
		return traineeService.deleteTrainee(id);
	}
	
	
	
}
