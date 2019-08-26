package com.uster.demo.carRental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="drivers")
public class Driver {

	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddrivers")
	private int iddrivers;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="license")
	private String license; 

	/**
	 * Default constructor
	 */
	public Driver() {
	}

	/**
	 * @param name
	 * @param surname
	 * @param license
	 */
	public Driver(String name, String surname, String license) {		
		this.name = name;
		this.surname = surname;
		this.license = license;
	}

	/**
	 * @return the iddrivers
	 */
	public int getIddrivers() {
		return iddrivers;
	}

	/**
	 * @param iddrivers the iddrivers to set
	 */
	public void setIddrivers(int iddrivers) {
		this.iddrivers = iddrivers;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "Driver [iddrivers=" + iddrivers + ", name=" + name + ", surname=" + surname + ", license=" + license
				+ "]";
	}
	
	
	
	
	
	
	

	
	
}
