package ca.mcgill.ecse321.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.eventregistration.model.Car;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.repository.EventRegistrationRepository;

@RestController
public class EventRegistrationController {

	@Autowired
	EventRegistrationRepository repository;

	@RequestMapping("/")
	public String greeting() {
		return "Welcome to RideShareIncorporated";
	}
	
	// Posting towards MySQL DB storing a type of car 
	// 
	@PostMapping("/cars/{name}/{makeOfCar}/{numSeats}/{carType}/{numDoors}/{driveType}")
	public String createCar(@PathVariable("name") String name,@PathVariable("makeOfCar") String makeOfCar,@PathVariable("numSeats") Integer numSeats,@PathVariable("carType") String carType,@PathVariable("numDoors") Integer numDoors,@PathVariable("driveType") String driveType) {
		Car car = repository.createCar( name, makeOfCar, numSeats, carType, numDoors, driveType);
		return car.getName();
	}
	
	
	// Posting towards the MySQL data base storing an participant and an associated integer to distinguish
	// Between driver and passenger 
	@PostMapping("/participants/{name}/{isDriver}")
	public String createParticipant(@PathVariable("name") String name,@PathVariable("isDriver") Integer isDriver) {
		Participant participant = repository.createParticipant(name,isDriver);
		return participant.getName();
	}
	
	//example request http://localhost:8080/event/teaparty/05 SEPTEMBER 2019/10:33:12/16:00:00/6/Mtl/Toronto
	@PostMapping("/event/{name}/{eventDate}/{startTime}/{endTime}/{startLocation}/{endLocation}/{carType}/{driveType}/{makeOfCar}/{meterPerStop}/{seats}")
	public String createEvent(
			@PathVariable("name") String name,
			@PathVariable("eventDate") String eventDate,
			@PathVariable("startTime") String startTime,
			@PathVariable("endTime") String endTime,
			@PathVariable("startLocation") String startLocation,
			@PathVariable("endLocation") String endLocation,
			@PathVariable("carType") String carType,
			@PathVariable("driveType") String driveType,
			@PathVariable("makeOfCar") String makeOfCar,
			@PathVariable("meterPerStop") Double meterPerStop,
			@PathVariable("seats") Integer seats)
	{
		String eventInfo = "";
		Event event = repository.createEvent(name,eventDate,startTime,endTime,startLocation,endLocation, carType, driveType, makeOfCar, meterPerStop, seats);
		eventInfo += "Event name: " + event.getName() + "\n";
		eventInfo += "Event date: " + event.getEventDate() + "\n";
		eventInfo += "Start time: " + event.getStartTime() + "\n";
		eventInfo += "End time: " + event.getEndTime() + "\n";
		eventInfo += "Start location: " + event.getStartLocation() + "\n";
		eventInfo += "End location: " + event.getEndLocation() + "\n";
		eventInfo += "Car Type: " + event.getCarType() + "\n";
 		eventInfo += "Drive Type: " + event.getDriveType() + "\n";
		eventInfo += "Car Make: " + event.getMakeOfCar() + "\n";
 		eventInfo += "Price/stop: " + event.getMeterPerStop() + "\n";
		eventInfo += "Seats available: " + event.getSeats() + "\n";
		return eventInfo;
	}
	
	// Once car object has been posted in MySQL DB then to retrieve the object, do this 
	@GetMapping("/cars/{name}")
	public String queryCar(@PathVariable("name") String name) {
		Car car = repository.getCar(name);
		if( car == null) {
			return "NOT FOUND";
		}
		return "Name of Car: " + car.getName() + "/Make of Car: " + car.getMakeOfCar() + "/# of Seats: " + car.getNumSeats() + "/Car Type: " + car.getCarType() + "/Doors: " + car.getNumDoors() + "/Drive Type: " + car.getDriveType(); 
	}
	
	// Once post mapping has successfully stored a participant in the DB, to query it and test API to see if the
	// Participant could be retrieved use this function 
	@GetMapping("/participants/{name}")
	public String queryParticipant(@PathVariable("name") String name) {
		Participant participant = repository.getParticipant(name);
		if(participant == null) {
			return "NOT FOUND";
		}
		return "Name of Participant: " + participant.getName();
	}
	
	// This function follows the same logic as the its counter part where it was posting towards the DB
	// Same logic as the function before, use this to retrieve a stored event in the SQL data base 
	@GetMapping("/event/{name}")
	public String queryEvent(@PathVariable("name") String name) {
		Event event = repository.getEvent(name);
		if(event == null) {
			return "NOT FOUND";
		}
		//to test post: http://localhost:8080/event/teaparty/05 SEPTEMBER 2019/10:33:12/16:00:00/6/21.3,34.2/12.3,34.0
		//then get http://localhost:8080/event/teaparty/
		return "Event Name: " + event.getName() + "/ Event Date: " + event.getEventDate() + "/ Start Time: " + event.getStartTime() + "/ End Time: " + event.getEndTime() + "/ # of Seats: " + event.getSeats() + "/ Start Location: " + event.getStartLocation() + "/ End Location: " + event.getEndLocation();
	}

}