package com.igroup.signals.trial.HanWang.repo;

import com.igroup.signals.trial.HanWang.model.StockDayLine;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface StockDayLineRepo  extends JpaRepository<StockDayLine, Long>
{
    /*
    @Query(value="SELECT l from StockDayLine WHERE l.tsCode = :tsCode and l.tradeDate <= :tradeDate")
    List<StockDayLine> findDayLines(String tsCode, LocalDate tradeDate, Pageable pageable);

    default List<StockDayLine> find60DayLines(String tsCode, LocalDate tradeDate)
    {
        return findDayLines(tsCode, tradeDate, (Pageable) PageRequest.of(0, 60, Sort.sort(StockDayLine.class).by(StockDayLine::getTradeDate).descending()));
    }
     */

    @Query(value="SELECT * from stock_day_line where ts_code = :tsCode and trade_date <= :tradeDate order by trade_date desc limit :offset", nativeQuery = true)
    List<StockDayLine> findDayLines(String tsCode, LocalDate tradeDate, int offset);

    default List<StockDayLine> find60DayLines(String tsCode, LocalDate tradeDate)
    {
        return findDayLines(tsCode, tradeDate, 60);
    }


}
