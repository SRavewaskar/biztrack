package com.bizTrack.payments.common.service;

import com.bizTrack.customers.common.entity.Customer;
import com.bizTrack.payments.common.entity.Payments;
import java.util.List;

public interface PaymentsService {

  public void makePayment(Payments payments);

  public void deletePayment(Long id);

  public void updatePayment(Payments payments);

  public Payments getPayment(Long id);

  public List<Payments> getAllPayments(Customer customer);


}
