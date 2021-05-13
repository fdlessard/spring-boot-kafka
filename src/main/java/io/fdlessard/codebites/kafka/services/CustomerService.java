package io.fdlessard.codebites.kafka.services;

import io.fdlessard.codebites.kafka.model.Customer;
import io.fdlessard.codebites.kafka.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {

  private CustomerRepository customerRepository;

  public Customer createCustomer(Customer customer) {

    Customer createdCustomer = customerRepository.save(customer);

    return createdCustomer;
  }

}
