package com.qa.persitance.Domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Classroom_id")
	Set<Trainee> traineeList = new HashSet<Trainee>();

	public Classroom(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Classroom() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Trainee> getTraineeList(){
		return traineeList;
	}
	
	public void setTraineeList(Set<Trainee> traineeList) {
		this.traineeList = traineeList;
	}

}
