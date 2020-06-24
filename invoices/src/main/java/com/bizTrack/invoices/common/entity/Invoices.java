package com.bizTrack.invoices.common.entity;

import com.bizTrack.customers.common.entity.Customer;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Invoices")
public class Invoices {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @ManyToOne
  @PrimaryKeyJoinColumn
  @JoinColumn(name="customer_id",referencedColumnName = "id")
  private Customer customer;

  @Column(name = "Amount", nullable = false)
  private double amount;

  @Column(name = "Balance")
  private double openBalance;

  @Column(name = "Date")
  private Date date;

  @Column(name = "Payment_Status", nullable = false)
  private PaidStatus paidStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Double getOpenBalance() {
    return openBalance;
  }

  public void setOpenBalance(Double openBalance) {
    this.openBalance = openBalance;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public PaidStatus getPaidStatus() {
    return paidStatus;
  }

  public void setPaidStatus(PaidStatus paidStatus) {
    this.paidStatus = paidStatus;
  }
}
