package org.dougllas.mymoney.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Credit implements Serializable, org.dougllas.mymoney.generic.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "{validation.campo.name.empty}")
    @NotNull(message = "{validation.campo.name.null}")
    private String name;

    @Column
    @NotNull(message = "{validation.campo.value.null}")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private BigDecimal value;

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
}
