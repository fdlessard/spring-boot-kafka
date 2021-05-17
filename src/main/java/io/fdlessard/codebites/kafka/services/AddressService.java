package io.fdlessard.codebites.kafka.services;

import io.fdlessard.codebites.kafka.model.Address;
import io.fdlessard.codebites.kafka.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AddressService {

  public static final String TOPIC_NAME = "test";

  private AddressRepository addressRepository;

  private KafkaTemplate<String, Object> kafkaTemplate;

  public Address createAddress(Address address) {

    Address createdAddress = addressRepository.save(address);
    kafkaTemplate.send(TOPIC_NAME, address);
    return createdAddress;
  }

}
