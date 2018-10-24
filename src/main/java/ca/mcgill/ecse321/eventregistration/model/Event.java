package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event{
	
private String name;
   
   public void setName(String value) {
this.name = value;
    }
   
@Id // acts like a primary key in my SQL table to distinguish between two different events 
@Column(name="EventName")
public String getName() {
return this.name;
    }
private Date eventDate;

public void setEventDate(Date value) {
this.eventDate = value;
    }
@Column(name="EventDate")
public Date getEventDate() {
return this.eventDate;
    }
private Time startTime;

public void setStartTime(Time value) {
this.startTime = value;
    }

@Column(name="StartTime")
public Time getStartTime() {
return this.startTime;
    }
private Time endTime;

public void setEndTime(Time value) {
this.endTime = value;
    }
@Column(name="EndTime")
public Time getEndTime() {
return this.endTime;
       }

private String startLocation;
private String endLocation;
private Integer seats;

public void setStartLocation(String value){
	this.startLocation=value;
}
public void setEndLocation(String value){
	this.endLocation=value;
}

public void setSeats(Integer value){
	this.seats=value;
}

@Column(name="StartLocation")
public String getStartLocation() {
	return this.startLocation;
}

@Column(name="EndLocation")
public String getEndLocation() {
	return this.endLocation;
}

@Column(name="Seats")
public Integer getSeats() {
	return this.seats;
}
   }
