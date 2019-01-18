package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImplementation implements TraineeService{
	@Inject
	private TraineeRepository repo;
	@Inject
	private JSONUtil util;
	
	
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String addTrainee(String trainee) {
		Trainee checkTrainee = util.getObjectForJSON(trainee, Trainee.class);
		return repo.addTrainee(trainee);
	}

	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	public String updateTrainee(Long id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}
}
