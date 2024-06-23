package com.example.demo.model;


import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class LoginUser {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private int shop_id;

}