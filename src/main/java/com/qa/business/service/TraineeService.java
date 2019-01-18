package com.qa.business.service;

public interface TraineeService {
	String getAllTrainees();
	String addTrainee(String trainee);
	String deleteTrainee(Long id);
	String updateTrainee(Long id, String trainee);
}
