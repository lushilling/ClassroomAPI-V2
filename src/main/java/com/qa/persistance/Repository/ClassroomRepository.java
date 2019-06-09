package com.qa.persistance.Repository;

public interface ClassroomRepository {
	
	String add(String classroom);
	String retrieve(int id);
	String retrieveAll();
	String deleteClassroom(int id);
	String amendClassroom(int id, String Classroom);
}
