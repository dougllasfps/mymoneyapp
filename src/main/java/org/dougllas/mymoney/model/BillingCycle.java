package org.dougllas.mymoney.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class BillingCycle implements Serializable, org.dougllas.mymoney.generic.Entity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @NotEmpty
    private String name;

    @Column
    @NotNull
    @Range(min = 1, max = 12)
    private Integer month;

    @Column
    @NotNull
    @Range(min = 1970, max = 2100)
    private Integer ano;

    public BillingCycle() {
    }

    public BillingCycle(String name, Integer month, Integer ano) {
        this.name = name;
        this.month = month;
        this.ano = ano;
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
}
