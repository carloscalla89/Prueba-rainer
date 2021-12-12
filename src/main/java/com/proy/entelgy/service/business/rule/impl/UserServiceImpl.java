package com.proy.entelgy.service.business.rule.impl;

import com.proy.entelgy.rest.dto.UserResponse;
import com.proy.entelgy.service.business.dto.UserDTOResponse;
import com.proy.entelgy.service.business.proxy.ApiExterna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.proy.entelgy.service.business.rule.UserService;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

	private ApiExterna apiExterna;

	@Autowired
	public UserServiceImpl(ApiExterna apiExterna) {
		this.apiExterna = apiExterna;
	}

	@Override
	public UserResponse invocarServicioExterno() {

		UserResponse userResponse =  new UserResponse();
		userResponse.setData(apiExterna
				.getApiExterna()
				.getData()
				.stream()
				.map(val -> val.getId() + "|" + val.getLast_name() + "|" + val.getEmail())
				.collect(Collectors.toList()));

		return userResponse;
	}
}
