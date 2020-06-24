package com.bizTrack.customers.common.service;

import com.bizTrack.customers.common.entity.Customer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

  public Customer getCustomer(Long id);

  public Customer createCustomer(Customer customer);

  public List<Customer> getAllCustomers();

  public Customer updateCustomer(Customer customer);

  public Customer deleteCustomer(Long id);

  public Customer updateCustomerBalance(Customer customer);
}
