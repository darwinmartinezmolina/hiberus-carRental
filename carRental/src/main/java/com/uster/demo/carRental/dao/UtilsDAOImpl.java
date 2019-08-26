/**
 * 
 */
package com.uster.demo.carRental.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uster.demo.carRental.entity.Driver;
import com.uster.demo.carRental.entity.Vehicle;

/**
 * @author H514316
 *
 */
@Repository
public class UtilsDAOImpl implements UtilsDAO {
	
	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public UtilsDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Vehicle> findVehiclesAvailables(Date date) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Vehicle> query =
				currentSession.createQuery("select distinct v from Vehicle v left join "
											+ "Trip t on t.idVehicles = v.idvehicles and t.date =:date "
											+ "where idTrip is null", Vehicle.class);
		query.setParameter("date", date);
		
		// execute query and get result list
		List<Vehicle> vehicles = query.getResultList();

		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}			
		
		return vehicles;
	}

	@Override
	public List<Driver> findDriverAvailables(Date date, String license) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Driver> query =
				currentSession.createQuery("select distinct d from Driver d left join "
											+ "Trip t on t.idDrivers = d.iddrivers and t.date =:date "
											+ "where idTrip is null and d.license =:license", Driver.class);
		query.setParameter("date", date);
		query.setParameter("license", license);
		
		// execute query and get result list
		List<Driver> drivers = query.getResultList();

		for (Driver driver : drivers) {
			System.out.println(driver.toString());
		}			
		
		return drivers;
	}

}
