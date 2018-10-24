package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
public class RegistrationManager{
private Set<Car> car;

@OneToMany(cascade={CascadeType.ALL})
public Set<Car> getCar() {
   return this.car;
}

public void setCar(Set<Car> cars) {
   this.car = cars;
}

	
	private Integer id;
	public void setId(Integer value) {
		this.id = value;
	}
	
	@Id
	@Column(name="id")
  public Integer getId() {
		return this.id;
	}
	
private Set<Participant> participants;

@OneToMany(cascade={CascadeType.ALL})
public Set<Participant> getParticipants() {
   return this.participants;
}

public void setParticipants(Set<Participant> participantss) {
   this.participants = participantss;
}

private Set<Registration> registration;

@OneToMany(cascade={CascadeType.ALL})
public Set<Registration> getRegistration() {
   return this.registration;
}

public void setRegistration(Set<Registration> registrations) {
   this.registration = registrations;
}

private Set<Event> event;

@OneToMany(cascade={CascadeType.ALL})
public Set<Event> getEvent() {
   return this.event;
}

public void setEvent(Set<Event> events) {
   this.event = events;
}

}
