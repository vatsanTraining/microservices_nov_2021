package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PaymentDTO {

	 int txnId;
	 LocalDate txnDate;
	 double txnAmount;
	 String customerRef;
}
