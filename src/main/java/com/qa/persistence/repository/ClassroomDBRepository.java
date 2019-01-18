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

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Default
	public class ClassroomDBRepository implements ClassroomRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getAllClassrooms() {
			Query query = manager.createQuery("SELECT c FROM Classroom c");
			Collection<Classroom> classrooms = (Collection<Classroom>)query.getResultList();
			return util.getJSONForObject(classrooms);
		}
		
		@Transactional(REQUIRED)
		public String addClassroom(String classroom) {
			Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class) ;
			manager.persist(aClassroom);
			return "{\"message\": \"classroom sucessfully added\"}";
		}

		public String deleteClassroom(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		public String updateClassroom(Long id, String classroom) {
			// TODO Auto-generated method stub
			return null;
		}
		

}
