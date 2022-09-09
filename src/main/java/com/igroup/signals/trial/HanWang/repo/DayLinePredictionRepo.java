package com.igroup.signals.trial.HanWang.repo;

import com.igroup.signals.trial.HanWang.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DayLinePredictionRepo extends JpaRepository<Prediction, Long>
{
    @Query(value = "SELECT p FROM Prediction p JOIN p.predictAlgorithm where p.tsCode = :tsCode and p.predictDate = :tradeDate ")
    List<Prediction> findPredictionByTsCodeTradeDate(String tsCode, LocalDate tradeDate);
}
