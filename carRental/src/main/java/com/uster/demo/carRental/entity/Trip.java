package com.uster.demo.carRental.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trip")
public class Trip {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtrip")
	private int idTrip;
	
	@Column(name="idvehicles")
	private String idVehicles;
	
	@Column(name="iddrivers")
	private String idDrivers;
	
	@Column(name="date")
	private Date date;

	/**
	 * Default constructor
	 */
	public Trip() {
		
	}

	/**
	 * @param idVehicles
	 * @param idDrivers
	 * @param date
	 */
	public Trip(int idTrip, String idVehicles, String idDrivers, Date date) {
		this.idTrip = idTrip;
		this.idVehicles = idVehicles;
		this.idDrivers = idDrivers;
		this.date = date;
	}
	
	

	/**
	 * @return the idTrip
	 */
	public int getIdTrip() {
		return idTrip;
	}

	/**
	 * @param idTrip the idTrip to set
	 */
	public void setIdTrip(int idTrip) {
		this.idTrip = idTrip;
	}

	/**
	 * @return the idVehicles
	 */
	public String getIdVehicles() {
		return idVehicles;
	}

	/**
	 * @param idVehicles the idVehicles to set
	 */
	public void setIdVehicles(String idVehicles) {
		this.idVehicles = idVehicles;
	}

	/**
	 * @return the idDrivers
	 */
	public String getIdDrivers() {
		return idDrivers;
	}

	/**
	 * @param idDrivers the idDrivers to set
	 */
	public void setIdDrivers(String idDrivers) {
		this.idDrivers = idDrivers;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Trip [idTrip=" + idTrip + ", idVehicles=" + idVehicles + ", idDrivers=" + idDrivers + ", date=" + date
				+ "]";
	}


	
	
	
	
	
	
	
	
}
