package com.example.crudwithvaadin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByLastNameStartsWithIgnoreCase(String lastname);
}