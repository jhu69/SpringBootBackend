package ca.mcgill.ecse321.eventregistration.model;
import javax.persistence.ManyToMany;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant{
private Set<Car> car;

@ManyToMany
public Set<Car> getCar() {
   return this.car;
}

public void setCar(Set<Car> cars) {
   this.car = cars;
}


private String name;
private Integer isDriver;
   
   public void setName(String value) {
	   this.name = value;
    }
   public void setIsDriver(Integer value) {
	   this.isDriver = value;
	}

@Id
@Column(name="ParticipantId")
public String getName() {
return this.name;
       }

@Column(name="IsDriver")
public Integer getIsDriver() {
return this.isDriver;
       }
   }
