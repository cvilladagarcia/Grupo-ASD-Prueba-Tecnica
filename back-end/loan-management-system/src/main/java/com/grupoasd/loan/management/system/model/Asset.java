/**
 * 
 */
package com.grupoasd.loan.management.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Asset
 * 
 * Este Entity representa el activo que sera prestado a las personas o areas en mi sistema. 
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@Entity
public class Asset {
	
	/**
	 * Indica el id del registros
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/**
	 * Indica el nombre del activo
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Indica una descripcion sobre el activo
	 */
	@Column(name = "description")
	private String description;

	/**
	 * Indica el tipo del activo
	 */
	@Column(name = "assettype")
	private String assetType;
	
	/**
	 * Indica el serial del activo
	 */
	@Column(name = "serial", nullable = false, unique = true)
	private String serial;
	
	/**
	 * Indica el numero de inventario del activo
	 */
	@Column(name = "numberinventory", nullable = false, unique = true)
	private String numberInventory;
	
	/**
	 * Indica el peso del activo
	 */
	@Column(name = "weight")
	private String weight;
	
	/**
	 * Indica la altura del activo
	 */
	@Column(name = "height")
	private String height;
	
	/**
	 * Indica el ancho del activo
	 */
	@Column(name = "broad")
	private String broad;
	
	/**
	 * Indica el largo del activo
	 */
	@Column(name = "length")
	private String length;
	
	/**
	 * Indica el precio de compra del activo
	 */
	@Column(name = "purchasevalue")
	private String purchaseValue;
	
	/**
	 * Indica la fecha de compra del activo
	 */
	@Column(name = "purchasedate")
	private Date purchaseDate;
	
	/**
	 * Indica la fecha de dado de baja del activo
	 */
	@Column(name = "retirementdate")
	private Date retirementDate;
	
	/**
	 * Indica el estado del activo
	 */
	@Column(name = "assetstate")
	private String assetState;
	
	/**
	 * Indica el color del activo
	 */
	@Column(name = "color")
	private String color;
	
	@OneToOne(mappedBy = "asset")
	private Loan loan;
	
	/**
	 * Constructor for default
	 */
	public Asset() {
		// Empty
	}
	
	/**
	 * Constructor
	 */
	public Asset(Long id) {
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
	 * @return the descripcion
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the assetType
	 */
	public String getAssetType() {
		return assetType;
	}

	/**
	 * @param assetType the assetType to set
	 */
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the numberInventory
	 */
	public String getNumberInventory() {
		return numberInventory;
	}

	/**
	 * @param numberInventory the numberInventory to set
	 */
	public void setNumberInventory(String numberInventory) {
		this.numberInventory = numberInventory;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the broad
	 */
	public String getBroad() {
		return broad;
	}

	/**
	 * @param broad the broad to set
	 */
	public void setBroad(String broad) {
		this.broad = broad;
	}

	/**
	 * @return the length
	 */
	public String getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * @return the purchaseValue
	 */
	public String getPurchaseValue() {
		return purchaseValue;
	}

	/**
	 * @param purchaseValue the purchaseValue to set
	 */
	public void setPurchaseValue(String purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the retirementDate
	 */
	public Date getRetirementDate() {
		return retirementDate;
	}

	/**
	 * @param retirementDate the retirementDate to set
	 */
	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * @return the assetState
	 */
	public String getAssetState() {
		return assetState;
	}

	/**
	 * @param assetState the assetState to set
	 */
	public void setAssetState(String assetState) {
		this.assetState = assetState;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
