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

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private BillingCycleRepository billingCycleRepository;

    public void run(String... strings) throws Exception {
        Credit credit = new Credit();
        credit.setValue(BigDecimal.ONE);
        credit.setName("Teste");

        creditRepository.save(credit);

        creditRepository.findOne(1);

        List<BillingCycle> list = Arrays.asList(
                new BillingCycle("Janeiro 2018", 1, 2018),
                new BillingCycle("Fevereiro 2018", 2, 2018)
        );

        list.forEach( obj -> billingCycleRepository.save(obj) );
    }
}
