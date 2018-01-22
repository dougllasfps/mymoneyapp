package org.dougllas.mymoney.cfg;

import org.dougllas.mymoney.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeforeStart implements CommandLineRunner{

    @Autowired
    private CreditRepository creditRepository;

    public void run(String... strings) throws Exception {
//        Credit credit = new Credit();
//        credit.setValue(BigDecimal.ONE);
//        credit.setName("Teste");
//
//        creditRepository.save(credit);
//
//        creditRepository.findOne(1);
    }
}
