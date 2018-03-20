package org.dougllas.mymoney.repository;

import org.dougllas.mymoney.model.BillingCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingCycleRepository extends JpaRepository<BillingCycle, Integer>{

    @Query(" from BillingCycle where user.id = :id ")
    List<BillingCycle> findAllByUserId(@Param("id") Integer userId);
}
