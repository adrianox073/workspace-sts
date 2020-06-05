package com.apps.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.apps.ws.shared.dto.UserDTO;

public interface UserService extends UserDetailsService {

	UserDTO createUser(UserDTO userD);

	UserDTO getUser(String email);

	UserDTO findById(String id);

	UserDTO updateUser(String id, UserDTO userdto);

}
