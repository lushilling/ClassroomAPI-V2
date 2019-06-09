package com.qa.Business;

public interface ClassroomService {

	String addClassroom(String classroom);
	String retrieveClassroom(int id);
	String retrieveAllClassroom();
	String deleteClassroom(int id);
	String amendClassroom(int id, String classroom);
}
