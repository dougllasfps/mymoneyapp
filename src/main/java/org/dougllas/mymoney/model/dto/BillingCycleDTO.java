package org.dougllas.mymoney.model.dto;

import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.Credit;
import org.dougllas.mymoney.model.Debit;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Criado por dougllas.sousa em 28/02/2018.
 */

public class BillingCycleDTO implements Serializable{

    private Integer id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Range(min = 1, max = 12)
    private Integer month;

    @NotNull
    @Range(min = 1970, max = 2100)
    private Integer ano;

    private List<CreditDTO> credits;

    private List<DebitDTO> debits;

    public BillingCycleDTO() {
    }

    public BillingCycleDTO(Integer id, String name, Integer month, Integer ano, List<CreditDTO> credits, List<DebitDTO> debits) {
        this.id = id;
        this.name = name;
        this.month = month;
        this.ano = ano;
        this.credits = credits;
        this.debits = debits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<CreditDTO> getCredits() {
        return credits == null ? Collections.emptyList() : credits;
    }

    public void setCredits(List<CreditDTO> credits) {
        this.credits = credits == null ? Collections.emptyList() : credits;
    }

    public List<DebitDTO> getDebits() {
        return debits;
    }

    public void setDebits(List<DebitDTO> debits) {
        this.debits = debits;
    }

    public static BillingCycle toEntity(BillingCycleDTO dto){

        if(dto == null) return null;

        List<Credit> credits = new ArrayList<>();
        dto.getCredits().forEach( c -> credits.add(CreditDTO.toEntity(c)) );

        List<Debit> debits = new ArrayList<>();
        dto.getDebits().forEach( d -> debits.add(DebitDTO.toEntity(d)) );

        return new BillingCycle(dto.id, dto.name, dto.month, dto.ano, credits, debits);
    }

    public static BillingCycleDTO entityToDTO(BillingCycle entity){
        if(entity == null) return  null;
        List<CreditDTO> credits = new ArrayList<>();

        entity.getCredits().forEach(c -> {
            CreditDTO e = CreditDTO.entityToDTO(c);
            credits.add(e);
        });

        List<DebitDTO> debits = new ArrayList<>();

        entity.getDebits().forEach(d -> {
            DebitDTO e = DebitDTO.entityToDTO(d);
            debits.add(e);
        });

        return new BillingCycleDTO(entity.getId(), entity.getName(), entity.getMonth(), entity.getAno(), credits, debits );
    }
}