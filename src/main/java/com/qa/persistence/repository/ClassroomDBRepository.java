package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.transaction.Transactional;

	@Transactional(SUPPORTS)
	@Default
	public class ClassroomDBRepository implements ClassroomRepository{

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
