/**
 * 
 */
package com.uster.demo.carRental.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uster.demo.carRental.dao.UtilsDAO;
import com.uster.demo.carRental.dao.VehicleDAO;
import com.uster.demo.carRental.entity.Driver;
import com.uster.demo.carRental.entity.Vehicle;

/**
 * @author DM
 *
 */
@Service
public class UtilsServiceImpl implements UtilsService {
	
	private UtilsDAO utilsDAO;
	
	@Autowired
	public UtilsServiceImpl(UtilsDAO utilsDAO) {
		this.utilsDAO = utilsDAO;
	}

	@Override
	@Transactional
	public List<Vehicle> findVehiclesAvailables(Date date) {
		return utilsDAO.findVehiclesAvailables(date);
	}

	@Override
	@Transactional
	public List<Driver> findDriverAvailables(Date date, String license) {
		return utilsDAO.findDriverAvailables(date, license);
	}

}
