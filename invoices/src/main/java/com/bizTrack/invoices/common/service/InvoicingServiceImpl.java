package com.bizTrack.invoices.common.service;

import com.bizTrack.customers.common.service.CustomerService;
import com.bizTrack.invoices.common.entity.Invoices;
import com.bizTrack.invoices.common.repository.InvoicingRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.Optional;

@Service
public class InvoicingServiceImpl implements InvoicingService {

  private InvoicingRepository invoiceRepository;
  private CustomerService customerService;

  static final Logger logger = LoggerFactory.getLogger(InvoicingServiceImpl.class);

  @Autowired
  public InvoicingServiceImpl(InvoicingRepository invoiceRepository, CustomerService customerService){
    this.invoiceRepository = invoiceRepository;
    this.customerService = customerService;
  }

  @Override
  public Invoices getInvoice(Long id) {
    Optional<Invoices> invoice = invoiceRepository.findById(id);
    if(invoice.isPresent()) {
      logger.info("Reading invoices");
      return invoiceRepository.findById(id).get();
    } else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
  }

  @Override
  public List<Invoices> getAllInvoices() {
    return invoiceRepository.findAll();
  }

  @Override
  public Invoices createInvoice(Invoices invoice) {
    if(invoice.getDate()==null){
      invoice.setDate(Calendar.getInstance().getTime());
    }
    invoice.getCustomer().setBalance(invoice.getAmount());
    customerService.updateCustomerBalance(invoice.getCustomer());
    logger.info("Saving invoices");
    invoice = invoiceRepository.save(invoice);
    return invoice;
  }

  @Override
  public Invoices updateInvoice(Invoices invoice) {
    Optional<Invoices> invoice1 = invoiceRepository.findById(invoice.getId());
    if(invoice1.isPresent())
    {
      Invoices newEntity = invoice1.get();
      newEntity.setAmount(invoice.getAmount());
      newEntity.setDate(invoice.getDate());
      newEntity.setPaidStatus(invoice.getPaidStatus());
      logger.info("Updating invoices");
      newEntity = invoiceRepository.save(newEntity);
      return newEntity;
    }else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
  }

  @Override
  public Invoices deleteInvoice(Long invoiceId) {
    Optional<Invoices> customer = invoiceRepository.findById(invoiceId);
    if(customer.isPresent()) {
      logger.info("Deleting invoices");
      invoiceRepository.deleteById(invoiceId);
    } else {
      throw new EntityNotFoundException("No customer record exist for given id");
    }
    return customer.get();
  }
}