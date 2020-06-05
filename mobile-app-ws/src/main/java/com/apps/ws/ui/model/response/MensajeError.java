package com.apps.ws.ui.model.response;

import java.util.Date;

public class MensajeError {

	private Date timestamp;
	private String message;

	public MensajeError() {

	}

	public MensajeError(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
