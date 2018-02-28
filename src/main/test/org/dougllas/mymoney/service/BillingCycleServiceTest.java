package org.dougllas.mymoney.service;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Criado por dougllas.sousa em 28/02/2018.
 */
public class BillingCycleServiceTest {

    @Mock
    BillingCycleService billingCycleService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    public void deveTrazerListaComDependencias(){
//        billingCycleService.findAll()
    }
}
