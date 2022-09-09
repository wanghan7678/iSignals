package com.igroup.signals.trial.HanWang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prediction_algorithm")
public class PredictionAlgorithm
{
    @Id
    @Column(nullable = false, updatable = false)
    private Integer algorithmCode;

    private String algorithmName;
    private String parameters;
    private String type;
    private int predictDays;

    public Integer getAlgorithmCode() {
        return algorithmCode;
    }

    public void setAlgorithmCode(Integer algorithmCode) {
        this.algorithmCode = algorithmCode;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPredictDays() {
        return predictDays;
    }

    public void setPredictDays(int predictDays) {
        this.predictDays = predictDays;
    }
}
