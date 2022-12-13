package com.bfs.tms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfs.tms.model.Customer;
import com.bfs.tms.model.UserDTO;
import com.bfs.tms.repository.CustomerRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	CustomerRepository custRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = custRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
//	public Customer save(UserDTO user) {
//		
//		Customer newUser = new Customer();
//		newUser.setUsername(user.getUsername());
//		//newUser.setPassword(user.getPassword());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setCname(user.getCname());
//		newUser.setAddress(user.getAddress());
//		newUser.setState(user.getState());
//		newUser.setCountry(user.getCountry());
//		newUser.setEmail(user.getEmail());
//		newUser.setPanNo(user.getPanNo());
//		newUser.setContactNo(user.getContactNo());
//		newUser.setDob(user.getDob());
//		newUser.setAccountType(user.getAccountType());
//		newUser.setTransctionId(user.getTransctionId());
//		return custRepo.save(newUser);
//	}
}
