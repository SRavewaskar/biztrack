package com.bizTrack.customers.common.service;

import com.bizTrack.customers.common.entity.Customer;
import com.bizTrack.customers.common.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;
  static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  @Autowired
  public CustomerServiceImpl (CustomerRepository customersRepository){
    this.customerRepository = customersRepository;
  }

  @Override
  public Customer getCustomer(Long id) {
    Optional<Customer> customer = customerRepository.findById(id);
    if(customer.isPresent()) {
      logger.info("Reading customers");
      return customerRepository.findById(id).get();
    } else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
  }

  @Override
  public Customer createCustomer(Customer customer) {
    logger.info("Saving customers");
    customer = customerRepository.save(customer);
    logger.info("Successfully saved customers");
    return customer;
  }

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    Optional<Customer> customer1 = customerRepository.findById(customer.getId());
    if(customer1.isPresent())
    {
      Customer newEntity = customer1.get();
      newEntity.setFirstName(customer.getFirstName());
      newEntity.setLastName(customer.getLastName());
      logger.info("Updating customers");
      newEntity = customerRepository.save(newEntity);
      logger.info("Successfully updated customers");
      return newEntity;
    }else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
  }

  @Override
  public Customer updateCustomerBalance(Customer customer) {
    Optional<Customer> customer1 = customerRepository.findById(customer.getId());
    if(customer1.isPresent())
    {
      Customer newEntity = customer1.get();
      newEntity.setFirstName(customer.getFirstName());
      newEntity.setLastName(customer.getLastName());
      newEntity.setBalance(customer.getBalance());
      logger.info("Updating customers");
      newEntity = customerRepository.save(newEntity);
      logger.info("Successfully updated customers");
      return newEntity;
    }else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
  }

  @Override
  public Customer deleteCustomer(Long customerId) {
    Optional<Customer> customer = customerRepository.findById(customerId);
    if(customer.isPresent()) {
      logger.info("Deleting customers");
      customerRepository.deleteById(customerId);
      logger.info("Successfully deleted customers");
    } else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
    return customer.get();
  }
}