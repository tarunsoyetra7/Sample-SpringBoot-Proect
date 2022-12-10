package com.newProject.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newProject.Dto.UserDto;
import com.newProject.Pojo.ResponseContent;
import com.newProject.models.User;
import com.newProject.repositories.UserRepository;
import com.newProject.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserRepository userRepository;
		
	ModelMapper mapper = new ModelMapper(); 

	@Override
	public String addUsers(UserDto userDetail) {

		if(!(userDetail == null)){
			User user = mapper.map(userDetail, User.class);
			try{
				log.info("Saving Data for User {}",user.getUserName());
				userRepository.save(user); 
				return "Data Saved Successfully";
			} catch(Exception e) {
				log.error("Error Occured While Saving User Data", e.getMessage());
				return e.getMessage();
			}
		} 
		log.info("User Detail is Empty Please Check ..........");
		return "User Detail is Empty";
	}
	
	@Override
	public String updateUsers(User user) {

		if(user.getId() != null){
			try{
				userRepository.save(user); 
				return "Data Update Successfully";
			} catch(Exception e) {
				return e.getMessage();
			}
		}
		return "User Id is Null";
	}
	
	@Override
	public UserDto fetchId(Long id){

		if(id != 0 || id != null){
			User userRecords = userRepository.getUserById(id);
			UserDto userDetail = mapper.map(userRecords, UserDto.class);
			return userDetail;	
		}
		return null;

	}

	@Override
	public UserDto fetchEmail(String email){
		
		if(!(email.isBlank() || email.isEmpty())){
			log.info("Email id is {}", email);
			User userRecords = userRepository.getUserByEmail(email);
			UserDto userDetail = mapper.map(userRecords, UserDto.class);
		
			return userDetail;
		}
		return null;
		
	}

	@Transactional
	@Override
	public String deleteUser(Long id) {

		if(id != 0 || id != null){
			try {
				userRepository.deleteById(id);
				return "User Deleted Successfully";
			}catch (Exception e) {
				return e.getMessage();
			}
		}
		return "User Id is Null";

	}

	@Override
	public ResponseContent verifyANdLoginUser(UserDto userDeatil) {
		ResponseContent response = new ResponseContent();
		try {
			User user = userRepository.getUserWithCredentials(userDeatil.getUserEmail() , userDeatil.getUserPass());
			if(user == null){
				response.setMessage("Invalid Username or Password");
				response.setStatusCode(404);
			} else {
				response.setMessage("Login Successful");
				response.setStatusCode(200);
			}
		} catch (Exception e) {
			response.setMessage("Server Error");
			response.setStatusCode(500);
			e.printStackTrace();
		}
		return response;
	}
	
}
