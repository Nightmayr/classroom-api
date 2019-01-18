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
		
		@Transactional(REQUIRED)
		public String deleteClassroom(Long id) {
			Classroom classroom = findClassroom(id);
			manager.remove(classroom);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		}
		
//		@Override
		@Transactional(REQUIRED)
		public String updateClassroom(Long id, String classroom) {
			Classroom foundClassroom = findClassroom(id);
			Classroom jsonClassroom = util.getObjectForJSON(classroom, Classroom.class);
			if(foundClassroom!=null) {
				manager.remove(foundClassroom);
				manager.persist(jsonClassroom);
				return "{\"message\": \"classroom sucessfully updated\"}";
			}
			return null;
		}
		
		private Classroom findClassroom(Long id) {
			return manager.find(Classroom.class, id);
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
