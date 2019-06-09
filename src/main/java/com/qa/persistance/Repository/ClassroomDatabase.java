package com.qa.persistance.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
