package com.bfs.tms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bfs.tms.model.Customer;
import com.bfs.tms.model.UserDTO;
import com.bfs.tms.repository.CustomerRepository;
import com.bfs.tms.resp.ResponseTemplate;
import com.bfs.tms.resp.TransactionDetails;

@Service
public class CustomerServiceImpementation implements CustomerService{
	@Autowired CustomerRepository customerepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Customer registerUser(Customer u) {
		// TODO Auto-generated method stub
		if(customerepo.findByUsername(u.getUsername())!=null) throw new RuntimeException("User already exists");
		
		Customer newUser = new Customer();
		newUser.setUsername(u.getUsername());
		//newUser.setPassword(user.getPassword());
		newUser.setPassword(bcryptEncoder.encode(u.getPassword()));
		newUser.setCname(u.getCname());
		newUser.setAddress(u.getAddress());
		newUser.setState(u.getState());
		newUser.setCountry(u.getCountry());
		newUser.setEmail(u.getEmail());
		newUser.setPanNo(u.getPanNo());
		newUser.setContactNo(u.getContactNo());
		newUser.setDob(u.getDob());
		newUser.setAccountType(u.getAccountType());
		return customerepo.save(newUser);
		
	}


	public Customer save(UserDTO user) {
		Customer newUser = new Customer();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return customerepo.save(newUser);
	}
	@Override
	public Customer findByUsername(String username) {
		return customerepo.findByUsername(username);
	}


	@Override
	public Customer upadteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
		  Optional<Customer> employee = customerepo.findById(cust.getCustomerId());
		  if(employee.isPresent())
	        {
	        	Customer newEntity = employee.get();
	            newEntity.setUsername(cust.getUsername());
	            newEntity.setCname(cust.getCname());
	            newEntity.setEmail(cust.getEmail());
	            newEntity.setPassword(bcryptEncoder.encode(cust.getPassword()));
	            newEntity.setAddress(cust.getAddress());
	            newEntity.setState(cust.getState());
	            newEntity.setCountry(cust.getCountry());
	            newEntity.setPanNo(cust.getPanNo());
	            newEntity.setContactNo(cust.getContactNo());
	            newEntity.setDob(cust.getDob());
	            newEntity.setAccountType(cust.getAccountType());
	 
	 
	            newEntity = customerepo.save(newEntity);
	        }
		return cust;
	           
		  
//		Customer cid=customerepo.findByCustomerId(cust.getCustomerId());
//		Responses params=new Responses();
//		if(cid.getCustomerId().equals(cust.getCustomerId())) {
//			customerepo.save(cust);
//		params.setErrorcode("Ok");
//		params.setErrormessage("Updated Sucessfully!!");
//		}else {
//			params.setErrorcode("Ok");
//			params.setErrormessage("Failed to update!!");
//		}
//		return params;
	}

//
//	@Override
//	public ResponseTemplate getCustomerWithTransaction(Integer customerId) {
//		// TODO Auto-generated method stub
//		ResponseTemplate rs= new ResponseTemplate();
//		Customer cu=customerepo.findByCustomerId(customerId);
//		TransactionDetails ts=restTemplate.getForObject("http://localhost:7368/transactions/" + cu.getTransctionId(), TransactionDetails.class);
//		rs.setCustomer(cu);
//		rs.setTransDetails(ts);
//		return rs;
//	}
/*	public ResponseTemplateVO getUserWithDepartment(Long userId)
	{
		ResponseTemplateVO vo=new ResponseTemplateVO();
		User user= userRepository.findByUserId(userId);
		Department department= restTemplate.getForObject("http://localhost:8013/departments/" + user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
		
	}
*/
//	@Override
//	public Customer findByCustomerId(Integer customerId) {
//		// TODO Auto-generated method stub
//		return customerepo.findByCustomerId(customerId);
//	}


	@Override
	public Customer findByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return customerepo.findByCustomerId(customerId);
	}



	
	
	
//	 public ResponseEntity<?> bookUpdate(Book book, Integer authorId, Integer bookId) {
//	    	log.info("###BookServiceImplementation - BookUpdate###");
//	        return new ResponseEntity(this.bookrepository.save(book), HttpStatus.OK);
//	    }
	}















//@Override
//public Responses upadteCustomer(Customer cust) {
//	// TODO Auto-generated method stub
//	Customer cid=customerepo.findByCustomerId(cust.getCustomerId());
//	Responses params=new Responses();
//	if(cid.getCustomerId().equals(cust.getCustomerId())) {
//		customerepo.save(cust);
//	params.setErrorcode("Ok");
//	params.setErrormessage("Updated Sucessfully!!");
//	}else {
//		params.setErrorcode("Ok");
//		params.setErrormessage("Failed to update!!");
//	}
//	return params;
//}