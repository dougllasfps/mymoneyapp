package org.dougllas.mymoney.repository;

import org.dougllas.mymoney.model.Debit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitRepository extends JpaRepository<Debit, Integer> {

}