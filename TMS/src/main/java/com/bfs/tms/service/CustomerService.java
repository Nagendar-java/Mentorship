package com.bfs.tms.service;

import com.bfs.tms.model.Customer;
import com.bfs.tms.model.UserDTO;
import com.bfs.tms.resp.ResponseTemplate;

public interface CustomerService {

	 Customer registerUser(Customer u);

	Customer findByUsername(String username);

	
	Customer upadteCustomer(Customer cust);

	//ResponseTemplate findByCustomerId(Integer customerId);

	//ResponseTemplate getCustomerWithTransaction(Integer customerId);

	Customer findByCustomerId(Integer customerId);

	



}
