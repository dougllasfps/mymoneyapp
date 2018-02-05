package org.dougllas.mymoney.model;

import java.math.BigDecimal;

/**
 * Criado por dougllas.sousa em 01/02/2018.
 */
public class Summary {

    private BigDecimal credit;
    private BigDecimal debt;

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }
}