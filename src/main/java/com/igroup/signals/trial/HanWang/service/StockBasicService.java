package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.StockBasic;
import com.igroup.signals.trial.HanWang.model.StockCandleData;
import com.igroup.signals.trial.HanWang.model.StockDayLine;
import com.igroup.signals.trial.HanWang.repo.StockBasicRepo;
import com.igroup.signals.trial.HanWang.repo.StockDayLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockBasicService {

    private final StockBasicRepo stockBasicRepo;

    @Autowired
    public StockBasicService(StockBasicRepo stockBasicRepo, StockDayLineRepo stockDayLineRepo) {
        this.stockBasicRepo = stockBasicRepo;
    }

    public List<StockBasic> findAllStockBasic()
    {
        return stockBasicRepo.findAll();
    }

    public StockBasic findStockBasicByTsCode(String tsCode)
    {
        return stockBasicRepo.findStockBasicByTsCode(tsCode);
    }


    public String findTsCodeBySearch(String searchQuery)
    {
        return stockBasicRepo.findTsCodeBySearch(searchQuery);
    }

    public StockBasic findStockBasicBySearch(String searchQuery)
    {
        return stockBasicRepo.findStockBasicBySearch(searchQuery);
    }



}
