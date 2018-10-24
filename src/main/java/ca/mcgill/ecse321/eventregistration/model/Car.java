package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Car{

private String name;
private String makeOfCar;
private Integer numSeats;
private String carType;
private Integer numDoors;
private String driveType;
   
public void setMakeOfCar(String value) {
this.makeOfCar = value;
    }
   
@Column(name="CarMake")
public String getMakeOfCar() {
return this.makeOfCar;
    }

public void setNumSeats(Integer value) {
this.numSeats = value;
    }

@Column(name="NumSeats")
public Integer getNumSeats() {
return this.numSeats;
    }

public void setCarType(String value) {
this.carType = value;
    }

@Column(name="CarType")
public String getCarType() {
return this.carType;
    }

public void setNumDoors(Integer value) {
this.numDoors = value;
    }

@Column(name="NumDoors")
public Integer getNumDoors() {
return this.numDoors;
    }

public void setDriveType(String value) {
this.driveType = value;
    }

@Column(name="DriveType")
public String getDriveType() {
return this.driveType;
       }

@Id
@Column(name="id")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   }
