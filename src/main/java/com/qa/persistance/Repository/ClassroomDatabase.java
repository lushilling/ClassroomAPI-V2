package com.qa.persistance.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persitance.Domain.Classroom;

@Transactional(value = TxType.SUPPORTS)
public class ClassroomDatabase implements ClassroomRepository{

	@PersistenceContext(unitName = "myPU")
	private EntityManager manager;

	@Transactional(value = TxType.REQUIRED)
	public Classroom add(Classroom classroom) {
		manager.persist(classroom);
		return classroom;
	}

}
