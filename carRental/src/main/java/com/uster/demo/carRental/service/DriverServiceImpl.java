/**
 * 
 */
package com.uster.demo.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uster.demo.carRental.dao.DriverDAO;
import com.uster.demo.carRental.entity.Driver;

/**
 * @author DM
 *
 */
@Service
public class DriverServiceImpl implements DriverService {
	
	private DriverDAO driverDAO;
	
	@Autowired
	public DriverServiceImpl(DriverDAO driverDAO) {
		this.driverDAO = driverDAO;
	}

	@Override
	@Transactional
	public List<Driver> findAll() {
		return driverDAO.findAll();
	}

	@Override
	@Transactional
	public Driver findById(int id) {
		return driverDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Driver driver) {
		driverDAO.save(driver);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		driverDAO.deleteById(id);
	}

}
