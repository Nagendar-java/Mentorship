package com.bfs.transactions;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bfs.transactions.model.TransactionDetails;
import com.bfs.transactions.repository.TsRepository;



//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest

public class TsRepositoryTest {
	
	  @Autowired

	private TsRepository testRepo;
	  
	  private TransactionDetails avatarMovie;
		private TransactionDetails titanicMovie;
	 @BeforeEach
		void init() {
			avatarMovie = new TransactionDetails();
			avatarMovie.setTransctionId(12L);
			avatarMovie.setVendorDetails("Gapy");
			avatarMovie.setAmount(234.89);
			avatarMovie.setTransactionDate("2026-10-28");
			  avatarMovie.setBalance(234);
			  avatarMovie.setStatus("credit");
			  avatarMovie.setCustomerId(1);
			  
			
			titanicMovie = new TransactionDetails();
			titanicMovie = new TransactionDetails();
			titanicMovie.setTransctionId(12L);
			titanicMovie.setVendorDetails("Gapy");
			titanicMovie.setAmount(234.89);
			titanicMovie.setTransactionDate("2026-10-28");
			titanicMovie.setBalance(234);
			titanicMovie.setStatus("credit");
			titanicMovie.setCustomerId(1);
		}
	 
	
	@Test
	@DisplayName("It should save the Transaction to the database")
	void save() {
		TransactionDetails newMovie = testRepo.save(avatarMovie);
		assertNotNull(newMovie);
		assertThat(newMovie.getTransctionId()).isNotEqualTo(null);
	}
	
	@Test
	@DisplayName("It should return the Transaction list ")
	void getTransactionByCustomerId() {
		
		testRepo.save(avatarMovie);
		testRepo.save(titanicMovie);
		
		List<TransactionDetails> list = testRepo.getTransactionByCustomerId(1);
		
		assertNotNull(list);
		assertThat(list.size()).isEqualTo(2);
	}

}
