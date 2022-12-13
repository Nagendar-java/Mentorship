package com.bfs.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfs.transactions.model.TransactionDetails;
import com.bfs.transactions.service.TsService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class TsController {

	@Autowired TsService tsService;
//	@GetMapping("/ts/hi")
//	public String test() {
//		return "Hi Welcome";
//	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveTransactions(@RequestBody TransactionDetails td) {
		TransactionDetails tdSave=tsService.saveTransactions(td);
		return new ResponseEntity<>(tdSave,HttpStatus.CREATED);
}
	//get all the tranactions
//	@GetMapping("/transactions/custid")
//	public List<TransactionDetails> getTransactionByCustomerId(@PathVariable Integer customerId){
//		List<TransactionDetails> td= tsService.getTransactionByCustomerId(customerId);
//		return td;
//	}
		@GetMapping(value="/custid/{id}")
		public ResponseEntity<List<TransactionDetails>> getTransactionByCustomerId(@PathVariable("id") Integer customerId) {
			List<TransactionDetails> list=tsService.getTransactionByCustomerId(customerId);
			
			return new ResponseEntity<List<TransactionDetails>>(list,HttpStatus.OK);
		}	
		//return employeeRepository.findAll();
		
	
//	@GetMapping("{id}")
//	public ResponseEntity<TransactionDetails> findByTransctionId(@PathVariable("id") Long transctionId) {
//		TransactionDetails tsDetails= tsService.findByTransctionId(transctionId);
//        return new ResponseEntity<TransactionDetails>(tsDetails, new HttpHeaders(), HttpStatus.OK);
//
//		
//	}
}
