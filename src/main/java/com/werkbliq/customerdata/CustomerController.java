package com.werkbliq.customerdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/detail")
	public List<Customer> getCustomer(){
		
		return customerService.getCustomer();
	}
	
	@PostMapping("/detail/detail1")
	public void registerNewCustomer(@RequestBody Customer customer) {
		customerService.addNewCustomer(customer);
	}
	
	@DeleteMapping("/detail/id")
	public void deleteCustomer(Long id) {
		customerService.deleteCustomer(id);
		
	}
	
	@PutMapping("/detail/id")
	public void updateCustomer(Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		customerService.updateCustomer(id, name, email);
		
	}
}
