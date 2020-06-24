package com.bizTrack.customers.api;

import com.bizTrack.customers.common.service.CustomerService;
import com.bizTrack.customers.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
  private CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService){
    this.customerService = customerService;
  }

  @GetMapping(value = "/customers/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
    Customer customer = customerService.getCustomer(id);
    return new ResponseEntity<>(customer, new HttpHeaders(), HttpStatus.OK);
  }

  @PostMapping(value = "/createCustomer")
  public void createCustomer(Customer customer) {
    customerService.createCustomer(customer);
  }

  @PutMapping(value = "/updateCustomers/{id}")
  public void updateCustomer(Customer customer) {
    customerService.updateCustomer(customer);
  }

  @DeleteMapping(value = "/deleteCustomers/{id}")
  public void deleteCustomer(@PathVariable("id") Long id) {
    customerService.deleteCustomer(id);
  }
}
