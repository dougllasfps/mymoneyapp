package org.dougllas.mymoney.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Criado por dougllas.sousa em 28/02/2018.
 */

@Entity
public class Credit implements Serializable, org.dougllas.mymoney.generic.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(precision = 16, scale = 2)
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "billing_cycle")
    private BillingCycle billingCycle;

    public Credit() {
    }

    public Credit(String name, BigDecimal value, BillingCycle billingCycle) {
        this.name = name;
        this.value = value;
        this.billingCycle = billingCycle;
    }

    public Credit(Integer id, String name, BigDecimal value, BillingCycle billingCycle) {
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
}
