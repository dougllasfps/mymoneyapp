package org.dougllas.mymoney.generic;

import org.dougllas.mymoney.api.Response;
import org.dougllas.mymoney.exceptionhandler.BadRequestException;
import org.dougllas.mymoney.exceptionhandler.ValidationHandlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

public class AbstractCrudRestController<E extends Entity, ID extends Serializable, R extends JpaRepository> implements CrudController<E,ID>, ValidationHandlerController, ErrorHandler {

    @Autowired
    private R repository;

    public R getRepository() {
        return repository;
    }

    public void setRepository(R repository) {
        this.repository = repository;
    }

    @Override
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(Response.createResponse(getRepository().findAll()), HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity findOne( @PathVariable("id") ID id, BindingResult result) {
        E entity = validateResource(id, result);
        Response<E> response = new Response();

        if (handleErrors(result, response)) {
            return ResponseEntity.badRequest().body(response);
        }

        return new ResponseEntity(Response.createResponse(entity), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<Response<E>> save( @RequestBody @Valid E entity , BindingResult result ) {
        Response<E> response = new Response();
        if (handleErrors(result, response)) return ResponseEntity.badRequest().body(response);
        getRepository().save(entity);
        return ResponseEntity.ok(Response.createResponse(entity));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity update( @RequestBody @Valid E entity, @PathVariable("id") ID id, BindingResult bindingResult) {
        validateResource(id,bindingResult);

        Response<E> response = new Response();
        if (handleErrors(bindingResult, response)) return ResponseEntity.badRequest().body(response);

        if(!entity.getId().equals(id)){
            throw new BadRequestException("Id passado está diferente do id da entidade.");
        }

        getRepository().save(entity);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity delete( @PathVariable("id") ID id) {
        getRepository().delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private E validateResource(ID id, BindingResult bindingResult) {
        E existent = (E) getRepository().findOne(id);
        if(existent == null){
            bindingResult.addError(new ObjectError("entidade","Item Não encontrado."));
        }
        return existent;
    }
}
