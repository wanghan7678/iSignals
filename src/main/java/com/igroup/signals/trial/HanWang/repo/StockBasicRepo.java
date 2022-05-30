package com.igroup.signals.trial.HanWang.repo;

import com.igroup.signals.trial.HanWang.model.StockBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockBasicRepo extends JpaRepository<StockBasic, Long>
{

    StockBasic findStockBasicByTsCode(String tsCode);

    @Query(value = "SELECT ts_code FROM stock_basic b WHERE ts_code like %?1% " +
            "OR name like %?1% LIMIT 1", nativeQuery = true)
    String findTsCodeBySearch(String searchQuery);

    @Query(value = "SELECT *  FROM stock_basic b WHERE ts_code like %?1% " +
            "OR name like %?1% LIMIT 1", nativeQuery = true)
    StockBasic findStockBasicBySearch(String searchQuery);
}
