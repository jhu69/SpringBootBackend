package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class RegistrationManager {

	private Integer id;

	public void setId(Integer value) {
		this.id = value;
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	private Set<Participant> participants;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Participant> getParticipants() {
		return this.participants;
	}

	// each new participant needs to be added to the participants set using
	// setParticipants(getParticipants().add(ourNewParticipant)
	public void setParticipants(Set<Participant> participantss) {
		this.participants = participantss;
	}

	private Set<Registration> registration;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Registration> getRegistration() {
		return this.registration;
	}

	// each new registration needs to be added to the registration set
	public void setRegistration(Set<Registration> registrations) {
		this.registration = registrations;
	}

	private Set<Event> event;

	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Event> getEvent() {
		return this.event;
	}

	// each event needs to be added to the event sets
	public void setEvent(Set<Event> events) {
		this.event = events;
	}

}