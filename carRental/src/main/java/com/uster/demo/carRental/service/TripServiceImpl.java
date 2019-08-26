/**
 * 
 */
package com.uster.demo.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uster.demo.carRental.dao.TripDAO;
import com.uster.demo.carRental.entity.Trip;

/**
 * @author DM
 *
 */
@Service
public class TripServiceImpl implements TripService {

	private TripDAO tripDAO;
	
	@Autowired
	public TripServiceImpl(TripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}
	
	@Override
	@Transactional
	public List<Trip> findAll() {
		return tripDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Trip trip) {
		tripDAO.save(trip);

	}

}
