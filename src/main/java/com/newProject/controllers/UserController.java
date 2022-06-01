package com.newProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newProject.models.User;
import com.newProject.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("User/add")
	public String addUser(@RequestParam String username,@RequestParam String usermobile,@RequestParam String pass,@
			RequestParam String address,@RequestParam String usertype, @RequestParam String useremail) {
		String response = userservice.addUsers(username, usermobile, pass, address, usertype, useremail);
		return response;
		
	}
	
	@GetMapping("User/id/{id}")
	public User getUserById(@PathVariable Long id){
		
		User user = userservice.fetchId(id);
		return user;
	}
	
	@GetMapping("User/email/{email}")
	public User getUserByEmail(@PathVariable String email){
		
		User user = userservice.fetchEmail(email);
		return user;
	}
	
	@PostMapping("User/update")
	public String updateUser(@RequestParam Long id, @RequestParam String username,@RequestParam String usermobile,@RequestParam String pass,@
			RequestParam String address,@RequestParam String usertype, @RequestParam String useremail) {
		String response = userservice.updateUsers(id, username, usermobile, pass, address, usertype, useremail);
		return response;
		
	}
	@DeleteMapping("User/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		String response = userservice.deleteUser(id);
		return response;
	}

}
