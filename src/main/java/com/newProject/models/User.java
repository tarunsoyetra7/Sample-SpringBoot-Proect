package com.newProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_master")
@Data
public class User {
	
	@Column(name = "user_name")
	private String userName;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_mobile")
	private String userMobile;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_address")
	private String userAddress;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "user_pass")
	private String userPass;

}
