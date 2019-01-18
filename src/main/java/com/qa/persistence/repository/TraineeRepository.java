package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String getAllTrainees();
	String addTrainee(String trainee);
	String deleteTrainee(Long id);
	String updateTrainee(Long id, String classroom);
}
