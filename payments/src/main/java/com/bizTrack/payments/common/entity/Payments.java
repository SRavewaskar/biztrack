package com.bizTrack.payments.common.entity;

import com.bizTrack.invoices.common.entity.PaidStatus;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payments {
  private Long amount;

  @Column(name = "Date")
  private Date date;

  @Column(name="id")
  private Long id;

  @Column(name = "Customer_id")
  private Long customer_id;

}
