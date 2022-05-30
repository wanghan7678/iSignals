package com.igroup.signals.trial.HanWang.controler;

import com.igroup.signals.trial.HanWang.model.*;
import com.igroup.signals.trial.HanWang.service.GoogleSearchService;
import com.igroup.signals.trial.HanWang.service.StockBasicService;
import com.igroup.signals.trial.HanWang.service.TushareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stockbasic")
public class StockBasicResource {

    @Autowired
    private final StockBasicService stockBasicService;

    @Autowired
    private final TushareService tushareService;

    @Autowired
    private final GoogleSearchService googleSearchService;

    public StockBasicResource(StockBasicService stockBasicService, TushareService tushareService, GoogleSearchService googleSearchService) {
        this.stockBasicService = stockBasicService;
        this.tushareService = tushareService;
        this.googleSearchService = googleSearchService;
    }

    @GetMapping
    public ResponseEntity<List<StockBasic>> getAllStockBasic()
    {
        List<StockBasic> stockBasics = stockBasicService.findAllStockBasic();
        return new ResponseEntity<>(stockBasics, HttpStatus.OK);
    }

    @GetMapping("/{tscode}")
    public ResponseEntity<StockBasic> getStockBasicByTsCode(@PathVariable("tscode") String tsCode)
    {
        StockBasic stockBasic = stockBasicService.findStockBasicByTsCode(tsCode);
        return new ResponseEntity<>(stockBasic, HttpStatus.OK);
    }




    @GetMapping("/search/{search}")
    public ResponseEntity<PageStockBasic> searchStock(@PathVariable("search") String searchQuery) throws Exception
    {
        StockBasic stockBasic = stockBasicService.findStockBasicBySearch(searchQuery);
        PageStockBasic pageStockBasic = new PageStockBasic();
        if (stockBasic != null)
        {

            pageStockBasic.setArea(stockBasic.getArea());
            pageStockBasic.setFullName(stockBasic.getFullName());
            pageStockBasic.setExchange(stockBasic.getExchange());
            pageStockBasic.setName(stockBasic.getName());
            pageStockBasic.setTsCode(stockBasic.getTsCode());
            pageStockBasic.setIndustry(stockBasic.getIndustry());
            StockCompany stockCompany = tushareService.getStockCompanyByTscode(stockBasic.getTsCode());
            pageStockBasic.setCity(stockCompany.getCity());
            pageStockBasic.setIntroduction(stockCompany.getIntroduction());
            pageStockBasic.setMainBusiness(stockCompany.getMainBusiness());
            pageStockBasic.setProvince(stockCompany.getProvince());
            pageStockBasic.setWebsite(stockCompany.getWebsite());
        }
        return new ResponseEntity<>(pageStockBasic, HttpStatus.OK);
    }

}
