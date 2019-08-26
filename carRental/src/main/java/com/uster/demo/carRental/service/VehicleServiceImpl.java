/**
 * 
 */
package com.uster.demo.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uster.demo.carRental.dao.VehicleDAO;
import com.uster.demo.carRental.entity.Vehicle;

/**
 * @author DM
 *
 */
@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleDAO vehicleDAO;
	
	@Autowired
	public VehicleServiceImpl(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}
	
	@Override
	@Transactional
	public List<Vehicle> findAll() {
		return vehicleDAO.findAll();
	}

	@Override
	@Transactional
	public Vehicle findById(int id) {
		return vehicleDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Vehicle vehicle) {
		vehicleDAO.save(vehicle);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		vehicleDAO.deleteById(id);
	}

}
