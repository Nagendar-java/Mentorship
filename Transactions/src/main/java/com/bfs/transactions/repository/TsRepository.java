package com.bfs.transactions.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bfs.transactions.model.TransactionDetails;

@Repository
public interface TsRepository extends JpaRepository<TransactionDetails, Long> {

//	TransactionDetails findByTransctionId(Long transctionId);

	List<TransactionDetails> getTransactionByCustomerId(Integer customerId);



}
