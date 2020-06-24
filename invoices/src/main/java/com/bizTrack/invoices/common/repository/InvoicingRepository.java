package com.bizTrack.invoices.common.repository;

import com.bizTrack.invoices.common.entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicingRepository extends JpaRepository<Invoices, Long> {

}
