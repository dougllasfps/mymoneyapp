package org.dougllas.mymoney.controller;

import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.Summary;
import org.dougllas.mymoney.repository.BillingCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Criado por dougllas.sousa em 01/02/2018.
 */

@RestController
@RequestMapping("/api/billingCycles")
public class BillingCyclesController {

    @Autowired
    private BillingCycleRepository billingCycleRepository;

    @GetMapping("summary")
    public ResponseEntity<Summary> getSummary(){
        Summary summary = new Summary();
        summary.setCredit(BigDecimal.valueOf(100));
        summary.setDebt(BigDecimal.valueOf(200));
        return ResponseEntity.ok(summary);
    }

    @GetMapping
    public ResponseEntity<List<BillingCycle>> all(){
        return ResponseEntity.ok(billingCycleRepository.findAll());
    }

}