package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {

	// Event field attributes 
	private String name;
	private Date eventDate;
	private Time startTime;
	private Time endTime;
	private String startLocation;
	private String endLocation;
	// Added these new attributes to event class
	private String carType;
	private String driveType;
	private String makeOfCar;
	private Double meterPerStop; 
	private Integer seats;

	// Getters and Setters for the attributes 
	public void setName(String value) {
		this.name = value;
	}

	// Acts like a primary key in my SQL table to distinguish between two different events
	@Id 
	@Column(name = "EventName")
	public String getName() {
		return this.name;
	}

	public void setEventDate(Date value) {
		this.eventDate = value;
	}

	@Column(name = "EventDate")
	public Date getEventDate() {
		return this.eventDate;
	}

	public void setStartTime(Time value) {
		this.startTime = value;
	}

	@Column(name = "StartTime")
	public Time getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Time value) {
		this.endTime = value;
	}

	@Column(name = "EndTime")
	public Time getEndTime() {
		return this.endTime;
	}

	public void setStartLocation(String value) {
		this.startLocation = value;
	}

	public void setEndLocation(String value) {
		this.endLocation = value;
	}

	public void setSeats(Integer value) {
		this.seats = value;
	}

	@Column(name = "StartLocation")
	public String getStartLocation() {
		return this.startLocation;
	}

	@Column(name = "EndLocation")
	public String getEndLocation() {
		return this.endLocation;
	}

	@Column(name = "CarType")
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Column(name = "DriveType")
	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	@Column(name = "CarMake")
	public String getMakeOfCar() {
		return makeOfCar;
	}

	public void setMakeOfCar(String makeOfCar) {
		this.makeOfCar = makeOfCar;
	}

	@Column(name = "Seats")
	public Integer getSeats() {
		return this.seats;
	}

	@Column(name="CostPerStop")
	public Double getMeterPerStop() {
		return meterPerStop;
	}

	public void setMeterPerStop(Double meterPerStop) {
		this.meterPerStop = meterPerStop;
	}
}
