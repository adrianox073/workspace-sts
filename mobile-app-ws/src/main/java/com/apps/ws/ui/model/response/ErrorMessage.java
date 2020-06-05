package com.apps.ws.ui.model.response;

public enum ErrorMessage {

	MISSING_REQUIRED_FIELD("Campo requerido no enviado"), RECORD_ALREADY_EXIST("Registro ya existe"),
	RECORD_NOT_FOUND("Error en el servidor"), INTERNAL_SERVER_ERROR("Error en el servidor"),
	AUTHENTICATION_ERROR("Error en el servidor"), COULD_NOT_UPDATE_RECORD("Error en el servidor"),
	COULD_NOT_DELETE_RECORD("Error en el servidor"), EMAIL_ADDRES_NOT_VERIFIED("Email no verificado");

	private String errorMessage;

	ErrorMessage(String erroMessage) {
		this.errorMessage = erroMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}