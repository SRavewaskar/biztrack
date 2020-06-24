package com.bizTrack.payments.common.repository;

import com.bizTrack.payments.common.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository <Payments, Long>{

}
