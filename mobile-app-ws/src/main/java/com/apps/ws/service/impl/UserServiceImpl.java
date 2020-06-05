package com.apps.ws.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.ws.io.entity.UserEntity;
import com.apps.ws.io.repositories.UserRepository;
import com.apps.ws.service.UserService;
import com.apps.ws.shared.Utils;
import com.apps.ws.shared.dto.UserDTO;
import com.apps.ws.ui.model.response.ErrorMessage;

@Service
@EntityScan(basePackages = { "com.app.ws.io.entity" })
// @EnableJpaRepositories(basePackages = { "com.springbootdev.domain.repository" })
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	Utils utils;

	@Override
	public UserDTO createUser(UserDTO userDto) {

		if (userRepository.findByEmail(userDto.getEmail()) != null) {
			throw new RuntimeException("Registro ya existe");
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(utils.getGeneratedUserId(30));

		UserEntity storedUserEntity = userRepository.save(userEntity);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(storedUserEntity, returnValue);

		return returnValue;
	}

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
		;
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());

	}

	@Override
	public UserDTO findById(String id) {
		// TODO Auto-generated method stub
		UserDTO userDto = new UserDTO();
		UserEntity userE = userRepository.findByUserId(id);

		if (userE == null)
			throw new UsernameNotFoundException(id);

		BeanUtils.copyProperties(userE, userDto);

		return userDto;
	}

	@Override
	public UserDTO getUser(String email) {
		// TODO Auto-generated method stub
		UserDTO userDto = new UserDTO();
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
		;

		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;
	}

	public UserDTO updateUser(String id, UserDTO userdto) {
		UserDTO userDto = new UserDTO();
		UserEntity userE = userRepository.findByUserId(id);

		if (userE == null)
			throw new UsernameNotFoundException(ErrorMessage.RECORD_NOT_FOUND.getErrorMessage());

		userE.setFirstName(userDto.getFirstName());
		userE.setLastname(userDto.getLastname());

		userRepository.save(userE);

		BeanUtils.copyProperties(userE, userDto);
		return userDto;
	}

}