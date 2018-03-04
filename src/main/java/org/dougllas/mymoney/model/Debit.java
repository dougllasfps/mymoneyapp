package org.dougllas.mymoney.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Debit implements Serializable, org.dougllas.mymoney.generic.Entity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal value;

    @Column
    @Enumerated(EnumType.STRING)
    private DebitStatus status;

    @ManyToOne
    @JoinColumn(name = "billing_cycle")
    private BillingCycle billingCycle;

    public Debit() {
    }

    public Debit(String name, BigDecimal value, DebitStatus status, BillingCycle billingCycle) {
        this.name = name;
        this.value = value;
        this.status = status;
        this.billingCycle = billingCycle;
    }

    public Debit(Integer id, String name, BigDecimal value, DebitStatus status, BillingCycle billingCycle) {
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

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

}
