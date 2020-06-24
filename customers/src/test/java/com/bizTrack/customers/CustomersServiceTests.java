package com.bizTrack.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bizTrack.customers.common.entity.Customer;
import com.bizTrack.customers.common.repository.CustomerRepository;
import com.bizTrack.customers.common.service.CustomerService;
import com.bizTrack.customers.common.service.CustomerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomersServiceTests {

  private CustomerService customerService;
  private CustomerRepository customerRepository;

  @BeforeEach
  void setUp(){
    customerService = new CustomerServiceImpl(Mockito.mock(CustomerRepository.class));
  }

  @Test
  public void getCustomerTest(){
    //Arrange
    Customer customer = createCustomer();
    List<Customer> customerList = new ArrayList<>();
    customerList.add(customer);
    Mockito.when(customerRepository.findAll()).thenReturn(customerList);

    //Assert
    assertEquals(customerList.size(), customerRepository.count());
    assertEquals(customerList.get(0), customerRepository.getOne(customer.getId()));

  }

  private Customer createCustomer() {
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setFirstName("Cust_fn");
    customer.setLastName("cust_ln");
    return customer;
  }

  @Test
  void contextLoads() {
  }

}
