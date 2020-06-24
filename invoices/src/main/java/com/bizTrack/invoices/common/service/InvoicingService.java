package com.bizTrack.invoices.common.service;

import com.bizTrack.invoices.common.entity.Invoices;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface InvoicingService {
  public Invoices createInvoice(Invoices invoice);

  public Invoices updateInvoice(Invoices invoice);

  public Invoices getInvoice(Long id);

  public List<Invoices> getAllInvoices();

  public Invoices deleteInvoice(Long id);

}
