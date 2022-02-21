package com.werkbliq.customerdata;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getCustomer() {
		return customerRepository.findAll();
	}

	public void addNewCustomer(Customer customer) {

		Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
		if (customerOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		customerRepository.save(customer);

	}

	public void deleteCustomer(Long id) {

		boolean exists = customerRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("customer with id" + id + "does not exists");
		}
		customerRepository.deleteById(id);
	}

	@Transactional
	public void updateCustomer(Long id, String name, String email) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("customer with id" + id + " does not exist"));
		
		if(name != null &&
				name.length() > 0 && 
				!Objects.equals(customer.getName(), name)) {
			customer.setName(name);
		}
		
		if (email != null &&
				email.length() > 0 &&
				!Objects.equals(customer.getEmail(), email)) {
			Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
			if (customerOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			customer.setEmail(email);
			
		}
	}

}
