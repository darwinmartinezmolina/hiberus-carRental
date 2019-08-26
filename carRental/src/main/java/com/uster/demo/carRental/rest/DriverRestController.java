/**
 * 
 */
package com.uster.demo.carRental.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uster.demo.carRental.entity.Driver;
import com.uster.demo.carRental.service.DriverService;
import com.uster.demo.carRental.utilities.CustomNotFoundException;

/**
 * @author DM
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DriverRestController {

	private DriverService driverService;
	
	@Autowired
	public DriverRestController(DriverService theDriverService) {
		driverService = theDriverService;
	}
	
	// expose "/drivers" and return list of drivers
	@GetMapping("/drivers")
	public List<Driver> findAll(){
		return driverService.findAll();
	}
	
	// add mapping for GET /drivers/{iddrivers}
	@GetMapping("/drivers/{iddrivers}")
	public Driver getDriver(@PathVariable int iddrivers) {
		Driver driver = driverService.findById(iddrivers);
		
		if(driver == null) {
			throw new CustomNotFoundException("Driver id not found - " + iddrivers);
		}
		
		return driver;
	}
	
	// add mapping for POST /drivers - add new driver
	
	@PostMapping("/drivers")
	public Driver addDriver(@RequestBody Driver driver) {
		
		// also just in case they pass an in in JSON... set id to 0
		// this is to force a save of new item ... instead of update
		
		driver.setIddrivers(0);
		
		driverService.save(driver);
		
		return driver;
	}
	
	// ADD Mapping for PUT /drivers - update existing driver
	@PutMapping("/drivers")
	public Driver updateDriver(@RequestBody Driver driver) {
		
		driverService.save(driver);
		
		return driver;
	}
	
	
	// add mapping for DELETE /drivers/{iddrivers} - delete driver
	@DeleteMapping("/drivers/{iddrivers}")
	public void deleteDriver(@PathVariable int iddrivers) {
		
		Driver tempDriver = driverService.findById(iddrivers);
		
		// throw exception if null
		if(tempDriver == null) {
			throw new CustomNotFoundException("Driver id not found - " + iddrivers);
		}
		
		driverService.deleteById(iddrivers);
				
	}
}
