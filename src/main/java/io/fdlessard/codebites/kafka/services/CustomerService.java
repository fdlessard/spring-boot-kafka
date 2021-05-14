package io.fdlessard.codebites.kafka.services;

import io.fdlessard.codebites.kafka.model.Customer;
import io.fdlessard.codebites.kafka.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerService {

  public static final String TOPIC_NAME = "test";
  public static final String GROUP_ID = "group_id";

  private CustomerRepository customerRepository;

  private KafkaTemplate<String, Object> kafkaTemplate;

  public Customer createCustomer(Customer customer) {

    Customer createdCustomer = customerRepository.save(customer);
    kafkaTemplate.send(TOPIC_NAME, customer);
    return createdCustomer;
  }


  @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
  public void consume(Customer customer) {
    logger.info(String.format("Customer Message received -> %s", customer));
  }

}
