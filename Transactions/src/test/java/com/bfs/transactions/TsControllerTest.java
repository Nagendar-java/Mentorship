package com.bfs.transactions;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bfs.transactions.controller.TsController;
import com.bfs.transactions.model.TransactionDetails;
import com.bfs.transactions.service.TsService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
@WebMvcTest(TsController.class)
//@JsonSerialize(using = LocalDateTimeSerializer.class)
public class TsControllerTest {

	@Autowired
  private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	 @MockBean
	 private TsService service;
	 

	 private TransactionDetails avatarMovie;
		private TransactionDetails titanicMovie;
	 @BeforeEach
		void init() {
			avatarMovie = new TransactionDetails();
			avatarMovie.setTransctionId(12L);
			avatarMovie.setVendorDetails("patym");
			avatarMovie.setAmount(234.89);
			avatarMovie.setTransactionDate("2026-10-28");
			  avatarMovie.setBalance(234);
			  avatarMovie.setStatus("credit");
			  avatarMovie.setCustomerId(1);
			  
			
			titanicMovie = new TransactionDetails();
			titanicMovie = new TransactionDetails();
			titanicMovie.setTransctionId(12L);
			titanicMovie.setVendorDetails("patym");
			titanicMovie.setAmount(234.89);
			titanicMovie.setTransactionDate("2026-10-28");
			titanicMovie.setBalance(234);
			titanicMovie.setStatus("credit");
			titanicMovie.setCustomerId(1);
		}
	 
	  @Test
	   // @WithMockUser(username = "user1", password = "pwd", roles = "USER")
	    public void save_customer_success() throws Exception {
		
		  when(service.saveTransactions(any(TransactionDetails.class))).thenReturn(avatarMovie);
			
			this.mockMvc.perform(post("/transactions/save")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(avatarMovie)))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.vendorDetails", is(avatarMovie.getVendorDetails())))
			//.andExpect(jsonPath("$.transctionId", is(avatarMovie.getTransctionId().longValue())))
			.andExpect(jsonPath("$.transactionDate", is(avatarMovie.getTransactionDate())))
			.andExpect(jsonPath("$.amount", is(avatarMovie.getAmount())))
			.andExpect(jsonPath("$.balance", is(avatarMovie.getBalance())))
			.andExpect(jsonPath("$.status", is(avatarMovie.getStatus())))
			.andExpect(jsonPath("$.customerId", is(avatarMovie.getCustomerId())));

}
	  
		@Test
		void shouldFetchAllMovies() throws Exception {
			
			List<TransactionDetails> list = new ArrayList<>();
			list.add(avatarMovie);
			list.add(titanicMovie);
			
			when(service.getTransactionByCustomerId(anyInt())).thenReturn(list);
			
			this.mockMvc.perform(get("/transactions/custid/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(list.size())));
		}
}
