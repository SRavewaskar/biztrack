package com.bizTrack.payments.common.service;

import com.bizTrack.customers.common.entity.Customer;
import com.bizTrack.payments.common.entity.Payments;
import com.bizTrack.payments.common.repository.PaymentsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentsServiceImpl implements PaymentsService {

  private PaymentsRepository paymentsRepository;

  @Autowired
  public PaymentsServiceImpl(PaymentsRepository paymentsRepository){
    this.paymentsRepository = paymentsRepository;
  }

  @Override
  public void makePayment(Payments payments) {
    paymentsRepository.save(payments);
  }

  @Override
  public void deletePayment(Long id) {
    paymentsRepository.delete(getPayment(id));
  }

  @Override
  public void updatePayment(Payments payments) {
    paymentsRepository.save(payments);
  }

  @Override
  public Payments getPayment(Long id) {
    return paymentsRepository.getOne(id);
  }

  @Override
  public List<Payments> getAllPayments(Customer customer) {
    return paymentsRepository.findAll();
  }
}
