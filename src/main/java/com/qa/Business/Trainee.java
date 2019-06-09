package com.qa.Business;

import javax.inject.Inject;

import com.qa.persistance.Repository.TraineeRepository;

public class Trainee implements TraineeService{

	@Inject 
	TraineeRepository traineeRepository;
	
	
	public String addTrainee(String trainee) {
		//return traineeRepository.add(trainee);
		return null;
	}

}
