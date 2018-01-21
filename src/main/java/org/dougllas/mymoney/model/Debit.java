package org.dougllas.mymoney.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Debit implements Serializable {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @NotEmpty
    private String name;

    @Column
    @NotNull
    private BigDecimal value;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private DebitStatus status;

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
}
