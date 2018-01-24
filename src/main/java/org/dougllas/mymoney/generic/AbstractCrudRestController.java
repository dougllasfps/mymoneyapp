package org.dougllas.mymoney.generic;

import org.dougllas.mymoney.exceptionhandler.BadRequestException;
import org.dougllas.mymoney.exceptionhandler.ResourceNotFountException;
import org.dougllas.mymoney.exceptionhandler.ValidationHandlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.net.URI;

public class AbstractCrudRestController<E extends Entity, ID extends Serializable, R extends JpaRepository> implements CrudController<E,ID>, ValidationHandlerController {

    @Autowired
    private R repository;

    public R getRepository() {
        return repository;
    }

    @Override
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity findOne( @PathVariable("id") ID id) {
        E entity = (E) repository.findOne(id);
        if(entity == null){
            throw new ResourceNotFountException("Item Não encontrado.");
        }
        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity save( @RequestBody @Valid E entity ) {
        repository.save(entity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity update( @RequestBody @Valid E entity, @PathVariable("id") ID id) {
        validateResource(id);

        if(!entity.getId().equals(id)){
            throw new BadRequestException("Id passado está diferente do id da entidade.");
        }

        repository.save(entity);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity delete( @PathVariable("id") ID id) {
        validateResource(id);
        repository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private void validateResource(ID id) {
        E existent = (E) repository.findOne(id);
        if(existent == null){
            throw new ResourceNotFountException("Item Não encontrado.");
        }
    }
}
