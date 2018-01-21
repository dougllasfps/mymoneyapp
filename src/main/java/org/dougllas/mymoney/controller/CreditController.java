package org.dougllas.mymoney.controller;

import org.dougllas.mymoney.generic.AbstractController;
import org.dougllas.mymoney.model.Credit;
import org.dougllas.mymoney.repository.CreditRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/credits")
@Controller
public class CreditController extends AbstractController<Credit, Integer, CreditRepository> {

}