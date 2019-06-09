package com.qa.persistance.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(value = TxType.SUPPORTS)
public class TraineeDatabase implements TraineeRepository {

	@PersistenceContext(unitName = "myPu")
	private EntityManager manager;

	@Transactional(value = TxType.REQUIRED)
	public String add(String trainee) {
		manager.persist(trainee);
		return trainee;
		
	}

}
