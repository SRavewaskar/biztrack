package com.bizTrack.invoices.api;

import com.bizTrack.invoices.common.entity.Invoices;
import com.bizTrack.invoices.common.service.InvoicingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoicingController {
  private InvoicingService invoicingService;

  @Autowired
  public InvoicingController(InvoicingService invoicingService){
    this.invoicingService = invoicingService;
  }

  @GetMapping(value = "/{id}")
  public Invoices getInvoice(@PathVariable Long id) {
    return invoicingService.getInvoice(id);
  }

  @GetMapping(value = "/getAllInvoices")
  public List<Invoices> getAllInvoices() {
    return invoicingService.getAllInvoices();
  }

  @PostMapping(value = "/createInvoice")
  public void createInvoice(@PathVariable Invoices invoice) {
    invoicingService.createInvoice(invoice);
  }

  @PostMapping(value = "/updateInvoice/{id}")
  public void updateInvoice(@PathVariable Invoices invoice) {
    invoicingService.updateInvoice(invoice);
  }

  @DeleteMapping(value = "/deleteInvoice/{id}")
  public void deleteInvoice(@PathVariable Long id) {
    invoicingService.deleteInvoice(id);
  }
}
