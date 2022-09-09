package com.igroup.signals.trial.HanWang.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class StockDayLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String tsCode;
    private LocalDate tradeDate;
    private Float open;
    private Float high;
    private Float low;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getClose() {
        return close;
    }

    public void setClose(Float close) {
        this.close = close;
    }

    public Float getPreClose() {
        return preClose;
    }

    public void setPreClose(Float preClose) {
        this.preClose = preClose;
    }

    public Float getChange() {
        return change;
    }

    public void setChange(Float change) {
        this.change = change;
    }

    public Float getPctChg() {
        return pctChg;
    }

    public void setPctChg(Float pctChg) {
        this.pctChg = pctChg;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Float getVol() {
        return vol;
    }

    public void setVol(Float vol) {
        this.vol = vol;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    private Float close;
    private Float preClose;
    private Float change;
    private Float pctChg;
    private Float vol;
    private Float amount;


    public boolean ifDataIntegrated()
    {
        return (close != null && close >0 && high != null && high >0
            && low != null && low > 0  && open != null && open > 0) && tsCode != null
                && tradeDate != null;
    }
}
