package org.dougllas.mymoney.repository;

import org.dougllas.mymoney.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
