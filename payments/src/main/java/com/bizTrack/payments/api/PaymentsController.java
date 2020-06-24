package com.bizTrack.payments.api;

import com.bizTrack.customers.common.entity.Customer;
import com.bizTrack.payments.common.entity.Payments;
import com.bizTrack.payments.common.service.PaymentsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PaymentsController {

  private PaymentsService paymentsService;

  @Autowired
  public PaymentsController(PaymentsService paymentsService){
    this.paymentsService = paymentsService;
  }

  @RequestMapping(method = RequestMethod.GET , value = "/{id}")
  public Payments getPayment(@PathVariable  Long id) {
    return paymentsService.getPayment(id);
  }

  @RequestMapping(method = RequestMethod.GET , value = "/getAllInvoices")
  public List<Payments> getAllPayments(@PathVariable Customer customer) {
    return paymentsService.getAllPayments(customer);
  }

  @RequestMapping(value = "/makePayment", method = RequestMethod.POST)
  public void makePayment(@PathVariable Payments payments) {
    paymentsService.makePayment(payments);
  }

  @RequestMapping(value = "/updatePayment/{id}", method = RequestMethod.POST)
  public void updatePayment(@PathVariable Long id) {
    paymentsService.updatePayment(id);
  }

  @RequestMapping(value = "/deletePayment/{id}", method = RequestMethod.POST)
  public void deletePayment(@PathVariable Long id) {
    paymentsService.deletePayment(id);
  }

}
