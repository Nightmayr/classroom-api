package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String getAllClassrooms();
	String addClassroom(String classroom);
	String deleteClassroom(Long id);
	String updateClassroom(Long id, String classroom);

}
