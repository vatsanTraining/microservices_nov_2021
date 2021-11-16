package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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


@Entity
@Table(name = "payment_nov_2021")
public class Payment {

	 @Id
	 @Column(name = "txnid")
	 int txnId;
	 @Column(name = "txndate")
	 @DateTimeFormat(iso = ISO.DATE)
	 LocalDate txnDate;
	 @Column(name = "txnamount")
	 double txnAmount;
	 @Column(name = "customerref")
	 String customerRef;
}
