package com.qa.persistance.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
