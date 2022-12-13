package com.bfs.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfs.tms.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByUsername(String username);
	Customer findByCustomerId(Integer customerId);
	Boolean existsByUsername(String username);
}
