package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;
import java.util.*;

import javax.transaction.Transactional;
@Repository
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, String> {


	// dsl findByxxx => pattern where xxx stands for Property Name
	List<RestaurantInfo> findByLocation(String srchLocation);
	
	
	// dsl with custom query - and the query is a native sql query
	@Query(value = "select * from restaurant_nov2021 where restaurantname=:srchString",nativeQuery = true)
	List<RestaurantInfo> findByName(@Param("srchString") String srchName);
	
	// dsl with custom query and the query is a jpql and since its update syntax using 
	// @Modifying and @Transactionl
	
	@Query(value = "update RestaurantInfo set mobilenumber=:latestNumber where id=:id")
	@Modifying
	@Transactional
	public int updatePhoneNumber(@Param("latestNumber") long latestPhoneNumber, @Param("id") String id);
	
}
