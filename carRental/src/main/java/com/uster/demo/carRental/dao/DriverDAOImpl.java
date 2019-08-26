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

import com.uster.demo.carRental.entity.Driver;

/**
 * @author DM
 *
 */
@Repository
public class DriverDAOImpl implements DriverDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public DriverDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Driver> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		// create a query
		Query<Driver> theQuery =
				currentSession.createQuery("from Driver", Driver.class);
	
		
		// execute query and get result list
		List<Driver> drivers = theQuery.getResultList();
		
		// return the results		
		return drivers;
	}

	@Override
	public Driver findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the driver
		Driver driver =
				currentSession.get(Driver.class, id);
		
		// return the driver		
		return driver;
	}

	@Override
	public void save(Driver driver) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save driver
		currentSession.saveOrUpdate(driver);

	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete driver
		Query theQuery =
				currentSession.createQuery("delete from Driver where iddrivers =:iddrivers");
		theQuery.setParameter("iddrivers", id);
		
		theQuery.executeUpdate();

	}

}
