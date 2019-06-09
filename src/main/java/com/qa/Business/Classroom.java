package com.qa.Business;

import javax.inject.Inject;

import com.qa.persistance.Repository.ClassroomRepository;

public class Classroom implements ClassroomService {

	@Inject
	ClassroomRepository classroomRepository;

	public String addClassroom(String classroom) {
		//return classroomRepository.add(classroom);
		return null;
	}

}
