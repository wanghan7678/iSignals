package com.igroup.signals.trial.HanWang.controler;

import com.igroup.signals.trial.HanWang.model.StockCandleData;
import com.igroup.signals.trial.HanWang.service.StockBasicService;
import com.igroup.signals.trial.HanWang.service.StockLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/stockdayline")
public class StockDayLineResource
{

    @Autowired
    private final StockLinesService stockLinesService;


    public StockDayLineResource(StockLinesService stockLinesService) {
        this.stockLinesService = stockLinesService;
    }

    @GetMapping("/{tscode}")
    public ResponseEntity<StockCandleData> getStockCandleData(@PathVariable("tscode") String tsCode)
    {
        int days = 30;
        LocalDate today = LocalDate.now();
        StockCandleData stockCandleData = stockLinesService.findCandleDataDays(tsCode, today, days);
        return new ResponseEntity<>(stockCandleData, HttpStatus.OK);
    }
}
