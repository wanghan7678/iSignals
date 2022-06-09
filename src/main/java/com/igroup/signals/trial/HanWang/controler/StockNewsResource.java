package com.igroup.signals.trial.HanWang.controler;

import com.igroup.signals.trial.HanWang.model.NewsLink;
import com.igroup.signals.trial.HanWang.model.StockRealTime;
import com.igroup.signals.trial.HanWang.service.GoogleSearchService;
import com.igroup.signals.trial.HanWang.service.RealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class StockNewsResource {

    @Autowired
    private final GoogleSearchService googleSearchService;

    public StockNewsResource(GoogleSearchService googleSearchService) {
        this.googleSearchService = googleSearchService;
    }

    @GetMapping("/{tscode}")
    public ResponseEntity<List<NewsLink>> getNewsByTsCode(@PathVariable("tscode") String tsCode) throws Exception
    {
        List<NewsLink> stockNews = googleSearchService.getSearchNewsByTsCode(tsCode);
        return new ResponseEntity<>(stockNews, HttpStatus.OK);
    }
}
