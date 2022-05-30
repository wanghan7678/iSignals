package com.igroup.signals.trial.HanWang.model;

import javax.persistence.*;

@Entity
public class StockCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String tsCode;
    private String exchange;
    private String province;
    private String city;
    private String introduction;
    private String website;
    private String mainBusiness;

    public Long getId() {
        return id;
    }

    public String getTsCode() {
        return tsCode;
    }

    public String getExchange() {
        return exchange;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getWebsite() {
        return website;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }
}
