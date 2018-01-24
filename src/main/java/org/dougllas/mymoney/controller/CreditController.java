package org.dougllas.mymoney.controller;

import org.dougllas.mymoney.generic.AbstractCrudRestController;
import org.dougllas.mymoney.model.Credit;
import org.dougllas.mymoney.repository.CreditRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credits")
public class CreditController extends AbstractCrudRestController<Credit, Integer, CreditRepository> {

}