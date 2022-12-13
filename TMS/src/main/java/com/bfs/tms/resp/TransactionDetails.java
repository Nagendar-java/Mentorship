package com.bfs.tms.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetails {
	private Long transctionId;
	private String vendorDetails;
	private double amount;
	 @JsonFormat(pattern = "dd-mm-yyy", shape=Shape.STRING)
	private String transactionDate;
}
