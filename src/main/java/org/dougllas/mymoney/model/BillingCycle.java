package org.dougllas.mymoney.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
public class BillingCycle implements Serializable, org.dougllas.mymoney.generic.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer month;

    @Column
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "billingCycle")
    private List<Credit> credits;

    @OneToMany(mappedBy = "billingCycle")
    private List<Debit> debits;

    public BillingCycle() {}

    public BillingCycle(String name, Integer month, Integer ano) {
        this.name = name;
        this.month = month;
        this.ano = ano;
    }

    public BillingCycle(Integer id, String name, Integer month, Integer ano) {
        this.id = id;
        this.name = name;
        this.month = month;
        this.ano = ano;
    }

    public BillingCycle(Integer id, String name, Integer month, Integer ano, List<Credit> credits, List<Debit> debits) {
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

    public List<Credit> getCredits() {
        return credits == null ? Collections.emptyList() : credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Debit> getDebits() {
        return debits;
    }

    public void setDebits(List<Debit> debits) {
        this.debits = debits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
