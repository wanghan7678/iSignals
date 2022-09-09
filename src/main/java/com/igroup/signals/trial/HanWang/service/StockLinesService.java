package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.StockCandleData;
import com.igroup.signals.trial.HanWang.model.StockDayLine;
import com.igroup.signals.trial.HanWang.repo.StockDayLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockLinesService {

    private StockDayLineRepo stockDayLineRepo;

    @Autowired
    public StockLinesService(StockDayLineRepo stockDayLineRepo)
    {
        this.stockDayLineRepo = stockDayLineRepo;
    }

    public StockCandleData findCandleDataDays(String tsCode, LocalDate tradeDate, int days)
    {
        List<StockDayLine> stockDayLines = stockDayLineRepo.findDayLines(tsCode, tradeDate, days);
        List<LocalDate> tradeDates = new ArrayList<>();
        List<List<Float>> data = new ArrayList<>();
        for (StockDayLine stockDayLine : stockDayLines)
        {
            if (stockDayLine.ifDataIntegrated())
            {
                tradeDates.add(stockDayLine.getTradeDate());
                List<Float> prices = new ArrayList<>();
                prices.add(stockDayLine.getOpen());
                prices.add(stockDayLine.getClose());
                prices.add(stockDayLine.getLow());
                prices.add(stockDayLine.getHigh());
                data.add(prices);
            }
        }
        StockCandleData stockCandleData = new StockCandleData();
        stockCandleData.setTsCode(tsCode);
        stockCandleData.setLastDay(tradeDate);
        stockCandleData.setTradeDates(tradeDates);
        stockCandleData.setTradeData(data);
        return stockCandleData;
    }
}
