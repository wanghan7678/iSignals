package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.Prediction;
import com.igroup.signals.trial.HanWang.repo.DayLinePredictionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PredictionService {

    @Autowired
    private final DayLinePredictionRepo dayLinePredictionRepo;


    public PredictionService(DayLinePredictionRepo dayLinePredictionRepo) {
        this.dayLinePredictionRepo = dayLinePredictionRepo;
    }

    public List<Prediction> getPredictionByDate(String tsCode, LocalDate tradeDate)
    {
        return dayLinePredictionRepo.findPredictionByTsCodeTradeDate(tsCode, tradeDate);
    }
}
