package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;
import java.util.*;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	
	Payment findByCustomerRef(String srchName);

	
}
