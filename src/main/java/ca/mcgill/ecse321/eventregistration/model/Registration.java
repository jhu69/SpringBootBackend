package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//this class links one participant to one event
//for multiple participant regitering to one event we need multiple registartions linking the same event to the different participants
@Entity
public class Registration {
	
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
	public Integer getId() {
		return this.id;
	}
}