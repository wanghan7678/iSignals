package com.igroup.signals.trial.HanWang.model;

import java.time.LocalDate;
import java.util.List;

public class StockCandleData {

    private String tsCode;
    private LocalDate lastDay;

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public void setLastDay(LocalDate lastDay) {
        this.lastDay = lastDay;
    }

    private List<LocalDate> tradeDates;
    private List<List<Float>> tradeData;

    public List<LocalDate> getTradeDates() {
        return tradeDates;
    }

    public void setTradeDates(List<LocalDate> tradeDates) {
        this.tradeDates = tradeDates;
    }

    public List<List<Float>> getTradeData() {
        return tradeData;
    }

    public void setTradeData(List<List<Float>> tradeData) {
        this.tradeData = tradeData;
    }
}
