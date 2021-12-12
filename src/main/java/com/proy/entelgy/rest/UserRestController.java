package com.proy.entelgy.rest;

import com.proy.entelgy.rest.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proy.entelgy.service.business.dto.UserDTOResponse;
import com.proy.entelgy.service.business.rule.UserService;

@RestController
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/datarai")
	public UserResponse generarData() {
		
		return userService.invocarServicioExterno();
		
	}
	
	
	

}
