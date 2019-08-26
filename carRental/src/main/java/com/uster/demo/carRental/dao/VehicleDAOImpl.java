/**
 * 
 */
package com.uster.demo.carRental.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uster.demo.carRental.entity.Vehicle;

/**
 * @author DM
 *
 */
@Repository
public class VehicleDAOImpl implements VehicleDAO {
	
	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public VehicleDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Vehicle> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Vehicle> theQuery =
				currentSession.createQuery("from Vehicle", Vehicle.class);
		
		// execute query and get result list
		List<Vehicle> vehicles = theQuery.getResultList();
		
		
		
		//****************************************
	/*
		Criteria crit = currentSession.createCriteria(Vehicle.class);
		crit.add(Restrictions.not(Restrictions.in("idvehicles", 1)));
		List<Vehicle> list = crit.list();
		
		for (Vehicle vehicle : list) {
			System.out.println(vehicle.toString());
		}				
		*/
		

		//****************************************
				
		return vehicles;
	}

	@Override
	public Vehicle findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the vehicle
		Vehicle vehicle =
				currentSession.get(Vehicle.class, id);
		
		// return the vehicle		
		return vehicle;
	}

	@Override
	public void save(Vehicle vehicle) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save vehicle
		currentSession.saveOrUpdate(vehicle);

	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete vehicle
		Query theQuery =
				currentSession.createQuery("delete from Vehicle where idvehicles =:idvehicles");
		theQuery.setParameter("idvehicles", id);
		
		theQuery.executeUpdate();

	}

}
