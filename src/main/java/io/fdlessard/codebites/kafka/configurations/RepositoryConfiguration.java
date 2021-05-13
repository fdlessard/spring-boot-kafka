package io.fdlessard.codebites.kafka.configurations;

import io.fdlessard.codebites.kafka.model.AddressEventHandler;
import io.fdlessard.codebites.kafka.model.CustomerEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    CustomerEventHandler customerEventHandler() {
        return new CustomerEventHandler();
    }

    @Bean
    AddressEventHandler addressEventHandler() {
        return new AddressEventHandler();
    }
}
