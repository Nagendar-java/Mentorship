package com.bfs.tms.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.security.test.context.support.WithMockUser;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bfs.tms.config.JwtAuthenticationEntryPoint;
import com.bfs.tms.config.JwtTokenUtil;
import com.bfs.tms.config.WebSecurityConfig;
import com.bfs.tms.model.Customer;
import com.bfs.tms.repository.CustomerRepository;
import com.bfs.tms.service.CustomerService;
import com.bfs.tms.service.CustomerServiceImpementation;
import com.bfs.tms.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;


@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(CustomerController.class)
//@SpringBootTest
public class CustomerControllerTest {
	
	@Autowired
	  private MockMvc mockMvc;
		@Autowired
		private ObjectMapper objectMapper;
	
		@MockBean
		private CustomerRepository repository;
		
		@MockBean
		private AuthenticationManager authenticationManager;

	@MockBean 
	private CustomerService custService;
	
	@MockBean
	private JwtUserDetailsService jservice;
	
	@MockBean
	JwtTokenUtil jwtTokenUtil;
	
	@MockBean
private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
@Autowired
private WebSecurityConfig webSecurityConfig;

@MockBean
private PasswordEncoder bcryptEncoder;


//		@MockBean
//		private AuthenticationManager authenticationManager;
	
//	@MockBean
//	private JwtUserDetailsService jservice;
//	@MockBean
//	private JwtTokenUtil JTokeFilter;
	//@MockBean
//	private JwtAuthenticationEntryPoint jaentryPoint;
//	@MockBean
//		private WebSecurityConfig webSecConfig;
//	
//		@MockBean
//		private JwtTokenUtil jwtTokenUtil;
//
//		@MockBean
//		private SecurityFilterChain securityFilterChain;
		
		 private Customer avatarMovie;
			private Customer titanicMovie;
			
			@BeforeEach
			void init() {
				titanicMovie = new Customer();
				titanicMovie.setCustomerId(1);
				titanicMovie.setAddress("patym");
				titanicMovie.setAccountType("patym");
				titanicMovie.setDob(LocalDate.now());
				titanicMovie.setCname("nage");
				titanicMovie.setCountry("india");
				titanicMovie.setState("ts");
				titanicMovie.setUsername("nageee");
				titanicMovie.setEmail("ng@gmail.com");
				titanicMovie.setPanNo("BMAPA4423J");
				titanicMovie.setPassword("12345");
				titanicMovie.setContactNo("9550143657");

				avatarMovie = new Customer();
				avatarMovie.setCustomerId(1);
				avatarMovie.setAddress("patym");
				avatarMovie.setAccountType("patym");
				avatarMovie.setDob(LocalDate.now());
				avatarMovie.setCname("nage");
				avatarMovie.setCountry("india");
				avatarMovie.setState("ts");
				avatarMovie.setUsername("nageee");
				avatarMovie.setEmail("ng@gmail.com");
				avatarMovie.setPanNo("BMAPA4423J");
				avatarMovie.setPassword("12345");
				avatarMovie.setContactNo("9550143657");
			}
			
//			@Test
//			@WithMockUser(username = "nagendar", password = "12345" )
//			public void mytest1() throws Exception {
//			    mockMvc.perform(get("/customer/register"))
//			        .andExpect(status().isOk());
//			}
			  @Test
			   // @WithMockUser(username = "user1", password = "pwd", roles = "USER")
			    public void save_customer_success() throws Exception {
				
				  when(custService.registerUser(any(Customer.class))).thenReturn(avatarMovie);
					
					this.mockMvc.perform(post("/customer/register")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(avatarMovie)))
					.andExpect(status().isCreated())
					.andExpect(jsonPath("$.cname", is(avatarMovie.getCname())))
					.andExpect(jsonPath("$.username", is(avatarMovie.getUsername())))
					.andExpect(jsonPath("$.password", is(avatarMovie.getPassword())))
					.andExpect(jsonPath("$.address", is(avatarMovie.getAddress())))
					.andExpect(jsonPath("$.state", is(avatarMovie.getState())))
					.andExpect(jsonPath("$.country", is(avatarMovie.getCountry())))
					.andExpect(jsonPath("$.email", is(avatarMovie.getEmail())))
					.andExpect(jsonPath("$.panNo", is(avatarMovie.getPanNo())))
					.andExpect(jsonPath("$.contactNo", is(avatarMovie.getContactNo())))
					.andExpect(jsonPath("$.dob", is(avatarMovie.getDob().toString())))
					.andExpect(jsonPath("$.accountType", is(avatarMovie.getAccountType())));
					

}
			  
}
