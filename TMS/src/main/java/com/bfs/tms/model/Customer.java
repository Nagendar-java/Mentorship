package com.bfs.tms.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "Cust_Id")
	private Integer customerId;
	 @Column(name = "Cust_Name")
	private String cname;
	 @Column(name = "User_Name")
	private String username;
	 @Column(name = "Password")
	 private String password;
	 @Column(name = "Cust_Address")
	private String address;
	 @Column(name = "Cust_state")
	private String state;
	 @Column(name = "Cust_country")
	private String country;
	 @Column(name = "Cust_email")
	private String email;
	 @Column(name = "Cust_pan")
	private String panNo;
	 @Column(name = "Cust_no")
	private String contactNo;
//	 @JsonFormat(pattern = "dd-mm-yyyy", shape=Shape.STRING)
	 @Column(name = "Cust_dob")
	private LocalDate dob;
	 @Column(name = "Cust_Acc_type")
	private String accountType;
	

}
