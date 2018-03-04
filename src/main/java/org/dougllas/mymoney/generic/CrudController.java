package org.dougllas.mymoney.generic;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.io.Serializable;

public interface CrudController<E extends Entity, ID extends Serializable> {

    ResponseEntity findAll();

    ResponseEntity findOne(ID id, BindingResult result);

    ResponseEntity save(@Valid E entity, BindingResult bindingResult);

    ResponseEntity update(@Valid E entity, ID id, BindingResult bindingResult);

    ResponseEntity delete(ID id);

}