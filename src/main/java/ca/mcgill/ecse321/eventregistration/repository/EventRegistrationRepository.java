package ca.mcgill.ecse321.eventregistration.repository;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.model.Car;

@Repository
public class EventRegistrationRepository {

	@Autowired
	EntityManager entityManager;

	// Participant objects to be stored in eventregi repo which will be mapped to a table in SQL through Hibernate 
	@Transactional
	public Participant createParticipant(String name,Integer isDriver) {
		Participant participant = new Participant();
		participant.setName(name);
		participant.setIsDriver(isDriver);
		entityManager.persist(participant);
		return participant;
	}
	
	// Added a Car class so instanced of cars could be created and persisted within EventRegistration Repository 
	@Transactional
	public Car createCar(String name, String makeOfCar, Integer numSeats, String carType, Integer numDoors, String driveType) {
		Car car = new Car();
		car.setName(name);
		car.setMakeOfCar(makeOfCar);
		car.setNumSeats(numSeats);
		car.setCarType(carType);
		car.setNumDoors(numDoors);
		car.setDriveType(driveType);
		entityManager.persist(car);
		return car;
	}
	
	// Added seats, prices per stop, and car object
	// Event objects to be stored in eventregi repo which will be mapped to a table in SQL through Hibernate
	@Transactional
	public Event createEvent(String name, String eventDate, String startTime, String endTime, String startLocation, String endLocation, String carType, String driveType, String makeOfCar, Integer meterPerStop, Integer availableSeats) {
		Event event= new Event();
		java.util.Date tmpDate = null;
		try {
			//"01 NOVEMBER 2018"
			tmpDate = new SimpleDateFormat("dd MMM yyyy").parse(eventDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//"10:34:34"
		java.sql.Date sqlDate = new java.sql.Date(tmpDate.getTime());
		Time sqlStart = Time.valueOf(startTime);
		Time sqlEnd = Time.valueOf(endTime);
		event.setName(name);
		event.setEventDate(sqlDate);
		event.setStartTime(sqlStart);
		event.setEndTime(sqlEnd);
		event.setStartLocation(startLocation);
		event.setEndLocation(endLocation);
		event.setCarType(carType);
		event.setDriveType(driveType);
		event.setMakeOfCar(makeOfCar);
		event.setMeterPerStop(meterPerStop);
		event.setSeats(availableSeats);
		entityManager.persist(event);
		return event;
	}
	
	@Transactional
	public Event modifyEvent(String name, String eventDate, String startTime, String endTime, String startLocation, String endLocation, String carType, String driveType, String makeOfCar, Integer meterPerStop, Integer availableSeats) {
		Event event = entityManager.find(Event.class, name);
		java.util.Date tmpDate = null;
		try {
			//"01 NOVEMBER 2018"
			tmpDate = new SimpleDateFormat("dd MMM yyyy").parse(eventDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//"10:34:34"
		java.sql.Date sqlDate = new java.sql.Date(tmpDate.getTime());
		Time sqlStart = Time.valueOf(startTime);
		Time sqlEnd = Time.valueOf(endTime);
		event.setName(name);
		event.setEventDate(sqlDate);
		event.setStartTime(sqlStart);
		event.setEndTime(sqlEnd);
		event.setStartLocation(startLocation);
		event.setEndLocation(endLocation);
		event.setCarType(carType);
		event.setDriveType(driveType);
		event.setMakeOfCar(makeOfCar);
		event.setMeterPerStop(meterPerStop);
		event.setSeats(availableSeats);
		entityManager.persist(event);
		return event;
	}
	
	@Transactional
	public void deleteEvent(String name) {
		Event eventToDelete = entityManager.find(Event.class, name);
		entityManager.remove(eventToDelete);
	}

	@Transactional
	public Participant getParticipant(String name) {
		Participant participant = entityManager.find(Participant.class, name);
		return participant;
	}
	
	@Transactional
	public Event getEvent(String name) {
		Event event = entityManager.find(Event.class, name);
		return event;
	}
	
	@Transactional 
	public Car getCar(String name) {
		Car car = entityManager.find(Car.class, name);
		return car;
	}
	
}
