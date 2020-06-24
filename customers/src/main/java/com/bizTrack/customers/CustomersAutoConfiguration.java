package com.bizTrack.customers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(CustomersApplication.class)
public class CustomersAutoConfiguration {

}
