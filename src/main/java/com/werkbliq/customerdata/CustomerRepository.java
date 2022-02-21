package com.werkbliq.customerdata;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("SELECT s FROM Customer s WHERE s.email = ?1")
	Optional<Customer> findCustomerByEmail(String email);
	

}
