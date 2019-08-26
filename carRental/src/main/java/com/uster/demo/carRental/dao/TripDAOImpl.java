/**
 * 
 */
package com.uster.demo.carRental.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uster.demo.carRental.entity.Driver;
import com.uster.demo.carRental.entity.Trip;
import com.uster.demo.carRental.entity.Vehicle;
import com.uster.demo.carRental.utilities.CustomNotFoundException;

/**
 * @author DM
 *
 */
@Repository
public class TripDAOImpl implements TripDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	private VehicleDAO vehicleDAO;
	private DriverDAO driverDAO;

	// set up constructor injection
	@Autowired
	public TripDAOImpl(EntityManager theEntityManager, VehicleDAO vehicleDAO, DriverDAO driverDAO) {
		entityManager = theEntityManager;
		this.vehicleDAO = vehicleDAO;
		this.driverDAO = driverDAO;
	}

	@Override
	public List<Trip> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Trip> theQuery = currentSession.createQuery("from Trip", Trip.class);

		// execute query and get result list
		List<Trip> listTrips = theQuery.getResultList();

		List<Trip> trips = getDriverVehiclesTrips(listTrips);

		// return the results
		return trips;
	}

	/**
	 * @param trip
	 */
	@Override
	public void save(Trip trip) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// validate vehicle availability
		validateVehicleAvailability(trip, currentSession);

		// validate vehicle availability
		validateDriverAvailability(trip, currentSession);

		// validate Vehicle's / Driver's license match
		validateLicenseMatch(trip);

		// save trip
		currentSession.saveOrUpdate(trip);

	}

	/**
	 * @param trip
	 */
	private void validateLicenseMatch(Trip trip) {

		VehicleDAO vehicle = new VehicleDAOImpl(entityManager);
		String vehicleLicense = vehicle.findById(Integer.valueOf(trip.getIdVehicles())).getLicenseRequired();

		DriverDAO driver = new DriverDAOImpl(entityManager);
		String driverLicense = driver.findById(Integer.valueOf(trip.getIdDrivers())).getLicense();

		if (!vehicleLicense.equals(driverLicense)) {
			throw new CustomNotFoundException("Vehicle's/Driver's license not match");
		}
	}

	/**
	 * @param trip
	 * @param currentSession
	 */
	private void validateVehicleAvailability(Trip trip, Session currentSession) {

		Query<Trip> query = currentSession.createQuery("from Trip where idvehicles =:idvehicles and date=:date",
				Trip.class);
		query.setParameter("idvehicles", trip.getIdVehicles());
		query.setParameter("date", trip.getDate());
		List<Trip> list = query.getResultList();

		if (list.size() > 0) {
			throw new CustomNotFoundException("Vehicle is already reserved for this date");
		}
	}

	/**
	 * @param trip
	 * @param currentSession
	 */
	private void validateDriverAvailability(Trip trip, Session currentSession) {

		Query<Trip> query = currentSession.createQuery("from Trip where iddrivers =:iddrivers and date=:date",
				Trip.class);
		query.setParameter("iddrivers", trip.getIdDrivers());
		query.setParameter("date", trip.getDate());
		List<Trip> list = query.getResultList();

		if (list.size() > 0) {
			throw new CustomNotFoundException("Driver is already assigned for this date");
		}
	}

	/**
	 * @param listTrips
	 * @return
	 */
	private List<Trip> getDriverVehiclesTrips(List<Trip> lstTr) {
		List<Trip> trips = new ArrayList<Trip>();
		List<Vehicle> veh = this.vehicleDAO.findAll();
		List<Driver> dri = this.driverDAO.findAll();

		for (Trip t : lstTr) {
			for (Vehicle v : veh) {
				for (Driver d : dri) {
					if (Integer.valueOf(v.getIdvehicles()).equals(Integer.valueOf(t.getIdVehicles()))) {
						if (Integer.valueOf(t.getIdDrivers()).equals(Integer.valueOf(d.getIddrivers()))) {
							trips.add((new Trip(t.getIdTrip(), v.getBrand() + " " + v.getModel(),
									d.getName() + " " + d.getSurname(), t.getDate())));
						}
					}
				}
			}
		}
		return trips;
	}

}
