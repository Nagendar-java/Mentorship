package com.bfs.tms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.bfs.tms.config.JwtAuthenticationEntryPoint;
import com.bfs.tms.config.JwtTokenUtil;
import com.bfs.tms.config.WebSecurityConfig;
import com.bfs.tms.model.Customer;
import com.bfs.tms.service.CustomerService;
import com.bfs.tms.service.CustomerServiceImpementation;
import com.bfs.tms.service.JwtUserDetailsService;
//@ExtendWith(SpringExtension.class)

//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@SpringBootTest(classes = TmsApplication.class)
@AutoConfigureMockMvc(addFilters = false)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

	private Customer avatarMovie;
	private Customer titanicMovie;
	
	@Autowired
	private CustomerRepository testRepo;
	@MockBean
	private CustomerServiceImpementation service;

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
		
		@Test
		@DisplayName("It should save the Customer to the database")
		void save() {
			Customer newMovie = testRepo.save(avatarMovie);
			assertNotNull(newMovie);
			assertThat(newMovie.getCustomerId()).isNotEqualTo(null);
		}
}
