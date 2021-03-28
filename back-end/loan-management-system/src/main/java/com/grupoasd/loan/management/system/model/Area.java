/**
 * 
 */
package com.grupoasd.loan.management.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Area
 * 
 * Este Entity representa el area que realizara el prestamo en mi sistema.
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@Entity
public class Area {
	
	/**
	 * Indica el id del registro
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/**
	 * Indica el nombre del area
	 */
	@Column(name = "name", nullable = false)
	private String name;
	
	/**
	 * Indica la ciudad donde se encuentra el area
	 */
	@Column(name = "city", nullable = false)
	private String city;
	
	/**
	 * Indica la direccion del area
	 */
	@Column(name = "address")
	private String address;
	
	@OneToOne(mappedBy = "area")
	private Loan loan;

	/**
	 * Constructor for default
	 */
	public Area() {
		//Empty
	}
	
	/**
	 * Constructor
	 */
	public Area(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the loan
	 */
	public Loan getLoan() {
		return loan;
	}

	/**
	 * @param loan the loan to set
	 */
	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}
