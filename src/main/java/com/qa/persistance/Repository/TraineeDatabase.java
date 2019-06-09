package com.qa.persistance.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persitance.Domain.Trainee;

@Transactional(value = TxType.SUPPORTS)
public class TraineeDatabase implements TraineeRepository {

	@PersistenceContext(unitName = "myPu")
	private EntityManager manager;
	
	
	public Trainee add(Trainee trainee) {
		manager.persist(trainee);
		return trainee;
	}

}
