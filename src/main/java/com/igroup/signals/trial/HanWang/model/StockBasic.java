package com.igroup.signals.trial.HanWang.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StockBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String tsCode;
    private String symbol;
    private String name;
    private String area;
    private String industry;
    private String fullName;
    private String enName;
    private String cnSpell;
    private String market;
    private String exchange;
    private String currType;
    private String listStatus;
    private Date listDate;
    private Date delistDate;
    private String isHs;

    public StockBasic() {
    }

    public StockBasic(Long id, String tsCode, String symbol, String name, String area, String industry, String fullName, String enName, String cnSpell, String market, String exchange, String currType, String listStatus, Date listDate, Date delistDate, String isHs) {
        this.id = id;
        this.tsCode = tsCode;
        this.symbol = symbol;
        this.name = name;
        this.area = area;
        this.industry = industry;
        this.fullName = fullName;
        this.enName = enName;
        this.cnSpell = cnSpell;
        this.market = market;
        this.exchange = exchange;
        this.currType = currType;
        this.listStatus = listStatus;
        this.listDate = listDate;
        this.delistDate = delistDate;
        this.isHs = isHs;
    }

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnSpell() {
        return cnSpell;
    }

    public void setCnSpell(String cnSpell) {
        this.cnSpell = cnSpell;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getCurrType() {
        return currType;
    }

    public void setCurrType(String currType) {
        this.currType = currType;
    }

    public String getListStatus() {
        return listStatus;
    }

    public void setListStatus(String listStatus) {
        this.listStatus = listStatus;
    }

    public Date getListDate() {
        return listDate;
    }

    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    public Date getDelistDate() {
        return delistDate;
    }

    public void setDelistDate(Date delistDate) {
        this.delistDate = delistDate;
    }

    public String getIsHs() {
        return isHs;
    }

    public void setIsHs(String isHs) {
        this.isHs = isHs;
    }
}
