package com.werkbliq.customerdata;

	import java.util.List;

	import org.springframework.boot.CommandLineRunner;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	@Configuration
	public class CustomerConfig {
		
		@Bean
		CommandLineRunner commandLineRunner(CustomerRepository repository) {
			return args -> {
					
						repository.saveAll(
						List.of()
						);
				
			};
		}


}
