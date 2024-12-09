package com.travel.agency.base.repository;

import java.util.Optional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.agency.base.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findByEmail(String email);

}
