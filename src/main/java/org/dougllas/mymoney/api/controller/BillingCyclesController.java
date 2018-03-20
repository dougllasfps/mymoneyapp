package org.dougllas.mymoney.api.controller;

import org.dougllas.mymoney.api.Response;
import org.dougllas.mymoney.exceptionhandler.BadRequestException;
import org.dougllas.mymoney.generic.ErrorHandler;
import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.User;
import org.dougllas.mymoney.model.dto.BillingCycleDTO;
import org.dougllas.mymoney.model.Summary;
import org.dougllas.mymoney.service.BillingCycleService;
import org.dougllas.mymoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Criado por dougllas.sousa em 01/02/2018.
 */

@RestController
@RequestMapping("/api/billingCycles")
public class BillingCyclesController implements Serializable, ErrorHandler {

    @Autowired
    private BillingCycleService service;

    @Autowired
    private UserService userService;

    public BillingCycleService getService() {
        return service;
    }

    public void setService(BillingCycleService service) {
        this.service = service;
    }

    @GetMapping("summary")
    public ResponseEntity<Summary> getSummary(){
        Summary summary = new Summary();
        summary.setCredit(BigDecimal.valueOf(6000));
        summary.setDebt(BigDecimal.valueOf(1200));
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity findAll(@PathVariable("userId") Integer userId) {
        if(!userService.findUserById(userId).isPresent()){
            return ResponseEntity.badRequest().body(Response.createResponse("Usuário não encontrado para o Id passado"));
        }

        List<BillingCycleDTO> dtoList = new ArrayList<>();
        getService().findAll(true, userId).forEach( b -> dtoList.add(BillingCycleDTO.entityToDTO(b)));
        return new ResponseEntity(Response.createResponse(dtoList), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity findOne( @PathVariable("id") Integer id) {
        Optional<BillingCycle> optional = getService().findById(id, false);

        Response<BillingCycleDTO> response = new Response();

        if(!optional.isPresent()){
            response.getErrors().add("Item Não encontrado.");
        }

        if (response.hasErrors()) {
            return ResponseEntity.badRequest().body(response);
        }

        BillingCycleDTO billingCycleDTO = BillingCycleDTO.entityToDTO(optional.get());
        return new ResponseEntity(Response.createResponse(billingCycleDTO), HttpStatus.OK);
    }

    @GetMapping("/creditsAndDebits/{id}")
    public ResponseEntity findOneWithCreditsAndDebits( @PathVariable("id") Integer id) {
        Optional<BillingCycle> optional = getService().findById(id, true);

        Response<BillingCycleDTO> response = new Response();

        if(!optional.isPresent()){
            response.getErrors().add("Item Não encontrado.");
        }

        if (response.hasErrors()) {
            return ResponseEntity.badRequest().body(response);
        }

        BillingCycleDTO billingCycleDTO = BillingCycleDTO.entityToDTO(optional.get());
        return new ResponseEntity(Response.createResponse(billingCycleDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response<BillingCycleDTO>> save(@RequestBody @Valid BillingCycleDTO values , BindingResult result ) {
        Response<BillingCycleDTO> response = new Response();

        if (handleErrors(result, response)) {
            return ResponseEntity.badRequest().body(response);
        }

        BillingCycle entity = BillingCycleDTO.toEntity(values);
        Optional<Integer> userId = Optional.ofNullable(values.getUserId());

        Integer integerUserId = userId.get();

        Optional<User> user = userService.findUserById(integerUserId);

        if(!user.isPresent()){
            response.getErrors().add("Usuário não encontrado para o Id passado.");
            return ResponseEntity.badRequest().body(response);
        }

        entity.setUser(user.get());
        getService().save(entity);
        return ResponseEntity.ok(Response.createResponse(BillingCycleDTO.entityToDTO(entity)));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody @Valid BillingCycleDTO dto, @PathVariable("id") Integer id, BindingResult bindingResult) {
        validateResource(id, bindingResult);

        Response<BillingCycleDTO> response = new Response();

        if (handleErrors(bindingResult, response)) {
            return ResponseEntity.badRequest().body(response);
        }

        BillingCycle entity = BillingCycleDTO.toEntity(dto);

        if(!entity.getId().equals(id)){
            throw new BadRequestException("Id passado está diferente do id da entidade.");
        }

        getService().save(entity);
        return ResponseEntity.ok(BillingCycleDTO.entityToDTO(entity));
    }

    public void validateResource(@PathVariable("id") Integer id, BindingResult bindingResult) {
        Optional<BillingCycle> optional = getService().findById(id, false);

        if(!optional.isPresent()){
            bindingResult.addError(new ObjectError("entidade","Item Não encontrado."));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete( @PathVariable("id") Integer id) {
        getService().delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}