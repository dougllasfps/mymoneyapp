package org.dougllas.mymoney.cfg;

import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.Credit;
import org.dougllas.mymoney.repository.BillingCycleRepository;
import org.dougllas.mymoney.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class BeforeStart implements CommandLineRunner{
    public void run(String... strings) throws Exception {
    }
}
