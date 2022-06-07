package com.igroup.signals.trial.HanWang.controler;

import com.igroup.signals.trial.HanWang.model.StockBasic;
import com.igroup.signals.trial.HanWang.model.StockRealTime;
import com.igroup.signals.trial.HanWang.service.RealTimeService;
import com.igroup.signals.trial.HanWang.util.TushareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realtime")
public class StockRealTimeResource
{
    @Autowired
    private final RealTimeService realTimeService;

    public StockRealTimeResource(RealTimeService realTimeService) {
        this.realTimeService = realTimeService;
    }

    @GetMapping("/{tscode}")
    public ResponseEntity<StockRealTime> getStockRealTimeByTsCode(@PathVariable("tscode") String tsCode) throws Exception
    {
        StockRealTime stockRealTime = realTimeService.getStockRealTime(tsCode);
        if (stockRealTime != null)
        {
            stockRealTime.setCode(tsCode);
        }
        return new ResponseEntity<>(stockRealTime, HttpStatus.OK);
    }

}
