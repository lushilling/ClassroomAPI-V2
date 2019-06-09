package com.qa.persistance.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(value = TxType.SUPPORTS)
public class ClassroomDatabase implements ClassroomRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager manager;

	@Transactional(value = TxType.REQUIRED)
	public String add(String classroom) {
		manager.persist(classroom);
		return classroom;
	}

}
