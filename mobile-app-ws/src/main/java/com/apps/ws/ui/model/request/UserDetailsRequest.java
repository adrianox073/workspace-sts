package com.apps.ws.ui.model.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {

	@NotNull(message = "Nombre no puede ser nulo")
	private String firstName;

	@NotNull(message = "Apellido no puede ser nulo")
	private String lastname;

	@Email(message = "Debe indicar um email válido")
	private String email;

	@NotNull(message = "Password no puede ser nulo")
	@Size(min = 8, max = 16, message = "password debe ser mayor a 8 caracteres y menor a 16 caracteres")
	private String password;

	private List<AddressRequestModel> addresses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AddressRequestModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressRequestModel> addresses) {
		this.addresses = addresses;
	}

}
