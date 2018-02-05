package org.dougllas.mymoney.controller;

import org.dougllas.mymoney.model.Summary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Criado por dougllas.sousa em 01/02/2018.
 */

@RestController
@RequestMapping("/api/billingCycles")
public class BillingCyclesController {

    @GetMapping("summary")
    public ResponseEntity<Summary> getSummary(){
        Summary summary = new Summary();
        summary.setCredit(BigDecimal.valueOf(100));
        summary.setDebt(BigDecimal.valueOf(200));
        return ResponseEntity.ok(summary);
    }

}