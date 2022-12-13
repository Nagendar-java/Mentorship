package com.bfs.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bfs.transactions.model.TransactionDetails;
import com.bfs.transactions.repository.TsRepository;
import com.bfs.transactions.service.TsService;
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TsServiceTest {
	@Autowired 
	private TsService service;
	@MockBean 
	private TsRepository repository;
	
	@Test
	public void saveTransactions() {
		TransactionDetails tdetails= new TransactionDetails(12L,"patym",234.89,"2026-10-28",1,"credit", 875.09 );
		when(repository.save(tdetails)).thenReturn(tdetails);
		assertEquals(tdetails, service.saveTransactions(tdetails));
	}
	
	@Test
	public void getTransactionByCustomerId() {
		int address = 1;
		when(repository.getTransactionByCustomerId(address))
				.thenReturn(Stream.of(new TransactionDetails(12L,"patym",234.89,"2026-10-28",1,"credit", 875.09 )).collect(Collectors.toList()));
		assertEquals(1, service.getTransactionByCustomerId(address).size());
	}
}
