package org.dougllas.mymoney.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dougllas.mymoney.model.Debit;
import org.dougllas.mymoney.model.DebitStatus;

import java.io.Serializable;
import java.math.BigDecimal;

public class DebitDTO implements Serializable {

    private Integer id;

//    @NotNull(message = "{validation.campo.name.null}")
//    @NotEmpty
    private String name;

//    @NotNull(message = "{validation.campo.value.null}")
    private BigDecimal value;

//    @NotNull(message = "{validation.campo.status.null}")
    private DebitStatus status;

    @JsonIgnore
    private BillingCycleDTO billingCycle;

    public DebitDTO() {
    }

    public DebitDTO(Integer id, String name, BigDecimal value, DebitStatus status, BillingCycleDTO billingCycle) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.status = status;
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

    public DebitStatus getStatus() {
        return status;
    }

    public void setStatus(DebitStatus status) {
        this.status = status;
    }

    public BillingCycleDTO getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycleDTO billingCycle) {
        this.billingCycle = billingCycle;
    }

    public static Debit toEntity(DebitDTO dto){
        return new Debit(dto.id, dto.name, dto.value, dto.status, null);
    }

    public static DebitDTO entityToDTO(Debit credit){
        return new DebitDTO( credit.getId(), credit.getName(), credit.getValue(), credit.getStatus(), null);
    }
}