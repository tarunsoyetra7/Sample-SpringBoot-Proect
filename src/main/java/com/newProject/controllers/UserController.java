package com.newProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.newProject.Dto.UserDto;
import com.newProject.models.User;
import com.newProject.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping(value = "User/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody UserDto userDetail) {
		log.info("User Data is {}",userDetail.toString());
		String response = userservice.addUsers(userDetail);
		return response;
		
	}
	
	@GetMapping(value = "User/id/{id}")
	public UserDto getUserById(@PathVariable Long id){

		UserDto userDetail = userservice.fetchId(id);
		return userDetail;
	}
	
	@GetMapping(value = "User/email/{email}")
	public UserDto getUserByEmail(@PathVariable String email){
		
		UserDto userDetail = userservice.fetchEmail(email);
		return userDetail;
	}
	
	@PutMapping(value = "User/update", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody User user) {

		String response = userservice.updateUsers(user);
		return response;
		
	}
	@DeleteMapping(value = "User/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		String response = userservice.deleteUser(id);
		return response;
	}

}
