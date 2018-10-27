package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.ManyToMany;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant {

	private String name;
	private Integer isDriver;
	private Set<Car> car;
	private Integer id;

	@ManyToMany
	public Set<Car> getCar() {
		return this.car;
	}

	public void setCar(Set<Car> cars) {
		this.car = cars;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setIsDriver(Integer value) {
		this.isDriver = value;
	}

	@Id
	@Column(name = "ParticipantName")
	public String getName() {
		return this.name;
	}

	@Column(name = "IsDriver")
	public Integer getIsDriver() {
		return this.isDriver;
	}

	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
