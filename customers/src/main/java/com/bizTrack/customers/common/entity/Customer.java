package com.bizTrack.customers.common.entity;

import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {

  @Id
  @GeneratedValue
  @Column(name="id")
  private Long id;

  @Column(name="firstName")
  private String firstName;

  @Column(name="lastName")
  private String lastName;

  @Column(name="balance")
  private double balance;

  public double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
