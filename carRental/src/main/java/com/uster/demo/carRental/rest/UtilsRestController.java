/**
 * 
 */
package com.uster.demo.carRental.rest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uster.demo.carRental.entity.Driver;
import com.uster.demo.carRental.entity.Vehicle;
import com.uster.demo.carRental.service.UtilsService;
import com.uster.demo.carRental.utilities.CustomNotFoundException;

/**
 * @author DM
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UtilsRestController {

private UtilsService utilsService;
	
	@Autowired
	public UtilsRestController(UtilsService utilsService) {
		this.utilsService = utilsService;
	}
		
	// add mapping for GET /utils/vehicles/{date}
	@GetMapping("/utils/vehicles/{date}")
	public List<Vehicle> findVehiclesAvailables(@PathVariable Date date) {	
		
		List<Vehicle> vehicles = utilsService.findVehiclesAvailables(date);
		
		// throw exception if null
		if(vehicles.size() == 0) {
			throw new CustomNotFoundException("No vehicles availables for this date - " + date);
		}
		
		return vehicles;
	}
	
	// add mapping for GET /utils/drivers/{date}
	@GetMapping("/utils/drivers/{date}/{license}")
	public List<Driver> findDriversAvailables(@PathVariable Date date, @PathVariable String license) {	
		
		List<Driver> drivers = utilsService.findDriverAvailables(date, license);
		
		// throw exception if null
		if(drivers.size() == 0) {
			throw new CustomNotFoundException("No drivers availables for this date - " + date);
		}
		
		return drivers;
	}
}
