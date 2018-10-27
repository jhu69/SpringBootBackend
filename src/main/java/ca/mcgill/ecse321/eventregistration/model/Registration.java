package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.ManyToMany;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration {
	private Set<Car> car;

	@ManyToMany
	public Set<Car> getCar() {
		return this.car;
	}

	public void setCar(Set<Car> cars) {
		this.car = cars;
	}

	private Participant participants;

	@ManyToOne(optional = false)
	public Participant getParticipants() {
		return this.participants;
	}

	public void setParticipants(Participant participants) {
		this.participants = participants;
	}

	private Event event;

	@ManyToOne(optional = false)
	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	private Integer id;

	public void setId(Integer value) {
		this.id = value;
	}

	@Id
	@Column(name = "RegistrationId")
	public Integer getId() {
		return this.id;
	}
}