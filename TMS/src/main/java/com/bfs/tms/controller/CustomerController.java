package com.bfs.tms.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfs.tms.model.Customer;
import com.bfs.tms.repository.CustomerRepository;
import com.bfs.tms.resp.ResponseTemplate;
import com.bfs.tms.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")

public class CustomerController {
	 private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
@Autowired 
private CustomerService custService;
 @Autowired
private AuthenticationManager authenticationManager;
@Autowired CustomerRepository custRepo;

	 
	@GetMapping(value="/hi")
	public String sayHi() {
		log.info("Welcome to Transaction Management Application");
		return "Hi welcome to TMS";
			}
	
	 
	 @PostMapping("/register")
	   public ResponseEntity<?> registerUser(@RequestBody Customer u) {
		 if(custRepo.existsByUsername(u.getUsername()))
		 {
			 return ResponseEntity.badRequest().body("Error:user already exists");
		 }
	       log.info("############CustomerController Signup#########");
	       Customer saveuser=custService.registerUser(u);
	   	return new ResponseEntity<>(saveuser,HttpStatus.CREATED);
	 } 
	 
	 
	
		@PostMapping("/login")
		public ResponseEntity<?> loginUser(@RequestBody Customer customer) {

			log.info("inside saveuser in customer controller");
			Customer cust = custService.findByUsername(customer.getUsername());
			return ResponseEntity.ok(cust);
		}

	 @PutMapping("/update/{customerId}")
		public ResponseEntity<?> upadteCustomer(@RequestBody Customer cust,@PathVariable Integer customerId) {
			log.info("update customer in customer controller");
			cust.setCustomerId(customerId);
			Customer response=custService.upadteCustomer(cust);
			return new ResponseEntity<Customer>(response,HttpStatus.OK);
		}
	 

		@GetMapping("/cust/{id}")
		public ResponseEntity<Customer> findByCustomerId(@PathVariable("id") Integer customerId) {
			Customer custDetails= custService.findByCustomerId(customerId);
	        return new ResponseEntity<Customer>(custDetails, new HttpHeaders(), HttpStatus.OK);
		
		}
		
		   @GetMapping("/c/{id}")
		    public Optional<Customer> viewBook(@PathVariable Integer id){
		    	return custRepo.findById(id);
		    } 
		   
		   
//		    
//		@GetMapping("{id}")
//		public ResponseTemplate getCustomerWithTransaction(@PathVariable("id") Integer customerId) {
//			return  custService.getCustomerWithTransaction(customerId);
//	       			
//		}
}
