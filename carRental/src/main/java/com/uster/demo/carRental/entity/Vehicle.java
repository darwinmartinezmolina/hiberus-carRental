package com.uster.demo.carRental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idvehicles")
	private int idvehicles;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="licenserequired") 
	private String licenseRequired;

	/**
	 * Default Constructor
	 */
	public Vehicle() {

	}

	/**
	 * @param brand
	 * @param model
	 * @param plate
	 * @param licenseRequired
	 */
	public Vehicle(String brand, String model, String plate, String licenseRequired) {

		this.brand = brand;
		this.model = model;
		this.plate = plate;
		this.licenseRequired = licenseRequired;
	}

	/**
	 * @return the idvehicles
	 */
	public int getIdvehicles() {
		return idvehicles;
	}

	/**
	 * @param idvehicles the idvehicles to set
	 */
	public void setIdvehicles(int idvehicles) {
		this.idvehicles = idvehicles;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * @return the licenseRequired
	 */
	public String getLicenseRequired() {
		return licenseRequired;
	}

	/**
	 * @param licenseRequired the licenseRequired to set
	 */
	public void setLicenseRequired(String licenseRequired) {
		this.licenseRequired = licenseRequired;
	}

	@Override
	public String toString() {
		return "Vehicle [idvehicles=" + idvehicles + ", brand=" + brand + ", model=" + model + ", plate=" + plate
				+ ", licenseRequired=" + licenseRequired + "]";
	}
	
	
	
	
	
	
	
	

}
