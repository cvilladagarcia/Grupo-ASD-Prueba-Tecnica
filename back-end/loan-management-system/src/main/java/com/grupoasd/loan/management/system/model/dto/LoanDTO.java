/**
 * 
 */
package com.grupoasd.loan.management.system.model.dto;

import java.io.Serializable;

/**
 * LoanDTO
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 28/03/2021
 */
public class LoanDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9086928521594132039L;

	private Long id;
	
	private Long asset_id;
	
	private Long area_id;
	
	private Long person_id;

	/**
	 * Constructor
	 */
	public LoanDTO() {
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
	 * @return the asset_id
	 */
	public Long getAsset_id() {
		return asset_id;
	}

	/**
	 * @param asset_id the asset_id to set
	 */
	public void setAsset_id(Long asset_id) {
		this.asset_id = asset_id;
	}

	/**
	 * @return the area_id
	 */
	public Long getArea_id() {
		return area_id;
	}

	/**
	 * @param area_id the area_id to set
	 */
	public void setArea_id(Long area_id) {
		this.area_id = area_id;
	}

	/**
	 * @return the person_id
	 */
	public Long getPerson_id() {
		return person_id;
	}

	/**
	 * @param person_id the person_id to set
	 */
	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
	
}