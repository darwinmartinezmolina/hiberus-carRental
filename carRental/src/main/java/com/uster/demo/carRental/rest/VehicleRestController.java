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
import org.springframework.web.bind.annotation.RestController;

import com.uster.demo.carRental.entity.Vehicle;
import com.uster.demo.carRental.service.VehicleService;
import com.uster.demo.carRental.utilities.CustomNotFoundException;

/**
 * @author DM
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VehicleRestController {

private VehicleService vehicleService;
	
	@Autowired
	public VehicleRestController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	// expose "/vehicles" and return list of vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> findAll(){
		return vehicleService.findAll();
	}
	
	// add mapping for GET /vehicles/{idvehicles}
	@GetMapping("/vehicles/{idvehicles}")
	public Vehicle getVehicle(@PathVariable int idvehicles) {
		Vehicle vehicle = vehicleService.findById(idvehicles);
		
		if(vehicle == null) {
			throw new CustomNotFoundException("Vehicle id not found - " + idvehicles);
		}
		
		return vehicle;
	}
	
	// add mapping for POST /drivers - add new driver
	
	@PostMapping("/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		
		// also just in case they pass an in in JSON... set id to 0
		// this is to force a save of new item ... instead of update
		
		vehicle.setIdvehicles(0);
		vehicleService.save(vehicle);
		
		return vehicle;
	}
	
	// ADD Mapping for PUT /vehicles - update existing vehicles
	
	@PutMapping("/vehicles")
	public Vehicle updateDriver(@RequestBody Vehicle vehicle) {
		
		vehicleService.save(vehicle);
		
		return vehicle;
	}
	
	
	// add mapping for DELETE /vehicles/{idvehicles} - delete vehicles
	@DeleteMapping("/vehicles/{idvehicles}")
	public void deleteVehicles(@PathVariable int idvehicles) {
		
		Vehicle tempVehicle = vehicleService.findById(idvehicles);
		
		// throw exception if null
		if(tempVehicle == null) {
			throw new CustomNotFoundException("Vehicle id not found - " + idvehicles);
		}
		
		vehicleService.deleteById(idvehicles);
		
	}

}
