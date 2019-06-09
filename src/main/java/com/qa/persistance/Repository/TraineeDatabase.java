package com.qa.persistance.Repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.Business.Trainee;
import com.qa.Utility.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
public class TraineeDatabase implements TraineeRepository {

	@PersistenceContext(unitName = "myPu")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(value = TxType.REQUIRED)
	public String add(String trainee) {
		manager.persist(trainee);
		return trainee;

	}

	public String retrieve(int id) {
		return util.getJSONForObject(manager.find(Trainee.class, id));
	}

	public String retrieveAll() {
		Query query = manager.createQuery("Select t FROM Trainee t");
		Collection<Trainee> trainee = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainee);
		
	}

}
