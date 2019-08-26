/**
 * 
 */
package com.uster.demo.carRental.dao;

import java.util.List;

import com.uster.demo.carRental.entity.Trip;

/**
 * @author DM
 *
 */
public interface TripDAO {

	public List<Trip> findAll();
	
	public void save(Trip trip);
	
}
