/**
 * 
 */
package com.uster.demo.carRental.service;

import java.sql.Date;
import java.util.List;

import com.uster.demo.carRental.entity.Driver;
import com.uster.demo.carRental.entity.Vehicle;

/**
 * @author DM
 *
 */
public interface UtilsService {

	public List<Vehicle> findVehiclesAvailables(Date date);
	
	public List<Driver> findDriverAvailables(Date date, String license);
}
