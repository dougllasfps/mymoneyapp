package org.dougllas.mymoney.generic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Criado por dougllas.sousa em 27/02/2018.
 */
public class AbstractCrudRestControllerTest {

    @Mock
    BindingResult bindingResult;
    @Mock
    AbstractCrudRestController abstractCrudRestController;
//    @Mock
//    JpaRepository repo

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOne(){
        when(abstractCrudRestController.getRepository()).thenReturn(any(JpaRepository.class));
        when(abstractCrudRestController.getRepository().findOne(any(Serializable.class))).thenReturn(null);

        abstractCrudRestController.findOne( any(Serializable.class), any(BindingResult.class) );
    }
}
