package com.igroup.signals.trial.HanWang.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prediction")
public class Prediction
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String tsCode;
    private LocalDate predictDate;
    private int signalCode;
    private String valueName;
    private int predictDays;

    @Column(insertable = false, updatable = false)
    private int algorithmCode;

    private float predictValue;
    private float predictScore;
    private String scoreMethod;
    private float labelValue;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "algorithmCode")
    private PredictionAlgorithm predictAlgorithm;

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

    public LocalDate getPredictDate() {
        return predictDate;
    }

    public void setPredictDate(LocalDate predictDate) {
        this.predictDate = predictDate;
    }

    public int getSignalCode() {
        return signalCode;
    }

    public void setSignalCode(int signalCode) {
        this.signalCode = signalCode;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public int getPredictDays() {
        return predictDays;
    }

    public void setPredictDays(int predictDays) {
        this.predictDays = predictDays;
    }

    public int getAlgorithmCode() {
        return algorithmCode;
    }

    public void setAlgorithmCode(int algorithmCode) {
        this.algorithmCode = algorithmCode;
    }

    public float getPredictValue() {
        return predictValue;
    }

    public void setPredictValue(float predictValue) {
        this.predictValue = predictValue;
    }

    public float getPredictScore() {
        return predictScore;
    }

    public void setPredictScore(float predictScore) {
        this.predictScore = predictScore;
    }

    public String getScoreMethod() {
        return scoreMethod;
    }

    public void setScoreMethod(String scoreMethod) {
        this.scoreMethod = scoreMethod;
    }

    public float getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(float labelValue) {
        this.labelValue = labelValue;
    }

    public PredictionAlgorithm getPredictAlgorithm() {
        return predictAlgorithm;
    }

    public void setPredictAlgorithm(PredictionAlgorithm predictAlgorithm) {
        this.predictAlgorithm = predictAlgorithm;
    }
}
