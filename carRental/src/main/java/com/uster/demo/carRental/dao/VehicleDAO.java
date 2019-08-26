/**
 * 
 */
package com.uster.demo.carRental.dao;

import java.util.List;

import com.uster.demo.carRental.entity.Vehicle;

	

/**
 * @author DM
 *
 */
public interface VehicleDAO {
	
	public List<Vehicle> findAll();
	
	public Vehicle findById(int id);
	
	public void save(Vehicle vehicle);
	
	public void deleteById(int id);

}
