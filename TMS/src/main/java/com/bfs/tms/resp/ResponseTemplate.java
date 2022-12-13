package com.bfs.tms.resp;

import com.bfs.tms.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
	private TransactionDetails transDetails;
	private Customer customer;
	
}
