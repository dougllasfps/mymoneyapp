package org.dougllas.mymoney.repository;

import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.Debit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebitRepository extends JpaRepository<Debit, Integer> {
    List<Debit> findByBillingCycle(BillingCycle billingCycle);
}