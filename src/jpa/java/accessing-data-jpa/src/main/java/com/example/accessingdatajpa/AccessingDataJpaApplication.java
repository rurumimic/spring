package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            /* fetch all customers
             * Customer[id=1, firstName='Jack', lastName='Bauer']
             * Customer[id=2, firstName='Chloe', lastName='O'Brian']
             * Customer[id=3, firstName='Kim', lastName='Bauer']
             * Customer[id=4, firstName='David', lastName='Palmer']
             * Customer[id=5, firstName='Michelle', lastName='Dessler']
             */
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            /* fetch an individual customer by ID
             * Customer[id=1, firstName='Jack', lastName='Bauer']
             */
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            /* fetch customers by last name
             * Customer[id=1, firstName='Jack', lastName='Bauer']
             * Customer[id=3, firstName='Kim', lastName='Bauer']
             */
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");

            /*
              Customer[id=1, firstName='Jack', lastName='Bauer']
              Customer[id=3, firstName='Kim', lastName='Bauer']
             */
            for (Customer bauer : repository.findByLastName("Bauer")) {
            	log.info(bauer.toString());
            }
            log.info("");
        };
    }

}
