package com.bizTrack.invoices;

import com.bizTrack.customers.common.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bizTrack")
public class InvoicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(InvoicesApplication.class, args);
  }

}
