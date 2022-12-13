package com.bfs.transactions.model;

import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Trans_Id")
	private Long transctionId;
	@Column(name = "Vendor_details")
	private String vendorDetails;
	@Column(name = "amount")
	private double amount;
	@Column(name = "ts_date")

	private String transactionDate;
	@Column(name = "Cust_Id")
	private Integer customerId;
	@Column(name = "status")
	private String status;
	@Column(name = "balance_amnt")
	private double balance;

}
