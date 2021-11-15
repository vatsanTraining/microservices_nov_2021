package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {


	
}
