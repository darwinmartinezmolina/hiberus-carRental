package com.uster.demo.carRental.service;

import java.util.List;

import com.uster.demo.carRental.entity.Driver;

/**
 * @author DM
 *
 */
public interface DriverService {

	public List<Driver> findAll();
	
	public Driver findById(int id);
	
	public void save(Driver driver);
	
	public void deleteById(int id);
}
