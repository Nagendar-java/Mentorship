package com.bfs.transactions.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfs.transactions.model.TransactionDetails;
import com.bfs.transactions.repository.TsRepository;

@Service
public class TsService {

	@Autowired 
	private TsRepository tsrepo;
	
	public TransactionDetails saveTransactions(TransactionDetails td)
	{
		return tsrepo.save(td);
		
	}

//	public TransactionDetails findByTransctionId(Long transctionId) {
//		// TODO Auto-generated method stub
//		return tsrepo.findByTransctionId(transctionId);
//	}

	public List<TransactionDetails> getTransactionByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		List<TransactionDetails> tlist= tsrepo.getTransactionByCustomerId(customerId);
		List<TransactionDetails> asendingOrder = tlist.stream()
			.sorted(Comparator.comparing(TransactionDetails::getTransactionDate)).collect(Collectors.toList());
		return asendingOrder;
	
				
		
	}


//	public List<TransactionDetails> getTransactionByCustomerId(Integer customerId) {
//		// TODO Auto-generated method stub
//		List<TransactionDetails> tlist= tsrepo.getTransactionByCustomerId(customerId);
//		List<TransactionDetails> asendingOrder = tlist.stream()
//				.sorted(Comparator.comparing(TransactionDetails::getTransactionDate)).collect(Collectors.toList());
//		return tlist;
//				
//		
//	}

	
}
