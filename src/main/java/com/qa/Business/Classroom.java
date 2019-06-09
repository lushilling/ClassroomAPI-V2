package com.qa.Business;

import javax.inject.Inject;

import com.qa.persistance.Repository.ClassroomRepository;

public class Classroom implements ClassroomService {

	@Inject
	ClassroomRepository classroomRepo;

	public String addClassroom(String classroom) {
		return classroomRepo.add(classroom);
	}

	public String retrieveClassroom(int id) {
		return classroomRepo.retrieve(id);
	}

	public String retrieveAllClassroom() {
		return classroomRepo.retrieveAll();
	}

}
