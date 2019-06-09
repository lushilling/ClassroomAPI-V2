package com.qa.persistance.Repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


import com.qa.Business.Classroom;
import com.qa.Utility.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
public class ClassroomDatabase implements ClassroomRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(value = TxType.REQUIRED)
	public String add(String classroom) {
		manager.persist(classroom);
		return classroom;
	}

	public String retrieve(int id) {
		return util.getJSONForObject(manager.find(Classroom.class, id));

	}

	public String retrieveAll() {
		Query query = manager.createQuery("Select c FROM Classroom c");
		Collection<Classroom> classroom = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classroom);
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteClassroom(int id) {
		manager.remove(manager.find(Classroom.class, id));
		return util.returnMessage("Classroom deleted");
	}

	

}
