package com.bfs.tms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bfs.tms.config.JwtAuthenticationEntryPoint;
import com.bfs.tms.config.JwtTokenUtil;
import com.bfs.tms.config.WebSecurityConfig;
import com.bfs.tms.model.Customer;
import com.bfs.tms.repository.CustomerRepository;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerServiceImpementation service;
	@MockBean
	private CustomerRepository repository;

	@MockBean
	private JwtUserDetailsService jservice;

	@MockBean
	JwtTokenUtil jwtTokenUtil;

	@MockBean
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@MockBean
	private AuthenticationManager authenticationManager;
	@Autowired
	private WebSecurityConfig webSecurityConfig;

	@MockBean
	private PasswordEncoder bcryptEncoder;


	@SuppressWarnings("deprecation")
	@BeforeEach
	public void Setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	Customer cdetails12= new Customer(178,"nagendar", "nagendar", "12345","TSS","ts","india","ng@gmail.com","BMAPA4423J","9550143657", LocalDate.now(),"patym" );

	@Test
	public void saveCustomer() {
		
	Customer cdetails= new Customer(178,"nagendar", "nagendar", "12345","TSS","ts","india","ng@gmail.com","BMAPA4423J","9550143657", LocalDate.now(),"patym" );
	//Customer cdetails1= new Customer(178,"nagendar", "nagendar", "12345","TSS","ts","india","ng@gmail.com","BMAPA4423J","9550143657", LocalDate.now(),"patym" );
		//when(repository.save(cdetails)).thenReturn(cdetails);
		//assertNotNull(cdetails);
		//assertEquals(cdetails, service.registerUser(cdetails));
	service.registerUser(cdetails);
	assertNotNull(cdetails);
	//verify(repository, times(1)).save(cdetails);
	
	}
	

	@Test
	void testExistsByUsername() {
		Customer cdetails= new Customer(178,"nagendar", "nagendar", "12345","TSS","ts","india","ng@gmail.com","BMAPA4423J","9550143657", LocalDate.now(),"patym" );

		when(repository.existsByUsername(cdetails.getUsername())).thenReturn(true);
		Boolean actual = repository.existsByUsername(cdetails.getUsername());

		assertEquals(true, actual);
		verify(repository, times(1)).existsByUsername(cdetails.getUsername());

	}
	
	@Test
	void updateMovie() {

		when(repository.findByCustomerId((int) anyLong())).thenReturn(cdetails12);
		
		when(repository.save(any(Customer.class))).thenReturn(cdetails12);
		cdetails12.setCname("Fantacy");
		Customer exisitingMovie = service.upadteCustomer(cdetails12);
		
		assertNotNull(exisitingMovie);
		assertEquals("Fantacy", cdetails12.getCname());
	}
}
