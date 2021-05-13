package io.fdlessard.codebites.kafka;

import io.fdlessard.codebites.kafka.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@RepositoryRestController
public class CustomerController {

  private CustomerService customerService;

  @PostMapping(value = "/customers" )
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Customer post(@RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }

}
