/**
 * 
 */
package com.uster.demo.carRental.dao;

import java.util.List;

import com.uster.demo.carRental.entity.Driver;	

/**
 * @author DM
 *
 */
public interface DriverDAO {
	
	public List<Driver> findAll();
	
	public Driver findById(int id);
	
	public void save(Driver driver);
	
	public void deleteById(int id);

}
