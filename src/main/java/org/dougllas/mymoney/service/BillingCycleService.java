package org.dougllas.mymoney.service;

import org.dougllas.mymoney.model.BillingCycle;

import java.util.List;
import java.util.Optional;

/**
 * Criado por dougllas.sousa em 28/02/2018.
 */
public interface BillingCycleService {

    BillingCycle save(BillingCycle billingCycle);

    void delete(Integer id);

    List<BillingCycle> findAll(boolean fetchLists, Integer userId);

    Optional<BillingCycle> findById(Integer id, boolean fetchLists);

}