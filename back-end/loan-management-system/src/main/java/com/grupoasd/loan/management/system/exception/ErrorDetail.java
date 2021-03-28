/**
 * 
 */
package com.grupoasd.loan.management.system.exception;

import java.util.Date;

/**
 * ErrorDetail
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 26/03/2021
 */
public class ErrorDetail {

	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetail(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
