package org.dougllas.mymoney.repository;

import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
    List<Credit> findByBillingCycle(BillingCycle billingCycle);
}
