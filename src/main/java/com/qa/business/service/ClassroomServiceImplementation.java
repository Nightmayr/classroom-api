package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImplementation implements ClassroomService {

	@Inject
	private ClassroomRepository repo;
	@Inject
	private JSONUtil util;
	
	
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String addClassroom(String classroom) {
		Classroom checkClassroom = util.getObjectForJSON(classroom, Classroom.class);
		return repo.addClassroom(classroom);
	}

	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}
	
}
