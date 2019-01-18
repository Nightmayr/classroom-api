package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT t FROM Trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>)query.getResultList();
		return util.getJSONForObject(trainees);
	}
	
	@Transactional(REQUIRED)
	public String addTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class) ;
		manager.persist(aTrainee);
		return "{\"message\": \"trainee sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee trainee = findTrainee(id);
		manager.remove(trainee);
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}
	
//	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String trainee) {
		Trainee foundTrainee = findTrainee(id);
		Trainee jsonTrainee = util.getObjectForJSON(trainee, Trainee.class);
		if(foundTrainee!=null) {
			manager.remove(foundTrainee);
			manager.persist(jsonTrainee);
			return "{\"message\": \"trainee sucessfully updated\"}";
		}
		return null;
	}
	
	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	

}
