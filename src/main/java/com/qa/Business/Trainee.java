package com.qa.Business;

import javax.inject.Inject;

import com.qa.persistance.Repository.TraineeRepository;

public class Trainee implements TraineeService {

	@Inject
	TraineeRepository traineeRepo;

	public String addTrainee(String trainee) {
		return traineeRepo.add(trainee);
	}

	public String retrieveTrainee(int id) {
		return traineeRepo.retrieve(id);
	}

	public String retrieveAllTrainees() {
		return traineeRepo.retrieveAll();
	}

	public String deleteTrainee(int id) {
		return traineeRepo.deleteTrainee(id);
		
	}

	public String amendTrainee(int id, String trainee) {
		return traineeRepo.amendTrainee(id, trainee);
	}

}
