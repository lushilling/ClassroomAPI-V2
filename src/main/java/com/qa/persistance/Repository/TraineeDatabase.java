package com.qa.persistance.Repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persitance.Domain.*;
import com.qa.Utility.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
public class TraineeDatabase implements TraineeRepository {

	@PersistenceContext(unitName = "myPU")
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

	@Transactional(value = TxType.REQUIRED)
	public String deleteTrainee(int id) {
		manager.remove(manager.find(Trainee.class, id));
		return util.returnMessage("Trainee deleted");
	}

	@Transactional(value = TxType.REQUIRED)
	public String amendTrainee(int id, String trainee) {
		Trainee updatedTrainee = util.getObjectForJSON(trainee, Trainee.class);
		Trainee oldTrainee = manager.find(Trainee.class, id);
		oldTrainee.setName(updatedTrainee.getName());
		manager.persist(oldTrainee);
		return util.returnMessage("Trainee updated");
	}

}
