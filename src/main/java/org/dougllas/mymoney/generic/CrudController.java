package org.dougllas.mymoney.generic;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface CrudController<E extends Entity, ID extends Serializable> {

    ResponseEntity findAll();

    ResponseEntity findOne(ID id);

    ResponseEntity save(E entity);

    ResponseEntity update(E entity, ID id);

    ResponseEntity delete(ID id);

}