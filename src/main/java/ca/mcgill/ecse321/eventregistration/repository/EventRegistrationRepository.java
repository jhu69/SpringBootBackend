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
	
	
	@Transactional
	public Event createEvent(String name,String eventDate,String startTime,String endTime,Integer seats,String startLocation,String endLocation) {
		Event event= new Event();
		
		java.util.Date tmpDate = null;
		try {
			tmpDate = new SimpleDateFormat("dd MMM yyyy").parse(eventDate);//"01 NOVEMBER 2018"
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(tmpDate.getTime());
		//"10:34:34"
		Time sqlStart = Time.valueOf(startTime);
		Time sqlEnd = Time.valueOf(endTime);
		event.setName(name);
		event.setEventDate(sqlDate);
		event.setStartTime(sqlStart);
		event.setEndTime(sqlEnd);
		event.setSeats(seats);
		event.setStartLocation(startLocation);
		event.setEndLocation(endLocation);
		entityManager.persist(event);
		return event;
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