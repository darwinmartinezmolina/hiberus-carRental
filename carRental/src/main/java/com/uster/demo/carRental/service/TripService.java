/**
 * 
 */
package com.uster.demo.carRental.service;

import java.util.List;

import com.uster.demo.carRental.entity.Trip;

/**
 * @author DM
 *
 */
public interface TripService {
	
	public List<Trip> findAll();
	
	public void save(Trip trip);
	

}
