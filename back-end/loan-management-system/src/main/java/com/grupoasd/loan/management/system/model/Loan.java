/**
 * 
 */
package com.grupoasd.loan.management.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Loan
 * 
 * Este Entity representa el prestamo en mi sistema
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@Entity
public class Loan {

	/**
	 * Indica el ID del registro
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/**
	 * Indica el activo a prestamo
	 */
	@OneToOne
	@JoinColumn(name = "assetId", updatable = false, nullable = false)
	private Asset asset;
	
	/**
	 * Indica la persona que realizo el prestamo
	 */
	@OneToOne
	@JoinColumn(name = "personId", updatable = false, nullable = true)
	private Person person;
	
	/**
	 * Indica el area que realizo el prestamo
	 */
	@OneToOne
	@JoinColumn(name = "areaId", updatable = false, nullable = true)
	private Area area;

	/**
	 * Constructor
	 */
	public Loan() {
		// Empty
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
	 * @return the asset
	 */
	public Asset getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}
	
}
