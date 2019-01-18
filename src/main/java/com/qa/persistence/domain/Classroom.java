package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String trainer;
//	Trainees entity yet to be implemented
	private Trainee[] trainees;
	
	public Classroom() {
		
	}
	
	public Classroom(String trainer) {
		this.setTrainer(trainer);
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Trainee[] getTrainees() {
		return trainees;
	}

	public void setTrainees(Trainee[] trainees) {
		this.trainees = trainees;
	}
	
	
	
}
