package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

	@Transactional(SUPPORTS)
	@Default
	public class ClassroomDBRepository implements ClassroomRepository{
		
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
	
		@Inject
		private JSONUtil util;
		
		public String getAllClassrooms() {
			// TODO Auto-generated method stub
			return null;
		}

		public String addClassroom(String classroom) {
			// TODO Auto-generated method stub
			return null;
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
