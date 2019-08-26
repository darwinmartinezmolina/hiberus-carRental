/**
 * 
 */
package com.uster.demo.carRental.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uster.demo.carRental.entity.Trip;
import com.uster.demo.carRental.service.TripService;

/**
 * @author DM
 *
 */

@RestController 
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TripRestController {

	private TripService tripService;
	
	@Autowired
	public TripRestController(TripService tripService) {
		this.tripService = tripService;
	}
	
	// expose "/trips" and return list of trips
	@GetMapping("/trips") 
	public List<Trip> findAll(){
		return tripService.findAll();
	}
	
	// add mapping for POST /trips - add new trips
	
	@PostMapping("/trips")
	public Trip addTrip(@RequestBody Trip trip) {
				
		tripService.save(trip);
		
		return trip;
	}
}
