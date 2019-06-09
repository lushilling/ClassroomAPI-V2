package com.qa.persistance.Repository;

public interface TraineeRepository {

	String add(String trainee);
	String retrieve(int id);
	String retrieveAll();
	String deleteTrainee(int id);
}
