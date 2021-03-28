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
 * Person
 * 
 * Este Entity representa la persona que realizara el prestamo en mi sistema.
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 26/03/2021
 */
@Entity
public class Person {
	
	/**
	 * Indica el id del registro
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/**
	 * Indica el tipo de identificacion de la persona
	 */
	@Column(name = "idtype", nullable = false)
	private String idType;
	
	/**
	 * Indica la identificacion de la persona
	 */
	@Column(name = "idnumber", nullable = false)
	private String idNumber;
	
	/**
	 * Indica los nombres de la persona
	 */
	@Column(name = "names")
	private String names;
	
	/**
	 * Indica los apellidos de la persona
	 */
	@Column(name = "surnames")
	private String surnames;
	
	/**
	 * Indica la fecha de nacimiento de la persona
	 */
	@Column(name = "brithdate")
	private Date brithDate;
	
	/**
	 * Indica la direccion de la persona
	 * (Esta direccion hubiese querido sacarla como una entidad aparte, pero por temas de tiempo toco dejarla como String)
	 */
	@Column(name = "address")
	private String address;
	
	@OneToOne(mappedBy = "person")
	private Loan loan;
	
	/**
	 * Constructor for default
	 */
	public Person() {
		// Empty
	}
	
	/**
	 * Constructor
	 */
	public Person(Long id) {
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
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the surnames
	 */
	public String getSurnames() {
		return surnames;
	}

	/**
	 * @param surnames the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * @return the brithDate
	 */
	public Date getBrithDate() {
		return brithDate;
	}

	/**
	 * @param brithDate the brithDate to set
	 */
	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
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
