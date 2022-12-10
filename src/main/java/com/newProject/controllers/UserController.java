package com.newProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.newProject.Dto.UserDto;
import com.newProject.Pojo.ResponseContent;
import com.newProject.models.User;
import com.newProject.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
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
		System.out.println("User Email is "+email);;
		UserDto userDetail = userservice.fetchEmail(email);
		//System.out.println("User detail is "+userDetail.toString());
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

	@PostMapping(value = "User/login")
	public ResponseEntity<String> userLogin(@RequestBody UserDto userDeatil) {
		ResponseContent response = userservice.verifyANdLoginUser(userDeatil);
		if (response.getStatusCode() == 200) {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.OK);
		} else if (response.getStatusCode() == 404) {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
