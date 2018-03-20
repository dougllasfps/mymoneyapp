package org.dougllas.mymoney.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dougllas.mymoney.model.BillingCycle;
import org.dougllas.mymoney.model.Credit;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Criado por dougllas.sousa em 28/02/2018.
 */

public class CreditDTO implements Serializable {

    private Integer id;

//    @NotBlank(message = "{validation.campo.name.empty}")
//    @NotNull(message = "{validation.campo.name.null}")
    private String name;

//    @NotNull(message = "{validation.campo.value.null}")
    private BigDecimal value;

    @JsonIgnore
    private BillingCycle billingCycle;

    public CreditDTO() {
    }

    public CreditDTO(Integer id, String name, BigDecimal value, BillingCycle billingCycle) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.billingCycle = billingCycle;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    public static Credit toEntity(CreditDTO dto){
        return new Credit(dto.id, dto.name, dto.value, dto.billingCycle);
    }

    public static CreditDTO entityToDTO(Credit credit){
        if(credit == null) return null;
        return new CreditDTO(credit.getId(), credit.getName(), credit.getValue(), credit.getBillingCycle());
    }
}
